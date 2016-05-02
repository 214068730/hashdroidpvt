package zm.hashcode.hashdroidpvt.restapi.election.api;

import java.io.IOException;

import zm.hashcode.hashdroidpvt.restapi.election.resources.PollingStationResource;

/**
 * Created by hashcode on 2016/05/02.
 */
public interface PollingStationAPI {
    PollingStationResource getAgentPollintStattion(String email) throws IOException;
}
