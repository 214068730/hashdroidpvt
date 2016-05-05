package zm.hashcode.hashdroidpvt.services.settings.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import zm.hashcode.hashdroidpvt.conf.util.App;
import zm.hashcode.hashdroidpvt.domain.settings.AddressType;
import zm.hashcode.hashdroidpvt.domain.settings.ContactType;
import zm.hashcode.hashdroidpvt.domain.settings.Gender;
import zm.hashcode.hashdroidpvt.respository.settings.AddressTypeRepository;
import zm.hashcode.hashdroidpvt.respository.settings.ContactTypeRespository;
import zm.hashcode.hashdroidpvt.respository.settings.GenderRepository;
import zm.hashcode.hashdroidpvt.respository.settings.Impl.AddressTypeRepositoryImpl;
import zm.hashcode.hashdroidpvt.respository.settings.Impl.ContactTypeRespositoryImpl;
import zm.hashcode.hashdroidpvt.respository.settings.Impl.GenderTypeRepositoryImpl;
import zm.hashcode.hashdroidpvt.restapi.settings.resources.AddressTypeResource;
import zm.hashcode.hashdroidpvt.restapi.settings.resources.ContactTypeResource;
import zm.hashcode.hashdroidpvt.restapi.settings.resources.GenderResource;
import zm.hashcode.hashdroidpvt.services.settings.MetaDataUpdateService;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MetaDataUpdateServiceImpl extends IntentService implements MetaDataUpdateService {
    private GenderRepository genderRepository;
    private ContactTypeRespository contactTypeRespository;
    private AddressTypeRepository addressTypeRepository;

    private static MetaDataUpdateServiceImpl service = null;

    public static MetaDataUpdateServiceImpl getInstance() {
        if (service == null)
            service = new MetaDataUpdateServiceImpl();
        return service;
    }

    private MetaDataUpdateServiceImpl() {
        super("MetaDataUpdateServiceImpl");
    }

    private static final String ACTION_CONTACT = "zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.action.CONTACT";
    private static final String ACTION_ADDRESS = "zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.action.ADDRESS";
    private static final String ACTION_GENDER = "zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.action.GENDER";

    // TODO: Rename parameters
    private static final String EXTRA_CONTACT = "zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.extra.CONTACT";
    private static final String EXTRA_ADDRESS = "zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.extra.ADDRESS";
    private static final String EXTRA_GENDER = "zm.hashcode.hashdroidpvt.restapi.settings.api.Impl.extra.GENDER";


    @Override
    public void addContactTYpes(Context context, ContactTypeResource contactTypeResource) {
        Intent intent = new Intent(context, MetaDataUpdateServiceImpl.class);
        intent.setAction(ACTION_CONTACT);
        intent.putExtra(EXTRA_CONTACT, contactTypeResource);
        context.startService(intent);
    }

    @Override
    public void addAddressTypes(Context context, AddressTypeResource addressTypeResource) {
        Intent intent = new Intent(context, MetaDataUpdateServiceImpl.class);
        intent.setAction(ACTION_ADDRESS);
        intent.putExtra(EXTRA_ADDRESS, addressTypeResource);
        context.startService(intent);
    }

    @Override
    public void addGenderType(Context context, GenderResource gender) {
        Intent intent = new Intent(context, MetaDataUpdateServiceImpl.class);
        intent.setAction(ACTION_GENDER);
        intent.putExtra(EXTRA_GENDER, gender);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_CONTACT.equals(action)) {
                final ContactTypeResource contact = (ContactTypeResource) intent.getSerializableExtra(EXTRA_CONTACT);
                handleActionContact(contact);
            } else if (ACTION_ADDRESS.equals(action)) {
                final AddressTypeResource address = (AddressTypeResource) intent.getSerializableExtra(EXTRA_ADDRESS);

                handleActionAddress(address);
            } else if (ACTION_GENDER.equals(action)) {
                final GenderResource gender = (GenderResource) intent.getSerializableExtra(EXTRA_GENDER);
                handleActionGender(gender);
            }
        }
    }

    private void handleActionGender(GenderResource genderResource) {
        genderRepository = new GenderTypeRepositoryImpl(App.getAppContext());
        Gender gender = new Gender.Builder()
                .name(genderResource.getName())
                .serverId(genderResource.getServerId())
                .state(genderResource.getState())
                .build();
        genderRepository.save(gender);
    }

    private void handleActionAddress(AddressTypeResource address) {
        addressTypeRepository = new AddressTypeRepositoryImpl(App.getAppContext());
        AddressType addressType = new AddressType.Builder()
                .name(address.getName())
                .serverId(address.getServerId())
                .state(address.getState())
                .build();
        addressTypeRepository.save(addressType);
    }

    private void handleActionContact(ContactTypeResource contact) {
        contactTypeRespository = new ContactTypeRespositoryImpl(App.getAppContext());
        ContactType contactTypeResource = new ContactType.Builder()
                .name(contact.getName())
                .serverId(contact.getServerId())
                .state(contact.getState())
                .build();
        contactTypeRespository.save(contactTypeResource);
    }


}
