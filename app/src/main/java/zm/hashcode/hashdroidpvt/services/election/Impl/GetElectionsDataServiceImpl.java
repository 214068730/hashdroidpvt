package zm.hashcode.hashdroidpvt.services.election.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import java.io.IOException;
import java.util.Set;

import zm.hashcode.hashdroidpvt.conf.util.App;
import zm.hashcode.hashdroidpvt.restapi.election.api.CandidateAPI;
import zm.hashcode.hashdroidpvt.restapi.election.api.ElectionTypeAPI;
import zm.hashcode.hashdroidpvt.restapi.election.api.Impl.CandidateAPIImpl;
import zm.hashcode.hashdroidpvt.restapi.election.api.Impl.ElectionTypeAPIImpl;
import zm.hashcode.hashdroidpvt.restapi.election.api.Impl.PollingStationAPIImpl;
import zm.hashcode.hashdroidpvt.restapi.election.api.PollingStationAPI;
import zm.hashcode.hashdroidpvt.restapi.election.resources.CandidateResourse;
import zm.hashcode.hashdroidpvt.restapi.election.resources.ElectionsResource;
import zm.hashcode.hashdroidpvt.restapi.election.resources.PollingStationResource;
import zm.hashcode.hashdroidpvt.services.election.CandidateService;
import zm.hashcode.hashdroidpvt.services.election.ElectionsTypeService;
import zm.hashcode.hashdroidpvt.services.election.GetElectionsDataService;
import zm.hashcode.hashdroidpvt.services.election.PollingStationService;


public class GetElectionsDataServiceImpl extends IntentService implements GetElectionsDataService {
    private final CandidateAPI candidateAPI;
    private final ElectionTypeAPI electionTypeAPI;
    private final PollingStationAPI pollingStationAPI;
    private final CandidateService candidateService;
    private final ElectionsTypeService electionsTypeService;
    private final PollingStationService pollingStationService;
    private static final String EXTRA_ADD = "zm.hashcode.hashdroidpvt.services.election.Impl.extra.ADD";

    private static GetElectionsDataServiceImpl service = null;

    public static GetElectionsDataServiceImpl getInstance() {
        if (service == null)
            service = new GetElectionsDataServiceImpl();
        return service;
    }

    private GetElectionsDataServiceImpl() {
        super("GetElectionsDataServiceImpl");
        candidateAPI = new CandidateAPIImpl();
        electionTypeAPI = new ElectionTypeAPIImpl();
        pollingStationAPI = new PollingStationAPIImpl();
        candidateService = CandidateServiceImpl.getInstance();
        electionsTypeService = ElectionsTypeServiceImpl.getInstance();
        pollingStationService = PollingStationServiceImpl.getInstance();
    }

    @Override
    public void GetElectionsData(Context context, String agentEmail) {
        Intent intent = new Intent(context, GetElectionsDataServiceImpl.class);
        intent.putExtra(EXTRA_ADD, agentEmail);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        final String email = intent.getStringExtra(EXTRA_ADD);
        try {
            Set<CandidateResourse> candidateResourses = candidateAPI.getPollingStationCandidates(email);
            Set<ElectionsResource> electionsResources = electionTypeAPI.getElectionsType();
            PollingStationResource pollingStationResource = pollingStationAPI.getAgentPollintStattion(email);
            addCandidates(candidateResourses);
            addElectionsTypes(electionsResources);
            addPollingStation(pollingStationResource);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addPollingStation(PollingStationResource pollingStationResource) {
        pollingStationService.addPollingStation(App.getAppContext(), pollingStationResource);

    }

    private void addElectionsTypes(Set<ElectionsResource> electionsResources) {
        for (ElectionsResource electionsResource : electionsResources) {
            electionsTypeService.addElectionType(App.getAppContext(), electionsResource);
        }

    }

    private void addCandidates(Set<CandidateResourse> candidateResources) {
        for (CandidateResourse candidateResourse : candidateResources) {
            candidateService.addCandidate(App.getAppContext(), candidateResourse);
        }
    }

}
