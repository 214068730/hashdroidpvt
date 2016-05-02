package zm.hashcode.hashdroidpvt.restapi.election.api.Impl;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import zm.hashcode.hashdroidpvt.conf.util.AppUtil;
import zm.hashcode.hashdroidpvt.restapi.election.api.ResultsAPI;
import zm.hashcode.hashdroidpvt.restapi.election.resources.ResultsResource;

/**
 * Created by hashcode on 2016/05/02.
 */
public class ResultsAPIImpl implements ResultsAPI {
    private static final String url = AppUtil.getBaserURI() + "api/droid/elections/results/post";

    @Override
    public String uploadResults(ResultsResource result) throws IOException {
        String json = new Gson().toJson(result);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        String resultsStatus = new Gson().fromJson(value, String.class);
        return resultsStatus;
    }
}
