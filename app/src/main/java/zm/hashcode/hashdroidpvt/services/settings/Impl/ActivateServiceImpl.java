package zm.hashcode.hashdroidpvt.services.settings.Impl;


import zm.hashcode.hashdroidpvt.conf.util.App;
import zm.hashcode.hashdroidpvt.conf.util.DomainState;
import zm.hashcode.hashdroidpvt.domain.settings.Settings;
import zm.hashcode.hashdroidpvt.factories.settings.SettingsFactory;
import zm.hashcode.hashdroidpvt.respository.settings.Impl.SettingsRepositoryImpl;
import zm.hashcode.hashdroidpvt.respository.settings.SettingsRepository;
import zm.hashcode.hashdroidpvt.services.settings.ActivateService;

/**
 * Created by hashcode on 2016/04/16.
 */
public class ActivateServiceImpl implements ActivateService {
    private SettingsRepository repo;

    @Override
    public String activateAccount(String email, String code, String password) {
        if (true) {
            Settings settings = SettingsFactory.getSettings(email, code, password);
            createSettings(settings);
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
    public void deactivateAccount() {
        // CAll Intent Services

    }

    private Settings createSettings(Settings settings) {
        repo = new SettingsRepositoryImpl(App.getAppContext());
        return repo.save(settings);
    }
}
