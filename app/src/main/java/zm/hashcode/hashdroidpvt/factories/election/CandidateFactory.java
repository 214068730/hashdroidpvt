package zm.hashcode.hashdroidpvt.factories.election;

import java.util.Map;

import zm.hashcode.hashdroidpvt.domain.election.Candidate;

/**
 * Created by hashcode on 2016/04/12.
 */
public class CandidateFactory {
    public static Candidate getCandidate(Map<String, byte[]> image, Map<String, String> candidate) {
        return new Candidate.Builder()
                .electionTypeId(candidate.get("electionTypeId"))
                .candidateId(candidate.get("candidateId"))
                .candidateImage(image.get("candidateImage"))
                .firstname(candidate.get("firstname"))
                .lastName(candidate.get("lastName"))
                .symbolImage(image.get("symbolImage"))
                .build();
    }
}
