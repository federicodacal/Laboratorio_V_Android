package com.example.pp_usuarios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class UsuarioActivity extends AppCompatActivity {

    public static Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        ActionBar ab = super.getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(R.string.title_edit);

        this.bundle = super.getIntent().getExtras();

        Usuario model = new Usuario();
        UsuarioView view = new UsuarioView(this, model);
        UsuarioController controller = new UsuarioController(model, view);
        view.setController(controller);
        view.mostrarModelo();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}