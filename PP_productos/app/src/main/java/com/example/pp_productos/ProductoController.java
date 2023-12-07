package com.example.pp_productos;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;

public class ProductoController implements View.OnClickListener {

    Producto model;
    ProductoView view;
    Bundle bundle;

    public ProductoController(Producto model, ProductoView view) {
        this.model = model;
        this.view = view;
        this.cargarDatos();
    }

    @Override
    public void onClick(View v) {
        if(this.validarCampos()) {
            this.view.llenarModelo();

            if(MainActivity.accion == 1) {
                MainActivity.producto.setNombre(this.model.getNombre());
                MainActivity.producto.setCantidad(this.model.getCantidad());
                MainActivity.producto.setPrecio(this.model.getPrecio());
            }
            else if(MainActivity.accion == 2) {
                Producto newProduct = new Producto();
                newProduct.setNombre(this.model.getNombre());
                newProduct.setCantidad(this.model.getCantidad());
                newProduct.setPrecio(this.model.getPrecio());
                MainActivity.productos.add(newProduct);
            }

            this.view.act.finish();
        }
    }

    private void cargarDatos() {
        this.bundle = this.view.act.getIntent().getExtras();
        Serializable ser = bundle.getSerializable("prod");
        Producto p = (Producto) ser;

        if(p != null) {
            this.model.setNombre(p.getNombre());
            this.model.setCantidad(p.getCantidad());
            this.model.setPrecio(p.getPrecio());
        }
    }

    public boolean validarCampos() {

        boolean res = false;

        if(this.view.edNombre.getText().toString().isEmpty() || this.view.edCantidad.getText().toString().isEmpty() || this.view.edPrecio.getText().toString().isEmpty()) {
            Toast.makeText(this.view.act, R.string.toast_empty, Toast.LENGTH_LONG).show();
        }
        else {
            res = true;
        }
        return res;
    }
}
