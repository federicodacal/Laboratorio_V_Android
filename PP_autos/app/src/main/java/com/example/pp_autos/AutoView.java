package com.example.pp_autos;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AutoView {

    EditText edModel;
    EditText edMake;
    Spinner spYear;
    Button btnSave;
    Activity act;
    Auto model;
    AutoController controller;

    public AutoView(Activity act, Auto model) {
        this.act = act;
        this.model = model;
    }

    public void setController(AutoController controller) {
        this.controller = controller;
        this.btnSave = act.findViewById(R.id.btnSave);
        this.btnSave.setOnClickListener(controller);
        this.cargarElementos();
    }

    public void cargarElementos() {
        if (this.edModel == null) {
            this.edModel = this.act.findViewById(R.id.edModel);
        }
        if (this.edMake == null) {
            this.edMake = this.act.findViewById(R.id.edMake);
        }
        if (this.spYear == null) {
            this.spYear = this.act.findViewById(R.id.years_spinner);
        }
    }

    public void llenarModelo() {
        this.model.setMake(this.edMake.getText().toString());
        this.model.setModel(this.edModel.getText().toString());
        this.model.setYear((Integer) this.spYear.getSelectedItem());
    }

    public void mostrarModelo() {
        this.edMake.setText(this.model.getMake());
        this.edModel.setText(this.model.getModel());

        switch(this.model.getYear()) {
            case 2000:
                this.spYear.setSelection(0);
                break;
            case 2001:
                this.spYear.setSelection(1);
                break;
            case 2002:
                this.spYear.setSelection(2);
                break;
            case 2003:
                this.spYear.setSelection(3);
                break;
            case 2004:
                this.spYear.setSelection(4);
                break;
            case 2005:
                this.spYear.setSelection(5);
                break;
            case 2006:
                this.spYear.setSelection(6);
                break;
            case 2007:
                this.spYear.setSelection(7);
                break;
            case 2008:
                this.spYear.setSelection(8);
                break;
            case 2009:
                this.spYear.setSelection(9);
                break;
            case 2010:
                this.spYear.setSelection(10);
                break;
            case 2011:
                this.spYear.setSelection(11);
                break;
            case 2012:
                this.spYear.setSelection(12);
                break;
            case 2013:
                this.spYear.setSelection(13);
                break;
            case 2014:
                this.spYear.setSelection(14);
                break;
            case 2015:
                this.spYear.setSelection(15);
                break;
            case 2016:
                this.spYear.setSelection(16);
                break;
            case 2017:
                this.spYear.setSelection(17);
                break;
            case 2018:
                this.spYear.setSelection(18);
                break;
            case 2019:
                this.spYear.setSelection(19);
                break;
            case 2020:
                this.spYear.setSelection(20);
                break;
        }
    }
}
