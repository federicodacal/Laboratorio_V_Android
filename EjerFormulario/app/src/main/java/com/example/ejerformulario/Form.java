package com.example.ejerformulario;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Form implements View.OnClickListener{

    Activity ac;

    EditText edNombre;
    EditText edApellido;

    EditText edDni;

    RadioGroup rgSexo;
    RadioButton rbSexo;

    Form(Activity ac) {
        this.ac = ac;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnGuardar) {
            if(this.edNombre == null) {
                this.edNombre = this.ac.findViewById(R.id.edNombre);
            }
            if(this.edApellido == null) {
                this.edApellido = this.ac.findViewById(R.id.edApellido);
            }
            if(this.edDni == null) {
                this.edDni = this.ac.findViewById(R.id.edDni);
            }
            if(this.rgSexo == null) {
                this.rgSexo = this.ac.findViewById(R.id.rgSexo);
            }

            int radioId = rgSexo.getCheckedRadioButtonId();
            rbSexo = this.ac.findViewById(radioId);

            Persona p = new Persona(this.edNombre.getText().toString(), this.edApellido.getText().toString(), this.edDni.getText().toString(), rbSexo.getText().toString());

            Log.d("Click", "Guardar " + p.toString());
            Toast.makeText(this.ac, p.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
