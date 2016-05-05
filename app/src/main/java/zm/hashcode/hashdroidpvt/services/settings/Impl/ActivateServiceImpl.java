package zm.hashcode.hashdroidpvt.services.settings.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.io.IOException;

import zm.hashcode.hashdroidpvt.conf.util.App;
import zm.hashcode.hashdroidpvt.conf.util.DomainState;
import zm.hashcode.hashdroidpvt.domain.person.Person;
import zm.hashcode.hashdroidpvt.domain.settings.Settings;
import zm.hashcode.hashdroidpvt.factories.settings.SettingsFactory;
import zm.hashcode.hashdroidpvt.respository.person.Impl.PersonRepositoryImpl;
import zm.hashcode.hashdroidpvt.respository.person.PersonRepository;
import zm.hashcode.hashdroidpvt.respository.settings.Impl.SettingsRepositoryImpl;
import zm.hashcode.hashdroidpvt.respository.settings.SettingsRepository;
import zm.hashcode.hashdroidpvt.restapi.settings.api.ActivateAPI;
import zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.ActivateAPIImpl;
import zm.hashcode.hashdroidpvt.services.settings.ActivateService;
import zm.hashcode.hashdroidpvt.services.settings.GetMetaDataService;

// This is a Bound Local Service
public class ActivateServiceImpl extends Service implements ActivateService {
    final private PersonRepository personRepository;
    final private SettingsRepository settingsRepository;
    final private GetMetaDataService getMetaDataService;

    private static ActivateServiceImpl service = null;

    public static ActivateServiceImpl getInstance() {
        if (service == null)
            service = new ActivateServiceImpl();
        return service;
    }

    private final IBinder localBinder = new ActivateServiceLocalBinder();

    private SettingsRepository repo;

    private ActivateServiceImpl() {
        personRepository = new PersonRepositoryImpl(App.getAppContext());
        settingsRepository = new SettingsRepositoryImpl(App.getAppContext());
        getMetaDataService = GetMetaDataServiceImpl.getInstance();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return localBinder;
    }

    public class ActivateServiceLocalBinder extends Binder {
        public ActivateServiceImpl getService() {
            return ActivateServiceImpl.this;
        }
    }


    @Override
    public String activateAccount(String email, String password) {
        String state = DomainState.NOTACTIVATED.name();
        ActivateAPI api = new ActivateAPIImpl();
        try {
            Person person = api.activateAccount(email, password);
            if (person.getToken() != "NONE") {
                Settings settings = SettingsFactory.getSettings(email, person.getOrganisation(), person.getToken());
                Settings savedSettings = settingsRepository.save(settings);
                Person savedPerson = personRepository.save(person);
                if (savedSettings.getId() != null && savedPerson.getId() != null) {
                    state = DomainState.ACTIVATED.name();
                    getMetaDataService.getMetaData(App.getAppContext());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return state;

    }

    @Override
    public boolean isAccountActivated() {
        return repo.findAll().size() > 0;
    }

    @Override
    public boolean deactivateAccount() {
        int rows = repo.deleteAll();
        return rows > 0;

    }

    private Settings createSettings(Settings settings) {
        repo = new SettingsRepositoryImpl(App.getAppContext());
        return repo.save(settings);
    }
}
