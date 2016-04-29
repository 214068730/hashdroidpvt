package zm.hashcode.hashdroidpvt.restapi.settings.api.Impl;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
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
public class ActivateAPImpl implements ActivateAPI {
    public static final String TAG = ActivateAPImpl.class.getSimpleName();
    private static final String url = AppUtil.getBaserURI() + "api/droid/activate/account/post";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    @Override
    public Person activateAccount(final String email, final String auth) {
        Person person = null;
        OkHttpClient client = new OkHttpClient();
        Credential cred = new Credential();
        cred.setEmail(email);
        cred.setValue(auth);
        String json = new Gson().toJson(cred);
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String value = response.body().string();
            PersonResource resource = new Gson().fromJson(value, PersonResource.class);
            Person personValues = new Person.Builder()
                    .firstName(resource.getFirstName())
                    .lastName(resource.getLastName())
                    .authvalue((resource.getAuthvalue()))
                    .emailAddress(resource.getEmailAddress())
                    .build();
            person = personValues;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return person;
    }
}
