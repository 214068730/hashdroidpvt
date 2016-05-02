package zm.hashcode.hashdroidpvt.restapi.election.api.Impl;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;
import zm.hashcode.hashdroidpvt.conf.util.AppUtil;
import zm.hashcode.hashdroidpvt.restapi.election.api.PollingStationAPI;
import zm.hashcode.hashdroidpvt.restapi.election.resources.PollingStationResource;

/**
 * Created by hashcode on 2016/05/02.
 */
public class PollingStationAPIImpl implements PollingStationAPI {
    private static final String url = AppUtil.getBaserURI() + "api/droid/elections/results/station/";

    @Override
    public PollingStationResource getAgentPollintStattion(String email) throws IOException {
        final String paramsUrl = url + email;
        Request request = new Request.Builder()
                .url(paramsUrl)
                .get()
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        return new Gson().fromJson(value, PollingStationResource.class);
    }
}
