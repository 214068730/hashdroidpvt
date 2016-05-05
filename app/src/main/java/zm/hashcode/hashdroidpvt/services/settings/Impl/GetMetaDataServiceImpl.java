package zm.hashcode.hashdroidpvt.services.settings.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import java.io.IOException;
import java.util.Set;

import zm.hashcode.hashdroidpvt.conf.util.App;
import zm.hashcode.hashdroidpvt.restapi.settings.api.AddressTypeAPI;
import zm.hashcode.hashdroidpvt.restapi.settings.api.ContactTypeAPI;
import zm.hashcode.hashdroidpvt.restapi.settings.api.GenderAPI;
import zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.AddressTypeAPIImpl;
import zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.ContactTypeAPIImpl;
import zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.GenderAPIImpl;
import zm.hashcode.hashdroidpvt.restapi.settings.resources.AddressTypeResource;
import zm.hashcode.hashdroidpvt.restapi.settings.resources.ContactTypeResource;
import zm.hashcode.hashdroidpvt.restapi.settings.resources.GenderResource;
import zm.hashcode.hashdroidpvt.services.settings.GetMetaDataService;
import zm.hashcode.hashdroidpvt.services.settings.MetaDataUpdateService;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class GetMetaDataServiceImpl extends IntentService implements GetMetaDataService {
    private final GenderAPI genderApi;
    private final ContactTypeAPI contactTypeAPI;
    private final AddressTypeAPI addressTypeAPI;
    private final MetaDataUpdateService metaDataUpdateService;

    private static GetMetaDataServiceImpl service = null;

    public static GetMetaDataServiceImpl getInstance() {
        if (service == null)
            service = new GetMetaDataServiceImpl();
        return service;
    }

    private GetMetaDataServiceImpl() {
        super("GetMetaDataServiceImpl");
        genderApi = new GenderAPIImpl();
        contactTypeAPI = new ContactTypeAPIImpl();
        addressTypeAPI = new AddressTypeAPIImpl();
        metaDataUpdateService = MetaDataUpdateServiceImpl.getInstance();
    }

    @Override
    public void getMetaData(Context context) {
        Intent intent = new Intent(context, GetMetaDataServiceImpl.class);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            Set<GenderResource> genderResources = genderApi.getGenderType();
            handleGender(genderResources);

            Set<ContactTypeResource> contactTypes = contactTypeAPI.getContactType();
            handleContacts(contactTypes);

            Set<AddressTypeResource> addressTypes = addressTypeAPI.getAddressType();
            handleAddress(addressTypes);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void handleAddress(Set<AddressTypeResource> addressTypes) {
        for (AddressTypeResource resource : addressTypes) {
            metaDataUpdateService.addAddressTypes(App.getAppContext(), resource);
        }
    }

    private void handleContacts(Set<ContactTypeResource> contactTypes) {
        for (ContactTypeResource contactType : contactTypes) {
            metaDataUpdateService.addContactTYpes(App.getAppContext(), contactType);
        }

    }

    private void handleGender(Set<GenderResource> genderResources) {
        for (GenderResource gender : genderResources) {
            metaDataUpdateService.addGenderType(App.getAppContext(), gender);
        }
    }


}
