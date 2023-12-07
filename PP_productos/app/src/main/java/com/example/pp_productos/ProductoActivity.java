package com.example.pp_productos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class ProductoActivity extends AppCompatActivity {

    public static Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        ActionBar ab = super.getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        this.bundle = super.getIntent().getExtras();

        Producto model = new Producto();
        ProductoView view = new ProductoView(this, model);
        ProductoController controller = new ProductoController(model, view);
        view.setController(controller);

        if(this.bundle.getInt("accion") == 1) {
            MainActivity.accion = 1;
            ab.setTitle(R.string.title_edit);
            view.mostrarModelo();
        }
        else if(this.bundle.getInt("accion") == 2) {
            MainActivity.accion = 2;
            ab.setTitle(R.string.title_add);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}