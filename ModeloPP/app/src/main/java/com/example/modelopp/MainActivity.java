package com.example.modelopp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ProductoModel producto = new ProductoModel();
    public AdapterProducto adapterProducto;
    public List<ProductoModel> listProductos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listProductos.add(new ProductoModel("Gaseosa", 250.5F, 4));
        listProductos.add(new ProductoModel("Cerveza", 450.5F, 1));
        listProductos.add(new ProductoModel("Alcohol en gel", 200F, 4));
        listProductos.add(new ProductoModel("Detergente", 355.5F, 2));
        listProductos.add(new ProductoModel("Galletitas", 265.5F, 3));
        listProductos.add(new ProductoModel("Arroz", 150.5F, 24));
        listProductos.add(new ProductoModel("Queso rallado", 154.5F, 4));
        listProductos.add(new ProductoModel("Chocolate", 152.35F, 4));
        listProductos.add(new ProductoModel("Jabon", 100F, 6));
        listProductos.add(new ProductoModel("Fideos", 124F, 1));
        listProductos.add(new ProductoModel("Pan", 100F, 3));
        listProductos.add(new ProductoModel("Alimento Gato", 1000F, 10));
        listProductos.add(new ProductoModel("Jugo", 140F, 2));

        this.adapterProducto = new AdapterProducto(listProductos);
        RecyclerView rv = findViewById(R.id.productoslistarRecyclerView);
        rv.setAdapter(adapterProducto);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.op1) {
            Log.d("Click", "Agregar");
            Intent intent = new Intent(this, AddActivity.class);
            this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    /*
    @Override
    protected void onRestart() {
        //if(2<1) {
            Log.d("Resume", "En la Main Activity");
            int index = AddActivity.bundle.getInt("posicion");
            this.listProductos.get(index).setNombre(producto.getNombre());
            this.listProductos.get(index).setPrecio(producto.getPrecio());
            this.listProductos.get(index).setCantidad(producto.getCantidad());
            this.adapterProducto.notifyItemChanged(index);
            super.onRestart();
       //}
    }*/

}