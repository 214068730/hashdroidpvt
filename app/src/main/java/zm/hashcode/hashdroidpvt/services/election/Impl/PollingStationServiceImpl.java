package zm.hashcode.hashdroidpvt.services.election.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import zm.hashcode.hashdroidpvt.conf.util.App;
import zm.hashcode.hashdroidpvt.domain.election.PollingStation;
import zm.hashcode.hashdroidpvt.respository.election.Impl.PollingStationRepositoryImpl;
import zm.hashcode.hashdroidpvt.respository.election.PollingStationRepository;
import zm.hashcode.hashdroidpvt.restapi.election.resources.PollingStationResource;
import zm.hashcode.hashdroidpvt.services.election.PollingStationService;


public class PollingStationServiceImpl extends IntentService implements PollingStationService {
    final private PollingStationRepository repository;

    private static final String ACTION_ADD = "zm.hashcode.hashdroidpvt.services.election.Impl.action.ADD";


    // TODO: Rename parameters
    private static final String EXTRA_ADD = "zm.hashcode.hashdroidpvt.services.election.Impl.extra.ADD";

    private static PollingStationServiceImpl service = null;

    public static PollingStationServiceImpl getInstance() {
        if (service == null)
            service = new PollingStationServiceImpl();
        return service;
    }

    private PollingStationServiceImpl() {
        super("PollingStationServiceImpl");
        repository = new PollingStationRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addPollingStation(Context context, PollingStationResource stationResource) {
        Intent intent = new Intent(context, PollingStationServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, stationResource);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        final PollingStationResource station = (PollingStationResource) intent.getSerializableExtra(EXTRA_ADD);
        PollingStation pollingStation = new PollingStation.Builder()
                .location(station.getLocation())
                .name(station.getName())
                .voters(station.getVoters())
                .build();
        repository.save(pollingStation);

    }
}
