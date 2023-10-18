package com.example.ejerformulario;

import android.util.Log;

public class PersonaController  {
    PersonaModel model;
    PersonaView view;
    public PersonaController(PersonaView view, PersonaModel model) {
        this.model = model;
        this.view = view;
    }

    public void guardarPersona() {
        this.view.cargarModelo();
        if(this.validarDatos()) {
            // Llamar servicio POST para guardar persona
            Log.d("Click", this.model.toString());
        }
    }

    private boolean validarDatos() {
        return true;
    }


}
