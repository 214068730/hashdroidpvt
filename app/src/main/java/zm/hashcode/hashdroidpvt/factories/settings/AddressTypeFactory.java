package zm.hashcode.hashdroidpvt.factories.settings;


import zm.hashcode.hashdroidpvt.conf.util.DomainState;
import zm.hashcode.hashdroidpvt.domain.settings.AddressType;

/**
 * Created by user9 on 2016/03/01.
 */
public class AddressTypeFactory {
    public static AddressType getAddressType(String name){
        AddressType addressType = new AddressType.Builder()
                .name(name)
                .state(DomainState.ACTIVE.name())
                .build();
        return addressType;
    }
}
