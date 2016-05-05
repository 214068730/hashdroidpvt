package zm.hashcode.hashdroidpvt.services.settings;

import android.content.Context;

import zm.hashcode.hashdroidpvt.restapi.settings.resources.AddressTypeResource;
import zm.hashcode.hashdroidpvt.restapi.settings.resources.ContactTypeResource;
import zm.hashcode.hashdroidpvt.restapi.settings.resources.GenderResource;

/**
 * Created by hashcode on 2016/05/05.
 */
public interface MetaDataUpdateService {
    void addContactTYpes(Context context, ContactTypeResource contactTypeResources);

    void addAddressTypes(Context context, AddressTypeResource addressTypeResources);

    void addGenderType(Context context, GenderResource genders);
}
