package zm.hashcode.hashdroidpvt.restapi.settings.api;

import java.io.IOException;
import java.util.Set;

import zm.hashcode.hashdroidpvt.restapi.settings.resources.ContactTypeResource;

/**
 * Created by hashcode on 2016/04/29.
 */
public interface ContactTypeAPI {
    Set<ContactTypeResource> getContactType() throws IOException;
}
