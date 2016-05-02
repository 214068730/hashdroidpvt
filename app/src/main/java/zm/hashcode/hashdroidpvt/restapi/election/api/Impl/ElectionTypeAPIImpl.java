package zm.hashcode.hashdroidpvt.restapi.election.api.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Set;

import okhttp3.Request;
import okhttp3.Response;
import zm.hashcode.hashdroidpvt.conf.util.AppUtil;
import zm.hashcode.hashdroidpvt.restapi.election.api.ElectionTypeAPI;
import zm.hashcode.hashdroidpvt.restapi.election.resources.ElectionsResource;

/**
 * Created by hashcode on 2016/05/02.
 */
public class ElectionTypeAPIImpl implements ElectionTypeAPI {
    private static final String url = AppUtil.getBaserURI() + "api/droid/settings/election/get";

    @Override
    public Set<ElectionsResource> getElectionsType() throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        Type resultType = new TypeToken<Set<ElectionsResource>>() {
        }.getType();
        String value = response.body().string();
        return new Gson().fromJson(value, resultType);
    }
}
