package com.example.ejerformulario;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PersonaView {

    Activity act;
    Button btn;
    EditText edNombre;
    EditText edApellido;
    EditText edDni;
    RadioGroup rgSexo;
    RadioButton rbSexo;
    PersonaModel model;
    public PersonaView(Activity act, PersonaModel model, View.OnClickListener click) {
        this.act = act;
        this.btn = act.findViewById(R.id.btnGuardar);
        this.btn.setOnClickListener(click);
        this.edNombre = act.findViewById(R.id.edNombre);
        this.edApellido = act.findViewById(R.id.edApellido);
        this.edDni = act.findViewById(R.id.edDni);
        this.rgSexo = act.findViewById(R.id.rgSexo);
        this.model = model;
    }

    public void cargarModelo() {
        this.model.setNombre(this.edNombre.getText().toString());
        this.model.setApellido(this.edApellido.getText().toString());
        this.model.setDni(this.edDni.getText().toString());

        int radioId = rgSexo.getCheckedRadioButtonId();
        this.rbSexo = this.act.findViewById(radioId);
        this.model.setSexo(this.rbSexo.getText().toString());
    }

    public void mostrarModelo() {
        // Busco el objeto persona y lo muestro
        this.edNombre.setText(this.model.getNombre());
        this.edApellido.setText(this.model.getApellido());
        this.edDni.setText(this.model.getDni());
    }
}
