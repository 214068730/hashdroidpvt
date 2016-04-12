package zm.hashcode.hashdroidpvt.factories.settings;


import zm.hashcode.hashdroidpvt.conf.util.DomainState;
import zm.hashcode.hashdroidpvt.domain.settings.ContactType;

/**
 * Created by user9 on 2016/03/01.
 */
public class ContactTypeFactory {
    public static ContactType contactType(String name){
        ContactType contactType = new ContactType.Builder()
                .name(name)
                .state(DomainState.ACTIVE.name())
                .build();
        return contactType;

    }
}
