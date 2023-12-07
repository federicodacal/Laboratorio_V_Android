package com.example.pp_autos;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;

public class AutoController implements View.OnClickListener {

    Auto model;
    AutoView view;
    Bundle bundle;

    public AutoController(Auto model, AutoView view) {
        this.model = model;
        this.view = view;
        this.cargarDatos();
    }

    private void cargarDatos() {
        this.bundle = this.view.act.getIntent().getExtras();
        Serializable ser = bundle.getSerializable("auto");
        Auto a = (Auto) ser;

        if(a != null) {
            this.model.setModel(a.getModel());
            this.model.setMake(a.getMake());
            this.model.setYear(a.getYear());
        }
    }

    public boolean validarCampos() {

        boolean res = false;

        if(this.view.edMake.getText().toString().isEmpty() || this.view.edModel.getText().toString().isEmpty()) {
            Toast.makeText(this.view.act, R.string.toast_empty, Toast.LENGTH_LONG).show();
        }
        else {
            res = true;
        }
        return res;
    }

    @Override
    public void onClick(View v) {
        if(this.validarCampos()) {
            this.view.llenarModelo();
            MainActivity.auto.setModel(this.model.getModel());
            MainActivity.auto.setMake(this.model.getMake());
            MainActivity.auto.setYear(this.model.getYear());
            MainActivity.edit = true;
            this.view.act.finish();
        }
    }
}
