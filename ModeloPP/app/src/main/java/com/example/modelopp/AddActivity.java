package com.example.modelopp;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    ActionBar actionBar;
    static Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        this.actionBar = super.getSupportActionBar();
        this.actionBar.setDisplayHomeAsUpEnabled(true);
        this.bundle = super.getIntent().getExtras();
        this.actionBar.setTitle("TITULO");


        ProductoModel model = new ProductoModel();
        ClickListener myListener = new ClickListener();
        ProductoView view = new ProductoView(this, model, myListener);
        ProductoController controller = new ProductoController(view, model);
        myListener.setController(controller);


        view.mostrarModelo();
    }

}
