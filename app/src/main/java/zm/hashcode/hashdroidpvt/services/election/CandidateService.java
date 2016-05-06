package zm.hashcode.hashdroidpvt.services.election;

import android.content.Context;

import zm.hashcode.hashdroidpvt.restapi.election.resources.CandidateResourse;

/**
 * Created by hashcode on 2016/05/06.
 */
public interface CandidateService {
    void addCandidate(Context context, CandidateResourse candidateResourse);

    void resetCandidates(Context context);
}
