package com.example.ejerformulario;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ClickMainActivity implements View.OnClickListener{
    PersonaController controller;

    public void setController(PersonaController controller) {
        this.controller = controller;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnGuardar) {
            this.controller.guardarPersona();
        }
    }
}
