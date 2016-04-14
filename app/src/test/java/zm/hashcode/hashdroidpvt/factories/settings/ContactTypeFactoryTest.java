package zm.hashcode.hashdroidpvt.factories.settings;

import junit.framework.Assert;

import org.junit.Test;

import zm.hashcode.hashdroidpvt.conf.util.DomainState;
import zm.hashcode.hashdroidpvt.domain.settings.ContactType;

/**
 * Created by hashcode on 2016/04/14.
 */
public class ContactTypeFactoryTest {
    @Test
    public void testCreate() throws Exception {
        ContactType contactType = ContactTypeFactory.contactType("EMAIL");
        Assert.assertEquals("EMAIL",contactType.getName());

    }

    @Test
    public void testUpdate() throws Exception {
        ContactType contactType = ContactTypeFactory.contactType("EMAIL");
        ContactType newContactType = new ContactType
                .Builder()
                .copy(contactType)
                .name("WHATSUP")
                .build();
        Assert.assertEquals("WHATSUP",newContactType.getName());
        Assert.assertEquals(DomainState.ACTIVE.name(),newContactType.getState());

    }
}
