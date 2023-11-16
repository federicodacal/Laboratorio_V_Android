package com.example.practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;

    Button btn2;

    EditText et;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btn = super.findViewById(R.id.button);
        btn.setOnClickListener(this);

        this.btn2 = super.findViewById(R.id.button2);
        btn2.setOnClickListener(this);

        this.et = super.findViewById(R.id.editText);
        this.tv = super.findViewById(R.id.textView);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button) {
            Log.d("Click", "Button");
            String input = et.getText().toString();
            this.tv.setText(input);
            Toast.makeText(this, "Toast: " + input, Toast.LENGTH_SHORT).show();

        }

        if(view.getId() == R.id.button2) {
            Log.d("Click", "Button 2");
            Intent i = new Intent(this, SettingsActivity.class);
            i.putExtra("Hello", "World");
            startActivity(i);
        }

    }

}