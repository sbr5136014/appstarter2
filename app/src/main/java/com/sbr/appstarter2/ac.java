package com.sbr.appstarter2;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.util.Log;

public class ac extends Application{

    @SuppressLint("StaticFieldLeak")
    private static Context context;
    private static Context context1;

    public void onCreate() {
        super.onCreate();
        ac.context = getApplicationContext();
        ac.context1 = this;
    }

    public static Context getAppContext() {
        return ac.context;

    }
    public static Context this1() {
        return ac.context1;

    }

}
