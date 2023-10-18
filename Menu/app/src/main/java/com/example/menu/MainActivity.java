package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public static Persona p = new Persona();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.op1) {
            Log.d("Click", "Opcion 1");
            Intent intent = new Intent(this, Activity_2.class);
            intent.putExtra("nombre", "pepe");
            intent.putExtra("numero", 666);
            intent.putExtra("persona", new Persona("Matias", "Ramos", "644546"));
            this.startActivity(intent);
        }
        else if(item.getItemId()==R.id.op2) {
            Log.d("Click", "Opcion 2");
        }
        else if(item.getItemId()==R.id.op3) {
            Log.d("Click", "Opcion 3");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        Log.d("Resume", "Volvi al main " + p.getNombre());
        super.onRestart();
    }
}