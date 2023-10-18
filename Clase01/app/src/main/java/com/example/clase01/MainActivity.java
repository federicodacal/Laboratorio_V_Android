package com.example.clase01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = super.findViewById(R.id.tvSaludo);
        tv.setText("Hola desde java");

        Button btn = super.findViewById(R.id.btnSaludo);
        btn.setText("Saludar desde java!");

        Button btnOtro = super.findViewById(R.id.btnOtro);

        //EditText ed = super.findViewById(R.id.edNombre);
        View.OnClickListener myListener = new ClickMainActivity(this);
        btn.setOnClickListener(myListener);

        btnOtro.setOnClickListener(myListener);
    }
}