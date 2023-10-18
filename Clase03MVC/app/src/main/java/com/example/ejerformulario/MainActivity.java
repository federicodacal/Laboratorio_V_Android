package com.example.ejerformulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonaModel model = new PersonaModel();
        ClickMainActivity myListener = new ClickMainActivity();
        PersonaView view = new PersonaView(this, model, myListener);
        PersonaController controller = new PersonaController(view, model);
        myListener.setController(controller);

    }
}