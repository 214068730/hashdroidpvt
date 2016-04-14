package zm.hashcode.hashdroidpvt.factories.settings;

import junit.framework.Assert;

import org.junit.Test;

import zm.hashcode.hashdroidpvt.conf.util.DomainState;
import zm.hashcode.hashdroidpvt.domain.settings.AddressType;

/**
 * Created by hashcode on 2016/04/14.
 */
public class AddressTypeFactoryTest {
    @Test
    public void testCreate() throws Exception {
        AddressType AddressType = AddressTypeFactory.getAddressType("HOME");
        Assert.assertEquals("HOME",AddressType.getName());

    }

    @Test
    public void testUpdate() throws Exception {
        AddressType addressType = AddressTypeFactory.getAddressType("HOME");
        AddressType newAddressType = new AddressType
                .Builder()
                .copy(addressType)
                .name("WORK")
                .build();
        Assert.assertEquals("WORK",newAddressType.getName());
        Assert.assertEquals(DomainState.ACTIVE.name(),newAddressType.getState());

    }
}
