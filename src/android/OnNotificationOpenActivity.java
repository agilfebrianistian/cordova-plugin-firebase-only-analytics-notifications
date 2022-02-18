package org.apache.cordova.firebase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class OnNotificationOpenActivity extends Activity {

    private static final String TAG = "FirebasePlugin";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //super.OnCreate(savedInstanceState);
        
        Log.d(TAG, "OnNotificationOpenActivity onCreate called");

		Context context = getApplicationContext();
        PackageManager pm = context.getPackageManager();
        Intent launchIntent = pm.getLaunchIntentForPackage(context.getPackageName());
        launchIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        
        Bundle data = this.getIntent().getExtras();
        data.putBoolean("tap", true);

        FirebasePlugin.sendNotification(data, context);
    
        launchIntent.putExtras(data);
        context.startActivity(launchIntent);
        //this.finish();
    }
}