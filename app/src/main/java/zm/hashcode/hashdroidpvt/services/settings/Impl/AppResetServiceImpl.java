package zm.hashcode.hashdroidpvt.services.settings.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import zm.hashcode.hashdroidpvt.conf.util.App;
import zm.hashcode.hashdroidpvt.respository.election.ElectionsRepository;
import zm.hashcode.hashdroidpvt.respository.election.Impl.ElectionsRepositoryImpl;
import zm.hashcode.hashdroidpvt.respository.election.Impl.PollingStationRepositoryImpl;
import zm.hashcode.hashdroidpvt.respository.election.PollingStationRepository;
import zm.hashcode.hashdroidpvt.respository.settings.AddressTypeRepository;
import zm.hashcode.hashdroidpvt.respository.settings.ContactTypeRespository;
import zm.hashcode.hashdroidpvt.respository.settings.GenderRepository;
import zm.hashcode.hashdroidpvt.respository.settings.Impl.AddressTypeRepositoryImpl;
import zm.hashcode.hashdroidpvt.respository.settings.Impl.ContactTypeRespositoryImpl;
import zm.hashcode.hashdroidpvt.respository.settings.Impl.GenderTypeRepositoryImpl;
import zm.hashcode.hashdroidpvt.respository.settings.Impl.SettingsRepositoryImpl;
import zm.hashcode.hashdroidpvt.respository.settings.SettingsRepository;
import zm.hashcode.hashdroidpvt.services.settings.AppResetService;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class AppResetServiceImpl extends IntentService implements AppResetService {
    private SettingsRepository settingsRepository;
    private ContactTypeRespository contactTypeRespository;
    private GenderRepository genderRepository;
    private AddressTypeRepository addressTypeRepository;
    private ElectionsRepository electionsRepository;
    private PollingStationRepository pollingStationRepository;

    private static AppResetServiceImpl service = null;

    private AppResetServiceImpl() {
        super("AppResetServiceImpl");
    }

    public static AppResetServiceImpl getInstance() {
        if (service == null)
            service = new AppResetServiceImpl();
        return service;
    }

    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_SETTINGS = "zm.hashcode.hashdroidpvt.services.settings.action.SETTINGS";
    private static final String ACTION_POLLINGSTATION = "zm.hashcode.hashdroidpvt.services.settings.action.POLLINGSTATION";
    private static final String ACTION_METARESET = "zm.hashcode.hashdroidpvt.services.settings.action.METARESET";

    @Override
    public void startActionSettings(Context context) {
        Intent intent = new Intent(context, AppResetServiceImpl.class);
        intent.setAction(ACTION_SETTINGS);
        context.startService(intent);
    }

    @Override
    public void startActionPollingStation(Context context) {
        Intent intent = new Intent(context, AppResetServiceImpl.class);
        intent.setAction(ACTION_POLLINGSTATION);
        context.startService(intent);
    }

    @Override
    public void startActionMetaReset(Context context) {
        Intent intent = new Intent(context, AppResetServiceImpl.class);
        intent.setAction(ACTION_METARESET);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();

            //Refactor to CoR later
            if (ACTION_SETTINGS.equals(action)) {
                resetSettimgs();
            } else if (ACTION_POLLINGSTATION.equals(action)) {
                resetPolllingStationAndCandidates();
            } else if (ACTION_METARESET.equals(action)) {

                resetMetaData();
            }
        }
    }

    private void resetMetaData() {
        addressTypeRepository = new AddressTypeRepositoryImpl(App.getAppContext());
        addressTypeRepository.deleteAll();
        contactTypeRespository = new ContactTypeRespositoryImpl(App.getAppContext());
        contactTypeRespository.deleteAll();
        genderRepository = new GenderTypeRepositoryImpl(App.getAppContext());
        genderRepository.deleteAll();
    }

    private void resetPolllingStationAndCandidates() {
        electionsRepository = new ElectionsRepositoryImpl(App.getAppContext());
        electionsRepository.deleteAll();
        pollingStationRepository = new PollingStationRepositoryImpl(App.getAppContext());
        pollingStationRepository.deleteAll();
    }

    private void resetSettimgs() {
        settingsRepository = new SettingsRepositoryImpl(App.getAppContext());
        settingsRepository.deleteAll();
    }


}
