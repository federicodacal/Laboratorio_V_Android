package com.example.pp_autos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<Auto> autos = new ArrayList<>();
    public static Auto auto = new Auto();
    public static boolean edit = false;
    AdapterAuto adapterAuto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autos.add(new Auto(1, "Toyota", "Modelo1", 2002));
        autos.add(new Auto(2, "Fiat", "Modelo2", 2000));
        autos.add(new Auto(3, "Volvo", "Modelo3", 2012));
        autos.add(new Auto(4, "Ferrari", "Modelo4", 2020));
        autos.add(new Auto(5, "Ford", "Modelo5", 2019));
        autos.add(new Auto(6, "Nissan", "Modelo6", 2018));
        autos.add(new Auto(7, "BMW", "Modelo7", 2018));
        autos.add(new Auto(8, "Audi", "Modelo8", 2016));
        autos.add(new Auto(9, "Alfa Romeo", "Modelo9", 2014));
        autos.add(new Auto(10, "Volkswagen", "Modelo10", 2015));

        this.adapterAuto = new AdapterAuto(autos, this);
        RecyclerView rv = findViewById(R.id.rvAuto);
        rv.setAdapter(adapterAuto);

        GridLayoutManager glm = new GridLayoutManager(this, 2);

        rv.setLayoutManager(glm);
    }

    @Override
    protected void onRestart() {
        if(MainActivity.edit) {

            int i = AutoActivity.bundle.getInt("pos");
            this.autos.get(i).setMake(auto.getMake());
            this.autos.get(i).setModel(auto.getModel());
            this.autos.get(i).setYear(auto.getYear());
            MainActivity.edit = false;
            this.adapterAuto.notifyItemChanged(i);
        }
        super.onRestart();
    }
}