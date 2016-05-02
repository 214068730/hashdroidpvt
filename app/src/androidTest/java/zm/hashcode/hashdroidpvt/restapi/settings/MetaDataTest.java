package zm.hashcode.hashdroidpvt.restapi.settings;

import android.test.AndroidTestCase;

import org.junit.Assert;

import java.util.Set;

import zm.hashcode.hashdroidpvt.restapi.settings.api.AddressTypeAPI;
import zm.hashcode.hashdroidpvt.restapi.settings.api.ContactTypeAPI;
import zm.hashcode.hashdroidpvt.restapi.settings.api.GenderAPI;
import zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.AddressTypeAPIImpl;
import zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.ContactTypeAPIImpl;
import zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.GenderAPIImpl;
import zm.hashcode.hashdroidpvt.restapi.settings.resources.AddressTypeResource;

/**
 * Created by hashcode on 2016/05/02.
 */
public class MetaDataTest extends AndroidTestCase {
    private AddressTypeAPI addressAPI;
    private ContactTypeAPI contactTypeAPI;
    private GenderAPI genderAPI;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        addressAPI = new AddressTypeAPIImpl();
        contactTypeAPI = new ContactTypeAPIImpl();
        genderAPI = new GenderAPIImpl();
    }

    public void testGetAddressType() throws Exception {
        Set<AddressTypeResource> address = addressAPI.getAddressType();
        Assert.assertTrue(address.size() > 0);

    }
}
