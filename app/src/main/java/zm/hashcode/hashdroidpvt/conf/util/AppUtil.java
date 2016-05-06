package zm.hashcode.hashdroidpvt.conf.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

/**
 * Created by hashcode on 2016/04/17.
 */
public class AppUtil {
    public static String getStringLocation(Map<String, String> location) {
        Gson gson = new Gson();
        return gson.toJson(location);
    }
    public static  Map<String, String> getLocation(String value) {
        final Gson gson = new Gson();
        Type typeOfHashMap = new TypeToken<Map<String, String>>() {
        }.getType();
        return gson.fromJson(value, typeOfHashMap);
    }

    public static  Date getDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date value = null;
        try {
            value = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static  Map<String, Integer> getValue(String value) {
        final Gson gson = new Gson();
        Type typeOfHashMap = new TypeToken<Map<String, Integer>>() {
        }.getType();
        return gson.fromJson(value, typeOfHashMap);
    }

    public static  String getStringValue(Map<String, Integer> value) {
        Gson gson = new Gson();
        return gson.toJson(value);
    }

    public static String getBaserURI(){
        return "http://10.0.0.8:9000/";
    }

    public static OkHttpClient getConnection() {
        return new OkHttpClient();
    }

    public static MediaType getJSONMediaType() {
        return MediaType.parse("application/json; charset=utf-8");
    }

    public static byte[] getImage(String imageUrl) {
        return null;
    }

}
