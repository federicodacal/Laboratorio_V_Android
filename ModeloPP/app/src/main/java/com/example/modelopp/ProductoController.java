package com.example.modelopp;

import android.os.Bundle;
import android.view.View;
import java.io.Serializable;
public class ProductoController {
    ProductoModel model;
    ProductoView view;
    Bundle bundle;
    public ProductoController(ProductoView view, ProductoModel model) {
        this.model = model;
        this.view = view;
        this.cargarDatos();
    }

    public void guardarProducto() {
        this.view.cargarModelo();
        if(this.validarDatos()) {
            MainActivity.producto.setNombre(model.getNombre());
            MainActivity.producto.setPrecio(model.getPrecio());
            MainActivity.producto.setCantidad(model.getCantidad());
            this.view.act.finish();
        }
    }

    private void cargarDatos() {
        this.bundle = this.view.act.getIntent().getExtras();
        Serializable ser = bundle.getSerializable("producto");
        ProductoModel prod = (ProductoModel) ser;

        if (prod != null) {
            this.model.setNombre(prod.getNombre());
            this.model.setPrecio(prod.getPrecio());
            this.model.setCantidad(prod.getCantidad());
        }
    }

    private boolean validarDatos() {
        return true;
    }

}
