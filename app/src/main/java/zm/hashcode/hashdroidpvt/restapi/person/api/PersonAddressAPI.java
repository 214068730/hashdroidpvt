package zm.hashcode.hashdroidpvt.restapi.person.api;

import java.io.IOException;

import zm.hashcode.hashdroidpvt.domain.person.PersonAddress;

/**
 * Created by hashcode on 2016/04/29.
 */
public interface PersonAddressAPI {
    PersonAddress createPersonAddress(PersonAddress address) throws IOException;

    PersonAddress updatePersonAddress(PersonAddress address) throws IOException;
}
