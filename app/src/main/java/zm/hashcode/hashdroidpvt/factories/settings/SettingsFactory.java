package zm.hashcode.hashdroidpvt.factories.settings;

import zm.hashcode.hashdroidpvt.domain.settings.Settings;

/**
 * Created by hashcode on 2016/04/14.
 */
public class SettingsFactory {
    public static Settings getSettings(String email,String orgCode,String password){
        return new Settings.Builder()
                .username(email)
                .password(password)
                .code(orgCode)
                .build();

    }
}
