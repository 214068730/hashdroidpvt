package zm.hashcode.hashdroidpvt.services.settings.Impl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import zm.hashcode.hashdroidpvt.conf.util.App;
import zm.hashcode.hashdroidpvt.conf.util.DomainState;
import zm.hashcode.hashdroidpvt.domain.settings.Settings;
import zm.hashcode.hashdroidpvt.factories.settings.SettingsFactory;
import zm.hashcode.hashdroidpvt.respository.settings.Impl.SettingsRepositoryImpl;
import zm.hashcode.hashdroidpvt.respository.settings.SettingsRepository;
import zm.hashcode.hashdroidpvt.services.settings.ActivateService;

// This is a Bound Local Service
public class ActivateServiceImpl extends Service implements ActivateService {

    private final IBinder localBinder = new ActivateServiceLocalBinder();

    private SettingsRepository repo;

    public ActivateServiceImpl() {
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
    public String activateAccount(String email, String code, String password) {
        if (true) {
            Settings settings = SettingsFactory.getSettings(email, code, password);
//            createSettings(settings);
            return DomainState.ACTIVATED.name();
        } else {
            return DomainState.NOTACTIVATED.name();
        }
    }

    @Override
    public boolean isAccountActivated() {
        return repo.findAll().size()>0;
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
