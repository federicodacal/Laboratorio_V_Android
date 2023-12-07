package com.example.pp_usuarios;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;

public class UsuarioController implements View.OnClickListener {

    Usuario model;
    UsuarioView view;
    Bundle bundle;

    public UsuarioController(Usuario model, UsuarioView view) {
        this.model = model;
        this.view = view;
        this.cargarDatos();
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnSave) {
            if(this.validarCampos()) {
                this.view.llenarModelo();
                MainActivity.user.setNombre(this.model.getNombre());
                MainActivity.user.setContrasenia(this.model.getContrasenia());
                MainActivity.user.setTipo(this.model.getTipo());
                MainActivity.accion = 1;
                this.view.act.finish();
            }
        }
        else if(v.getId() == R.id.btnDelete) {
            MainActivity.usuarios.remove(this.bundle.getInt("pos"));
            MainActivity.accion = 2;
            this.view.act.finish();
        }

    }

    private void cargarDatos() {
        this.bundle = this.view.act.getIntent().getExtras();
        Serializable ser = bundle.getSerializable("user");
        Usuario u = (Usuario) ser;

        if(u != null) {
            this.model.setNombre(u.getNombre());
            this.model.setContrasenia(u.getContrasenia());
            this.model.setTipo(u.getTipo());
        }
    }

    public boolean validarCampos() {

        boolean res = false;

        if(this.view.edPwd.getText().toString().isEmpty() || this.view.edPwd2.getText().toString().isEmpty() || this.view.edName.getText().toString().isEmpty()) {
            Toast.makeText(this.view.act, R.string.toast_empty, Toast.LENGTH_LONG).show();
        }
        else {
            if(this.view.edName.getText().toString().length() <= 3) {
                Toast.makeText(this.view.act, R.string.toast_userLength, Toast.LENGTH_LONG).show();
            }
            else if (!this.view.edPwd.getText().toString().equals(this.view.edPwd2.getText().toString())) {
                Toast.makeText(this.view.act, R.string.toast_pwd, Toast.LENGTH_LONG).show();
            }
            else {
                res = true;
            }
        }
        return res;
    }
}
