package com.example.modelopp;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProductoView {

    Activity act;
    Button btn;
    EditText edNombre;
    EditText edCantidad;
    EditText edPrecio;
    ProductoModel model;

    public ProductoView(Activity act, ProductoModel model, View.OnClickListener click) {
        this.act = act;
        this.btn = act.findViewById(R.id.btnGuardar);
        this.btn.setOnClickListener(click);
        this.edNombre = act.findViewById(R.id.edNombreProducto);
        this.edPrecio = act.findViewById(R.id.edPrecio);
        this.edCantidad = act.findViewById(R.id.edCantidad);
        this.model = model;
    }

    public void cargarModelo() {
        this.model.setNombre(this.edNombre.getText().toString());
        this.model.setCantidad(new Integer(this.edCantidad.getText().toString()));
        this.model.setPrecio(new Float(this.edPrecio.getText().toString()));
    }

    public void mostrarModelo() {
        this.edNombre.setText(this.model.getNombre());
        this.edCantidad.setText(this.model.getCantidad());
        this.edPrecio.setText(this.model.getPrecio().toString());
    }

}
