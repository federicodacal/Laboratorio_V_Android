package com.example.modelopp;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderProducto extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvNombre;
    TextView tvPrecio;
    TextView tvCantidad;

    public ViewHolderProducto(@NonNull View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.tvNombre = this.itemView.findViewById(R.id.tvNombre);
        this.tvPrecio = this.itemView.findViewById(R.id.tvPrecio);
        this.tvCantidad = this.itemView.findViewById(R.id.tvCantidad);
    }


    @Override
    public void onClick(View view) {
        Log.d("Click", "Click " + super.getAbsoluteAdapterPosition());
    }
}
