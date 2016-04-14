package zm.hashcode.hashdroidpvt.factories.person;

import java.util.Date;

import zm.hashcode.hashdroidpvt.conf.util.DomainState;
import zm.hashcode.hashdroidpvt.domain.person.PersonAddress;

/**
 * Created by hashcode on 2016/04/12.
 */
public class PersonAddressFactory {
    public static PersonAddress getAddress(String address, String postalcode){
        return new PersonAddress.Builder()
                .state(DomainState.ACTIVE.name())
                .addressTypeId(address)
                .postalCode(postalcode)
                .date(new Date())
                .status(DomainState.ACTIVE.name())
                .build();
    }
}
