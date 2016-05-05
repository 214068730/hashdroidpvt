package zm.hashcode.hashdroidpvt.services.person;

import android.content.Context;

import zm.hashcode.hashdroidpvt.domain.person.PersonContact;

/**
 * Created by hashcode on 2016/05/05.
 */
public interface PersonContactService {
    void addPersonContact(Context context, PersonContact contact);

    void updatePersonContact(Context context, PersonContact contact);
}
