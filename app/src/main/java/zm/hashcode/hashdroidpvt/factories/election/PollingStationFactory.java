package zm.hashcode.hashdroidpvt.factories.election;

import java.util.Map;

import zm.hashcode.hashdroidpvt.domain.election.PollingStation;

/**
 * Created by hashcode on 2016/04/12.
 */
public class PollingStationFactory {
    public static PollingStation getPollingStation(String name, Integer voters, Map<String, String> location) {
        return new PollingStation.Builder()
                .name(name)
                .voters(voters)
                .location(location)
                .build();
    }
}
