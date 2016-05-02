package zm.hashcode.hashdroidpvt.restapi.election.api;

import java.io.IOException;

import zm.hashcode.hashdroidpvt.restapi.election.resources.ResultsResource;

/**
 * Created by hashcode on 2016/05/02.
 */
public interface ResultsAPI {
    String uploadResults(ResultsResource result) throws IOException;
}
