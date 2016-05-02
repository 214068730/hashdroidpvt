package zm.hashcode.hashdroidpvt.restapi.election.api.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Set;

import okhttp3.Request;
import okhttp3.Response;
import zm.hashcode.hashdroidpvt.conf.util.AppUtil;
import zm.hashcode.hashdroidpvt.restapi.election.api.CandidateAPI;
import zm.hashcode.hashdroidpvt.restapi.election.resources.CandidateResourse;

/**
 * Created by hashcode on 2016/05/02.
 */
public class CandidateAPIImpl implements CandidateAPI {
    private static final String url = AppUtil.getBaserURI() + "api/droid/elections/results/candidates/";

    @Override
    public Set<CandidateResourse> getPollingStationCandidates(String email) throws IOException {
        final String paramsUrl = url + email;
        Request request = new Request.Builder()
                .url(paramsUrl)
                .get()
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        Type resultType = new TypeToken<Set<CandidateResourse>>() {
        }.getType();
        String value = response.body().string();
        return new Gson().fromJson(value, resultType);
    }
}
