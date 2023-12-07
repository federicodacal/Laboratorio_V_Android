package com.example.pp_usuarios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Usuario> usuarios = new ArrayList<>();
    public static Usuario user = new Usuario();
    AdapterUsuario adapterUsuario;
    public static int accion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarios.add(new Usuario("User1", "1234", "admin"));
        usuarios.add(new Usuario("User2", "12345", "user"));
        usuarios.add(new Usuario("User3", "1234", "user"));
        usuarios.add(new Usuario("User4", "1234", "user"));
        usuarios.add(new Usuario("User5", "1234", "user"));
        usuarios.add(new Usuario("User6", "1234", "user"));
        usuarios.add(new Usuario("User7", "1234", "user"));
        usuarios.add(new Usuario("User8", "1234", "user"));
        usuarios.add(new Usuario("User9", "1234", "user"));
        usuarios.add(new Usuario("User10", "1234", "admin"));
        usuarios.add(new Usuario("User11", "1234", "user"));
        usuarios.add(new Usuario("User12", "1234", "user"));
        usuarios.add(new Usuario("User13", "1234", "user"));
        usuarios.add(new Usuario("User14", "1234", "user"));
        usuarios.add(new Usuario("User15", "1234", "user"));
        usuarios.add(new Usuario("User16", "1234", "user"));
        usuarios.add(new Usuario("User17", "1234", "admin"));
        usuarios.add(new Usuario("User18", "1234", "admin"));
        usuarios.add(new Usuario("User19", "1234", "user"));
        usuarios.add(new Usuario("User20", "1234", "user"));
        usuarios.add(new Usuario("User21", "1234", "admin"));
        usuarios.add(new Usuario("User22", "1234", "user"));
        usuarios.add(new Usuario("User23", "1234", "user"));
        usuarios.add(new Usuario("User24", "1234", "user"));
        usuarios.add(new Usuario("User25", "1234", "user"));

        adapterUsuario = new AdapterUsuario(usuarios, this);
        RecyclerView rv = findViewById(R.id.rvUsuario);
        rv.setAdapter(adapterUsuario);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
    }

    @Override
    protected void onRestart() {
        if(MainActivity.accion != 0) {

            if(MainActivity.accion == 1) {
                int i = UsuarioActivity.bundle.getInt("pos");
                this.usuarios.get(i).setNombre(user.getNombre());
                this.usuarios.get(i).setContrasenia(user.getContrasenia());
                this.usuarios.get(i).setTipo(user.getTipo());
                MainActivity.accion = 0;
                this.adapterUsuario.notifyItemChanged(i);
            }
            else if(MainActivity.accion == 2) {
                MainActivity.accion = 0;
                this.adapterUsuario.notifyDataSetChanged();
            }

        }
        super.onRestart();
    }
}