package zm.hashcode.hashdroidpvt.restapi.settings.api;

import java.io.IOException;
import java.util.Set;

import zm.hashcode.hashdroidpvt.restapi.settings.resources.GenderResource;

/**
 * Created by hashcode on 2016/04/29.
 */
public interface GenderAPI {
    Set<GenderResource> getGenderType() throws IOException;
}
