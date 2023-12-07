package com.example.pp_autos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class AutoActivity extends AppCompatActivity {

    public static Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);

        ActionBar ab = super.getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle(R.string.title_edit);

        this.bundle = super.getIntent().getExtras();

        Auto model = new Auto();
        AutoView view = new AutoView(this, model);
        AutoController controller = new AutoController(model, view);
        view.setController(controller);

        ArrayList<Integer> years = new ArrayList<>();
        years.add(2000);
        years.add(2001);
        years.add(2002);
        years.add(2003);
        years.add(2004);
        years.add(2005);
        years.add(2006);
        years.add(2007);
        years.add(2008);
        years.add(2009);
        years.add(2010);
        years.add(2011);
        years.add(2012);
        years.add(2013);
        years.add(2014);
        years.add(2015);
        years.add(2016);
        years.add(2017);
        years.add(2018);
        years.add(2019);
        years.add(2020);

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, years);
        view.spYear.setAdapter(arrayAdapter);

        view.mostrarModelo();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            super.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}