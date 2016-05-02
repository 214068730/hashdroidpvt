package zm.hashcode.hashdroidpvt.restapi.election.api;

import java.io.IOException;
import java.util.Set;

import zm.hashcode.hashdroidpvt.restapi.election.resources.ElectionsResource;

/**
 * Created by hashcode on 2016/05/02.
 */
public interface ElectionTypeAPI {
    Set<ElectionsResource> getElectionsType() throws IOException;
}
