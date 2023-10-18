package com.example.recyclerview;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderPersona extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvNombre;
    TextView tvApellido;

    public ViewHolderPersona(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.tvNombre = this.itemView.findViewById(R.id.tvNombre);
        this.tvApellido = this.itemView.findViewById(R.id.tvApellido);
    }


    @Override
    public void onClick(View view) {
        Log.d("Click", "Click " + super.getAbsoluteAdapterPosition());
    }
}
