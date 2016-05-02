package zm.hashcode.hashdroidpvt.restapi.election.api;

import java.io.IOException;
import java.util.Set;

import zm.hashcode.hashdroidpvt.restapi.election.resources.CandidateResourse;

/**
 * Created by hashcode on 2016/05/02.
 */
public interface CandidateAPI {
    Set<CandidateResourse> getPollingStationCandidates(String email) throws IOException;
}
