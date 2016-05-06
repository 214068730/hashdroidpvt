package zm.hashcode.hashdroidpvt.services.election;

import android.content.Context;

import zm.hashcode.hashdroidpvt.restapi.election.resources.ElectionsResource;

/**
 * Created by hashcode on 2016/05/06.
 */
public interface ElectionsTypeService {
    void addElectionType(Context context, ElectionsResource electionsResource);

}
