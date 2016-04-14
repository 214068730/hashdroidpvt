package zm.hashcode.hashdroidpvt.factories.person;

import java.util.Date;

import zm.hashcode.hashdroidpvt.conf.util.DomainState;
import zm.hashcode.hashdroidpvt.domain.person.PersonContact;

/**
 * Created by hashcode on 2016/04/12.
 */
public class PersonContactFactory {
    public static PersonContact getContact(String contact, String value) {
        return new PersonContact.Builder()
                .state(DomainState.ACTIVE.name())
                .contactTypeId(contact)
                .contactValue(value)
                .date(new Date())
                .status(DomainState.ACTIVE.name())
                .build();
    }

}
