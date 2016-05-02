package zm.hashcode.hashdroidpvt.restapi.person.api.Impl;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import zm.hashcode.hashdroidpvt.conf.util.AppUtil;
import zm.hashcode.hashdroidpvt.domain.person.PersonContact;
import zm.hashcode.hashdroidpvt.restapi.person.api.PersonContactAPI;

/**
 * Created by hashcode on 2016/05/02.
 */
public class PersonContactAPIImpl implements PersonContactAPI {
    private static final String postUrl = AppUtil.getBaserURI() + "api/droid/person/contact/post";
    private static final String updateUrl = AppUtil.getBaserURI() + "api/droid/person/contact/update";

    @Override
    public PersonContact createPersonContact(PersonContact contact) throws IOException {
        String json = new Gson().toJson(contact);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);
        Request request = new Request.Builder()
                .url(postUrl)
                .post(body)
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        PersonContact personContact = new Gson().fromJson(value, PersonContact.class);
        return personContact;
    }

    @Override
    public PersonContact updatePersonContact(PersonContact contact) throws IOException {
        String json = new Gson().toJson(contact);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);
        Request request = new Request.Builder()
                .url(updateUrl)
                .post(body)
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
        String value = response.body().string();
        PersonContact personContact = new Gson().fromJson(value, PersonContact.class);
        return personContact;
    }
}
