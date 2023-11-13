package com.example.modelopp;

import android.view.View;

public class ClickListener implements View.OnClickListener {

    ProductoController controller;

    public void setController(ProductoController controller){
        this.controller = controller;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnGuardar) {
            this.controller.guardarProducto();
        }
    }
}
