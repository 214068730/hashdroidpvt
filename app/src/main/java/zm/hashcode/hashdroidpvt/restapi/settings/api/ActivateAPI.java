package zm.hashcode.hashdroidpvt.restapi.settings.api;

import java.io.IOException;

import zm.hashcode.hashdroidpvt.domain.person.Person;

/**
 * Created by hashcode on 2016/04/17.
 */
public interface ActivateAPI {
    Person activateAccount(String email, String auth) throws IOException;
}
