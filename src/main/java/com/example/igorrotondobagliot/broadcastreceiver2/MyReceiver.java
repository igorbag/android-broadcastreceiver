package com.example.igorrotondobagliot.broadcastreceiver2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        MainActivity mainActivity = ((MyApplication) context.getApplicationContext()).mainActivity;
        mainActivity.mEtReceivedBroadcast.append("broadcast: " + intent.getAction() + "\n");
    }
}
