package zm.hashcode.hashdroidpvt.services.election.Impl;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import zm.hashcode.hashdroidpvt.conf.util.App;
import zm.hashcode.hashdroidpvt.conf.util.AppUtil;
import zm.hashcode.hashdroidpvt.domain.election.Candidate;
import zm.hashcode.hashdroidpvt.respository.election.CandidateRepository;
import zm.hashcode.hashdroidpvt.respository.election.Impl.CandidateRepositoryImpl;
import zm.hashcode.hashdroidpvt.restapi.election.resources.CandidateResourse;
import zm.hashcode.hashdroidpvt.services.election.CandidateService;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class CandidateServiceImpl extends IntentService implements CandidateService {
    private final CandidateRepository repository;

    private static final String ACTION_ADD = "zm.hashcode.hashdroidpvt.services.election.Impl.action.ADD";
    private static final String ACTION_RESET = "zm.hashcode.hashdroidpvt.services.election.Impl.action.RESET";

    private static final String EXTRA_ADD = "zm.hashcode.hashdroidpvt.services.election.Impl.extra.ADD";

    private static CandidateServiceImpl service = null;

    public static CandidateServiceImpl getInstance() {
        if (service == null)
            service = new CandidateServiceImpl();
        return service;
    }

    private CandidateServiceImpl() {
        super("CandidateServiceImpl");
        repository = new CandidateRepositoryImpl(App.getAppContext());
    }

    @Override
    public void addCandidate(Context context, CandidateResourse candidateResourse) {
        Intent intent = new Intent(context, CandidateServiceImpl.class);
        intent.setAction(ACTION_ADD);
        intent.putExtra(EXTRA_ADD, candidateResourse);
        context.startService(intent);
    }

    @Override
    public void resetCandidates(Context context) {
        Intent intent = new Intent(context, CandidateServiceImpl.class);
        intent.setAction(ACTION_RESET);
        context.startService(intent);

    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ADD.equals(action)) {
                final CandidateResourse candidateResourse = (CandidateResourse) intent.getSerializableExtra(EXTRA_ADD);
                saveCandidate(candidateResourse);
            } else if (ACTION_RESET.equals(action)) {
                resetCandidatesRecords();
            }
        }
    }

    private void resetCandidatesRecords() {
        repository.deleteAll();
    }

    private void saveCandidate(CandidateResourse candidateResourse) {
        Candidate candidate = new Candidate.Builder()
                .candidateId(candidateResourse.getCandidateId())
                .candidateImage(AppUtil.getImage(candidateResourse.getCandidateImageUrl()))
                .electionTypeId(candidateResourse.getElectionTypeId())
                .firstname(candidateResourse.getFirstname())
                .lastName(candidateResourse.getLastName())
                .symbolImage(AppUtil.getImage(candidateResourse.getSymbolImageUrl()))
                .build();
        Candidate savedCandidate = repository.save(candidate);

    }
}
