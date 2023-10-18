package com.example.ejerformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = super.findViewById(R.id.btnGuardar);

        View.OnClickListener myListener = new Form(this);
        btn.setOnClickListener(myListener);
    }
}