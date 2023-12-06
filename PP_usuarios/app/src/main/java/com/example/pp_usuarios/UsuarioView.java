package com.example.pp_usuarios;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class UsuarioView {

    EditText edName;
    EditText edPwd;
    EditText edPwd2;
    RadioGroup rgType;
    RadioButton rbAdmin;
    RadioButton rbUser;
    Button btnSave;
    Activity act;
    Usuario model;
    UsuarioController controller;

    public UsuarioView(Activity act, Usuario model) {
        this.act = act;
        this.model = model;
    }

    public void setController(UsuarioController controller) {
        this.controller = controller;
        this.btnSave = act.findViewById(R.id.btnSave);
        this.btnSave.setOnClickListener(controller);
        this.cargarElementos();
    }

    public void cargarElementos() {
        if (this.edName == null) {
            this.edName = this.act.findViewById(R.id.edName);
        }
        if (this.edPwd == null) {
            this.edPwd = this.act.findViewById(R.id.edPwd);
        }
        if (this.edPwd2 == null) {
            this.edPwd2 = this.act.findViewById(R.id.edPwdDos);
        }
        if (this.rgType == null) {
            this.rgType = this.act.findViewById(R.id.rgType);
        }
        if (this.rbAdmin == null) {
            this.rbAdmin = this.act.findViewById(R.id.rbAdmin);
        }
        if (this.rbUser == null) {
            this.rbUser = this.act.findViewById(R.id.rbUser);
        }
    }

    public void llenarModelo() {
        this.model.setNombre(this.edName.getText().toString());
        this.model.setContrasenia(this.edPwd.getText().toString());

        if (this.rbAdmin.isChecked()) {
            this.model.setTipo("admin");
        } else if (this.rbUser.isChecked()) {
            this.model.setTipo("user");
        }
    }

    public void mostrarModelo() {
        this.edName.setText(this.model.getNombre());
        this.edPwd.setText(this.model.getContrasenia());
        this.edPwd2.setText(this.model.getContrasenia());

        if (this.model.getTipo().equals("admin")) {
            this.rgType.check(rbAdmin.getId());
        } else if (this.model.getTipo().equals("user")) {
            this.rgType.check(rbUser.getId());
        }
    }

}
