package zm.hashcode.hashdroidpvt.restapi.settings.api.Impl;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import zm.hashcode.hashdroidpvt.conf.util.AppUtil;
import zm.hashcode.hashdroidpvt.domain.person.Person;
import zm.hashcode.hashdroidpvt.restapi.person.resources.PersonResource;
import zm.hashcode.hashdroidpvt.restapi.settings.api.ActivateAPI;
import zm.hashcode.hashdroidpvt.restapi.settings.resources.Credential;

/**
 * Created by hashcode on 2016/04/17.
 */
public class ActivateAPIImpl implements ActivateAPI {
    private static final String url = AppUtil.getBaserURI() + "api/droid/activate/account/post";
    @Override
    public Person activateAccount(final String email, final String auth) throws IOException {
        Credential cred = new Credential.Builder()
                .email(email)
                .value(auth)
                .build();
        String json = new Gson().toJson(cred);
        RequestBody body = RequestBody.create(AppUtil.getJSONMediaType(), json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = AppUtil.getConnection().newCall(request).execute();
            String value = response.body().string();
            PersonResource resource = new Gson().fromJson(value, PersonResource.class);
        return new Person.Builder()
                .firstName(resource.getFirstName())
                .lastName(resource.getLastName())
                .authvalue((resource.getAuthvalue()))
                .emailAddress(resource.getEmailAddress())
                .build();
    }
}
