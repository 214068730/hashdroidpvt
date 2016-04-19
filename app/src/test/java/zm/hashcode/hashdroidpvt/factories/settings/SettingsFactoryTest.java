package zm.hashcode.hashdroidpvt.factories.settings;

import junit.framework.Assert;

import org.junit.Test;

import zm.hashcode.hashdroidpvt.domain.settings.Settings;

/**
 * Created by hashcode on 2016/04/14.
 */
public class SettingsFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Settings settings = SettingsFactory.getSettings("test@test.com", "USEM", "hello");
        Assert.assertEquals("test@test.com",settings.getUsername());

    }

    @Test
    public void testUpdate() throws Exception {
        Settings settings = SettingsFactory.getSettings("test@test.com", "USEM", "hello");
        Settings newSettings = new Settings
                .Builder()
                .copy(settings)
                .username("test@t.com")
                .build();
        Assert.assertEquals("test@t.com",newSettings.getUsername());
        Assert.assertEquals("USEM",newSettings.getCode());

    }
}
