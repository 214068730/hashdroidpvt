package zm.hashcode.hashdroidpvt.restapi.settings;

import android.test.AndroidTestCase;

import org.junit.Assert;
import org.mindrot.jbcrypt.BCrypt;

import zm.hashcode.hashdroidpvt.domain.person.Person;
import zm.hashcode.hashdroidpvt.restapi.settings.api.ActivateAPI;
import zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.ActivateAPImpl;

/**
 * Created by hashcode on 2016/04/28.
 */
public class ActivateAPITest extends AndroidTestCase {

    private ActivateAPI api;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        api = new ActivateAPImpl();

    }

    public void testActivateAccount() {
        Person person = api.activateAccount("admin@test.com", "admin");
        Assert.assertTrue(BCrypt.checkpw("admin", person.getAuthvalue()));
    }
}
