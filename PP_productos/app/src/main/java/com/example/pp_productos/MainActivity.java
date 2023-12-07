package com.example.pp_productos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Producto> productos = new ArrayList<>();
    public static Producto producto = new Producto();
    AdapterProducto adapterProducto;
    public static int accion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productos.add(new Producto("Chocolate", 1, 200f));
        productos.add(new Producto("Jabon", 1, 150f));
        productos.add(new Producto("Detergente", 1, 100f));
        productos.add(new Producto("Jugo", 4, 550.50f));
        productos.add(new Producto("Café", 10, 1240.75f));
        productos.add(new Producto("Tomate", 1, 120f));
        productos.add(new Producto("Yerba", 3, 450f));
        productos.add(new Producto("Gaseosa", 1, 300f));
        productos.add(new Producto("Papas Fritas", 1, 1400f));
        productos.add(new Producto("Queso Rallado", 3, 2000f));
        productos.add(new Producto("Leche", 1, 220f));
        productos.add(new Producto("Vino", 2, 4000f));
        productos.add(new Producto("Arroz", 1, 150f));
        productos.add(new Producto("Fideos", 1, 100f));
        productos.add(new Producto("Lechuga", 1, 130.33f));

        adapterProducto = new AdapterProducto(productos, this);
        RecyclerView rv = findViewById(R.id.rvProducto);
        rv.setAdapter(adapterProducto);
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
    }

    @Override
    protected void onRestart() {
        if(MainActivity.accion != 0) {

            if(MainActivity.accion == 1) {
                int i = ProductoActivity.bundle.getInt("pos");
                this.productos.get(i).setNombre(producto.getNombre());
                this.productos.get(i).setCantidad(producto.getCantidad());
                this.productos.get(i).setPrecio(producto.getPrecio());
                MainActivity.accion = 0;
                this.adapterProducto.notifyItemChanged(i);
            }
            else if(MainActivity.accion == 2) {
                MainActivity.accion = 0;
                this.adapterProducto.notifyDataSetChanged();
            }
        }
        super.onRestart();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.add) {
            Intent intent = new Intent(this, ProductoActivity.class);
            intent.putExtra("accion", 2);
            this.startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}