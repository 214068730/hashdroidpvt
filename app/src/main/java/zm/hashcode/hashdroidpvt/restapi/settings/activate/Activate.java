package zm.hashcode.hashdroidpvt.restapi.settings.activate;

import zm.hashcode.hashdroidpvt.domain.person.Person;

/**
 * Created by hashcode on 2016/04/17.
 */
public interface Activate {
    Person activateAccount(String email, String auth, String org);
}
