package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.Serializable;

public class Activity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        ActionBar ab = super.getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        Bundle bundle = super.getIntent().getExtras();
        ab.setTitle("Activity 2 " + bundle.getString("nombre") + " " + bundle.getInt("numero", -1));

        Serializable ser = bundle.getSerializable("persona");
        Persona per = (Persona) ser;
        Log.d("Persona", per.toString());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            MainActivity.p.setNombre("Edito el nombre");
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}