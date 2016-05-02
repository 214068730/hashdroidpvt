package zm.hashcode.hashdroidpvt.restapi.person.api.Impl;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import zm.hashcode.hashdroidpvt.conf.util.AppUtil;
import zm.hashcode.hashdroidpvt.domain.person.PersonAddress;
import zm.hashcode.hashdroidpvt.restapi.person.api.PersonAddressAPI;

/**
 * Created by hashcode on 2016/05/02.
 */
public class PersonAddressAPIImpl implements PersonAddressAPI {
    private static final String postUrl = AppUtil.getBaserURI() + "api/droid/person/address/post";
    private static final String updateUrl = AppUtil.getBaserURI() + "api/droid/person/address/update";

    @Override
    public PersonAddress createPersonAddress(PersonAddress address) throws IOException {
        String json = new Gson().toJson(address);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);
        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        PersonAddress personAddress = new Gson().fromJson(value, PersonAddress.class);
        return personAddress;
    }

    @Override
    public PersonAddress updatePersonAddress(PersonAddress address) throws IOException {
        String json = new Gson().toJson(address);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);
        Request request = new Request.Builder()
                .url(updateUrl)
                .post(body)
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        PersonAddress personAddress = new Gson().fromJson(value, PersonAddress.class);
        return personAddress;
    }
}
