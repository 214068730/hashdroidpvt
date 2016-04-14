package zm.hashcode.hashdroidpvt.factories.election;

import zm.hashcode.hashdroidpvt.domain.election.Elections;

/**
 * Created by hashcode on 2016/04/12.
 */
public class ElectionsFactory {
    public static Elections getElectionType(String name, String electionType) {
        return new Elections.Builder()
                .name(name)
                .electionTypeId(electionType)
                .build();
    }
}
