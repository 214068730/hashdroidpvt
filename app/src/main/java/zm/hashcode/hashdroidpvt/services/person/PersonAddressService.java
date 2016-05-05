package zm.hashcode.hashdroidpvt.services.person;

import android.content.Context;

import zm.hashcode.hashdroidpvt.domain.person.PersonAddress;

/**
 * Created by hashcode on 2016/05/05.
 */
public interface PersonAddressService {
    void addPersonAddress(Context context, PersonAddress address);

    void updatePersonAddress(Context context, PersonAddress address);
}
