package com.sbr.appstarter2;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.UserManager;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class BootBroadcastReceiver extends BroadcastReceiver {
    String Pacage_Name = "us.zoom.videomeetings";
    void startapp(String appname, Context ctx){
        Intent i = ctx.getPackageManager().getLaunchIntentForPackage(appname);
        if (i != null) {
            Toast.makeText(ctx, "Startdin app", Toast.LENGTH_SHORT).show();
            ctx.startActivity(i);
        } else{
            Toast.makeText(ctx, "Package not found", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startapp(Pacage_Name,context);
                startapp(Pacage_Name,ac.getAppContext());
            }
        }, 20000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startapp(Pacage_Name,context);
                startapp(Pacage_Name,ac.getAppContext());
            }
        }, 2000);

        String action = intent.getAction();
        if ("android.intent.action.BOOT_COMPLETED".equals(action)) {
            startapp(Pacage_Name,ac.getAppContext());
            Intent i2 = new Intent();
            i2.setComponent(new ComponentName("de.ozerov.fully", "de.ozerov.fully.FullyActivity"));
            context.startActivity(i2);


        }
        if ("android.intent.action.LOCKED_BOOT_COMPLETED".equals(action)) {
            startapp(Pacage_Name,ac.getAppContext());
            Intent i2 = new Intent();
            i2.setComponent(new ComponentName("de.ozerov.fully", "de.ozerov.fully.FullyActivity"));
            context.startActivity(i2);

        }
        startapp(Pacage_Name,ac.getAppContext());

    }
}
