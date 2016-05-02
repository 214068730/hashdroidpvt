package zm.hashcode.hashdroidpvt.restapi.settings.api.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Set;

import okhttp3.Request;
import okhttp3.Response;
import zm.hashcode.hashdroidpvt.conf.util.AppUtil;
import zm.hashcode.hashdroidpvt.restapi.settings.api.GenderAPI;
import zm.hashcode.hashdroidpvt.restapi.settings.resources.GenderResource;

/**
 * Created by hashcode on 2016/04/30.
 */
public class GenderAPIImpl implements GenderAPI {
    private static final String url = AppUtil.getBaserURI() + "api/droid/settings/gender/get";

    @Override
    public Set<GenderResource> getGenderType() throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        Type resultType = new TypeToken<Set<GenderResource>>() {
        }.getType();
        String value = response.body().string();
        return new Gson().fromJson(value, resultType);
    }
}
