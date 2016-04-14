package zm.hashcode.hashdroidpvt.factories.settings;

import zm.hashcode.hashdroidpvt.conf.util.DomainState;
import zm.hashcode.hashdroidpvt.domain.settings.Gender;

/**
 * Created by hashcode on 2016/04/12.
 */
public class GenderFactory {
    public static Gender getGender(String name){
        return new Gender.Builder()
                .name(name)
                .state(DomainState.ACTIVE.name())
                .build();

    }
}
