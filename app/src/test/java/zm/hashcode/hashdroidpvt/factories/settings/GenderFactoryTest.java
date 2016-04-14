package zm.hashcode.hashdroidpvt.factories.settings;

import junit.framework.Assert;

import org.junit.Test;

import zm.hashcode.hashdroidpvt.conf.util.DomainState;
import zm.hashcode.hashdroidpvt.domain.settings.Gender;

/**
 * Created by hashcode on 2016/04/14.
 */
public class GenderFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Gender gender = GenderFactory.getGender("MALE");
        Assert.assertEquals("MALE",gender.getName());

    }

    @Test
    public void testUpdate() throws Exception {
        Gender gender = GenderFactory.getGender("MALE");
        Gender newGender = new Gender
                .Builder()
                .copy(gender)
                .name("FEMALE")
                .build();
        Assert.assertEquals("FEMALE",newGender.getName());
        Assert.assertEquals(DomainState.ACTIVE.name(),newGender.getState());

    }
}
