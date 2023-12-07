package com.example.pp_autos;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderAuto extends RecyclerView.ViewHolder implements View.OnClickListener {

    MainActivity act;
    TextView tvModelo;
    TextView tvMarca;

    public ViewHolderAuto(@NonNull View itemView, MainActivity act) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.act = act;
        this.tvMarca = this.itemView.findViewById(R.id.tvMarca);
        this.tvModelo = this.itemView.findViewById(R.id.tvModelo);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), AutoActivity.class);

        if(super.getAbsoluteAdapterPosition() != RecyclerView.NO_POSITION) {
            i.putExtra("auto", this.act.autos.get(super.getAbsoluteAdapterPosition()));
            i.putExtra("pos", super.getAbsoluteAdapterPosition());

            Log.d("Click", this.act.autos.get(super.getAbsoluteAdapterPosition()).toString());

            v.getContext().startActivity(i);
        }
    }
}
