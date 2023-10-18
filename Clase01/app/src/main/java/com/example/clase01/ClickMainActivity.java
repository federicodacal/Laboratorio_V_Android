package com.example.clase01;

import android.app.Activity;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class ClickMainActivity implements View.OnClickListener {

    EditText editText;
    TextView tvSaludo;
    Activity ac;

    ClickMainActivity(Activity ac) {
        this.ac = ac;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnSaludo) {
            this.manejoBtnSaludo();
        }
        else if(view.getId() == R.id.btnOtro) {
            this.manejoBtnOtro();
        }
    }

    private void manejoBtnSaludo() {
        if(this.editText==null) {
            this.editText = this.ac.findViewById(R.id.edNombre);
            Log.d("Click", "Hizo CLICK " + editText.getText());

            this.tvSaludo = this.ac.findViewById(R.id.tvSaludo);
        }

        this.tvSaludo.setText("Hola " + this.editText.getText());
    }

    private void manejoBtnOtro() {
        if(this.tvSaludo == null) {
            this.tvSaludo = this.ac.findViewById(R.id.tvSaludo);
        }
        this.tvSaludo.setText("Click en otro");
    }
}
