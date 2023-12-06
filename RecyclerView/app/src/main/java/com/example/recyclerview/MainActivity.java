package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Persona> listPersonas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPersonas.add(new Persona("Perez", "Juan", "430453"));
        listPersonas.add(new Persona("Lopez", "Juana", "430454"));
        listPersonas.add(new Persona("Perez", "Maria", "430455"));
        listPersonas.add(new Persona("Rodriguez", "Florencia", "430456"));
        listPersonas.add(new Persona("Lopez", "Hector", "430457"));
        listPersonas.add(new Persona("Messi", "Lionel", "430458"));
        listPersonas.add(new Persona("Perez", "Enzo", "430459"));
        listPersonas.add(new Persona("Fernandez", "Ana", "430460"));
        listPersonas.add(new Persona("Ramos", "Matias", "430461"));
        listPersonas.add(new Persona("Jimenez", "Carlos", "430462"));
        listPersonas.add(new Persona("Perez", "Julieta", "430463"));
        listPersonas.add(new Persona("Gomez", "Julio", "430464"));
        listPersonas.add(new Persona("Perez", "Julia", "430465"));
        listPersonas.add(new Persona("Ganz", "Hugo", "430465"));
        listPersonas.add(new Persona("Spaghetti", "Ana Maria", "430465"));
        listPersonas.add(new Persona("Sanchez", "Juliana", "430465"));
        listPersonas.add(new Persona("Ramos", "Miguel", "430465"));

        AdapterPersona adapterPersona = new AdapterPersona(listPersonas);
        RecyclerView rv = findViewById(R.id.rvPersona);
        rv.setAdapter(adapterPersona);
        //LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // Grilla
        //GridLayoutManager glm = new GridLayoutManager(this, 3);

        // Scrolleo horizontal
        GridLayoutManager glm = new GridLayoutManager(this, 7, LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(glm);
    }

    public void llamarPorTelefono(int index) {
        Log.d("Llamada", "Llamando a... ");
    }
}