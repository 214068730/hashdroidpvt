package zm.hashcode.hashdroidpvt.restapi.person.api;

import java.io.IOException;

import zm.hashcode.hashdroidpvt.domain.person.PersonContact;

/**
 * Created by hashcode on 2016/04/29.
 */
public interface PersonContactAPI {
    PersonContact createPersonContact(PersonContact contact) throws IOException;

    PersonContact updatePersonContact(PersonContact contact) throws IOException;
}
