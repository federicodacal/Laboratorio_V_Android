package com.example.clase06http;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(this); // Le paso this porque implemento la interfaz Handler.Callback

        ThreadConnection tc = new ThreadConnection(handler, "https://www.clarin.com/rss/lo-ultimo/", false);
        tc.start();

        ThreadConnection tImg = new ThreadConnection(handler, "https://www.clarin.com/img/2023/10/26/MWEi9cHmh_1200x630__1.jpg", true);
        tImg.start();
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {
        if(message.arg1 == ThreadConnection.NEWS) {
            TextView tv = this.findViewById(R.id.tvNoticias);
            tv.setText(message.obj.toString());
        }
        else if(message.arg1 == ThreadConnection.IMG) {
            ImageView img = this.findViewById(R.id.img);
            byte[] imgByte = (byte[]) message.obj;
            img.setImageBitmap(BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length));
        }

        return false;
    }
}