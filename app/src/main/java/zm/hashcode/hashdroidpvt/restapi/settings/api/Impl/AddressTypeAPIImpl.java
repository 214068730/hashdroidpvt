package zm.hashcode.hashdroidpvt.restapi.settings.api.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Set;

import okhttp3.Request;
import okhttp3.Response;
import zm.hashcode.hashdroidpvt.conf.util.AppUtil;
import zm.hashcode.hashdroidpvt.restapi.settings.api.AddressTypeAPI;
import zm.hashcode.hashdroidpvt.restapi.settings.resources.AddressTypeResource;

/**
 * Created by hashcode on 2016/04/30.
 */
public class AddressTypeAPIImpl implements AddressTypeAPI {
    private static final String url = AppUtil.getBaserURI() + "api/droid/settings/address/get";

    @Override
    public Set<AddressTypeResource> getAddressType() throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        Type resultType = new TypeToken<Set<AddressTypeResource>>() {
        }.getType();
        String value = response.body().string();
        return new Gson().fromJson(value, resultType);
    }
}
