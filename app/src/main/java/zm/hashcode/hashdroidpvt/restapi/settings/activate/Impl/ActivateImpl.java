package zm.hashcode.hashdroidpvt.restapi.settings.activate.Impl;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import zm.hashcode.hashdroidpvt.conf.util.App;
import zm.hashcode.hashdroidpvt.conf.util.AppUtil;
import zm.hashcode.hashdroidpvt.domain.person.Person;
import zm.hashcode.hashdroidpvt.restapi.settings.activate.Activate;

/**
 * Created by hashcode on 2016/04/17.
 */
public class ActivateImpl implements Activate {
    public static final String TAG = ActivateImpl.class.getSimpleName();
    private static final String url = AppUtil.getBaserURI() + "/";
    // Tag used to cancel the request
    String tag_json_obj = "json_obj_req";
    String response;

    @Override
    public Person activateAccount(final String email, final String auth, final String org) {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("auth", auth);
                params.put("org", org);
                return params;
            }

        };
        App.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

        return null;
    }
}
