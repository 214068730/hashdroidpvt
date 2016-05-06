package zm.hashcode.hashdroidpvt.services.election;

import android.content.Context;

import zm.hashcode.hashdroidpvt.restapi.election.resources.PollingStationResource;

/**
 * Created by hashcode on 2016/05/06.
 */
public interface PollingStationService {
    void addPollingStation(Context context, PollingStationResource stationResource);
}
