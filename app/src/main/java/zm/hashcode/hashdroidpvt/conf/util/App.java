package zm.hashcode.hashdroidpvt.conf.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by hashcode on 2016/04/16.
 */
public class App extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return App.context;
    }
}
