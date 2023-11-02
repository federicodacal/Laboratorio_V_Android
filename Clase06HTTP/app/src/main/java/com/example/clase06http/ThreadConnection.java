package com.example.clase06http;

import android.os.Handler;
import android.os.Message;

public class ThreadConnection extends Thread {

    public static final int IMG = 10;
    public static final int NEWS = 1;

    Handler handler;

    String ruta;

    boolean esImg;

    public ThreadConnection(Handler handler, String ruta, boolean esImg) {
        this.handler = handler;
        this.ruta = ruta;
        this.esImg = esImg;
    }
    public void run() {
        APIConnection apiConnection = new APIConnection();
        byte[] res = apiConnection.obtener(this.ruta);
        Message msg = new Message();
        if(!this.esImg) {
            msg.arg1 = NEWS;
            msg.obj = new String(res);
        }
        else {
            msg.arg1 = IMG;
            msg.obj = res;
        }

        this.handler.sendMessage(msg);
    }

}
