package zm.hashcode.hashdroidpvt.services.election.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import zm.hashcode.hashdroidpvt.conf.util.App;
import zm.hashcode.hashdroidpvt.domain.election.Elections;
import zm.hashcode.hashdroidpvt.respository.election.ElectionsRepository;
import zm.hashcode.hashdroidpvt.respository.election.Impl.ElectionsRepositoryImpl;
import zm.hashcode.hashdroidpvt.restapi.election.resources.ElectionsResource;
import zm.hashcode.hashdroidpvt.services.election.ElectionsTypeService;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class ElectionsTypeServiceImpl extends IntentService implements ElectionsTypeService {
    private final ElectionsRepository repository;

    private static ElectionsTypeServiceImpl service = null;

    public static ElectionsTypeServiceImpl getInstance() {
        if (service == null)
            service = new ElectionsTypeServiceImpl();
        return service;
    }


    // TODO: Rename parameters
    private static final String EXTRA_ADD = "zm.hashcode.hashdroidpvt.services.election.Impl.extra.ADD";


    private ElectionsTypeServiceImpl() {
        super("ElectionsTypeServiceImpl");
        repository = new ElectionsRepositoryImpl(App.getAppContext());
    }


    @Override
    public void addElectionType(Context context, ElectionsResource electionsResource) {
        Intent intent = new Intent(context, ElectionsTypeServiceImpl.class);
        intent.putExtra(EXTRA_ADD, electionsResource);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ElectionsResource electionsResource = (ElectionsResource) intent.getSerializableExtra(EXTRA_ADD);
        Elections electionType = new Elections.Builder()
                .electionTypeId(electionsResource.getElectionTypeId())
                .name(electionsResource.getName())
                .build();
        repository.save(electionType);
    }
}
