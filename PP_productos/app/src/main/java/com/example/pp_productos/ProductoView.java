package com.example.pp_productos;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class ProductoView {

    EditText edNombre;
    EditText edCantidad;
    EditText edPrecio;
    Button btn;
    Producto model;
    Activity act;
    ProductoController controller;

    public ProductoView(Activity act, Producto model) {
        this.act = act;
        this.model = model;
    }

    public void setController(ProductoController controller) {
        this.controller = controller;
        this.btn = act.findViewById(R.id.btnSave);
        this.btn.setOnClickListener(controller);
        this.cargarElementos();
    }

    public void cargarElementos() {
        if (this.edNombre == null) {
            this.edNombre = this.act.findViewById(R.id.edNombre);
        }
        if (this.edCantidad == null) {
            this.edCantidad = this.act.findViewById(R.id.edCantidad);
        }
        if (this.edPrecio == null) {
            this.edPrecio = this.act.findViewById(R.id.edPrecio);
        }
    }

    public void llenarModelo() {
        this.model.setNombre(this.edNombre.getText().toString());
        this.model.setCantidad(Integer.parseInt(this.edCantidad.getText().toString()));
        this.model.setPrecio(Float.parseFloat(this.edPrecio.getText().toString()));
    }

    public void mostrarModelo() {
        this.edNombre.setText(this.model.getNombre());
        this.edCantidad.setText(this.model.getCantidad().toString());
        this.edPrecio.setText(this.model.getPrecio().toString());
    }

}
