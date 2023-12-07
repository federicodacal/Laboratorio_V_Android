package com.example.pp_productos;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderProducto extends RecyclerView.ViewHolder implements View.OnClickListener {

    MainActivity act;
    TextView tvProducto;
    TextView tvCantidad;
    TextView tvPrecio;

    public ViewHolderProducto(@NonNull View itemView, MainActivity act) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.act = act;
        this.tvProducto = this.itemView.findViewById(R.id.tvProducto);
        this.tvCantidad = this.itemView.findViewById(R.id.tvCantidad);
        this.tvPrecio = this.itemView.findViewById(R.id.tvPrecio);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), ProductoActivity.class);

        if(super.getAbsoluteAdapterPosition() != RecyclerView.NO_POSITION) {
            i.putExtra("prod", this.act.productos.get(super.getAbsoluteAdapterPosition()));
            i.putExtra("pos", super.getAbsoluteAdapterPosition());
            i.putExtra("accion", 1);

            Log.d("Click", this.act.productos.get(super.getAbsoluteAdapterPosition()).toString());

            v.getContext().startActivity(i);
        }
    }
}
