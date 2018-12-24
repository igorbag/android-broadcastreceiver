package com.example.igorrotondobagliot.broadcastreceiver2;

import android.app.Application;

/**
 * Quando registramos o receptor usando XML, o sistema passa ReceiverResctrictredContext
 * para o método onReceive (). Para obter acesso ao contexto MainActivity, a fim de
 * imprimir no EditText “etReceivedBroadcast”,
 * precisamos solucionar ao estender nossa própria classe
 * Application que tenha referência à nossa classe MainActivity.
 */
public class MyApplication extends Application {

    MainActivity mainActivity;


    @Override
    public void onCreate() {
        super.onCreate();
    }
}
