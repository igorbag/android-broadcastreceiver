package com.example.igorrotondobagliot.broadcastreceiver2;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {

    MyReceiver mMyReceiver;
    IntentFilter mIntentFilter;
    EditText mEtReceivedBroadcast;
    Button mBtnSendBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.init();
    }

    private void init() {
        this.setListeners();
        this.setUpApplicationContext();
        this.setUpReceiveBroadcast();
    }

    private void setListeners() {
        mEtReceivedBroadcast = findViewById(R.id.etReceivedBroadcast);
        mBtnSendBroadcast = findViewById(R.id.btnSendBroadcast);
        mBtnSendBroadcast.setOnClickListener(this);
    }

    private void setUpApplicationContext() {
        //Manter a referencia no manifets
        MyApplication myApplication = (MyApplication) this.getApplicationContext();
        myApplication.mainActivity = this;
    }

    private void setUpReceiveBroadcast() {
        mMyReceiver = new MyReceiver();
        mIntentFilter = new IntentFilter("com.example.igorrotondobagliot.broadcastreceiver2.USER_ACTION");
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mMyReceiver, mIntentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mMyReceiver);
    }
    
    @Override
    public void onClick(View view) {
        this.setUpSendBroadcast();

    }

    private void setUpSendBroadcast() {
        Intent intnet = new Intent("com.example.igorrotondobagliot.broadcastreceiver2.USER_ACTION");
        sendBroadcast(intnet);
    }
}
