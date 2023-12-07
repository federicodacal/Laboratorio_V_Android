package com.example.pp_productos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterProducto extends RecyclerView.Adapter<ViewHolderProducto> {

    List<Producto> productos;
    MainActivity act;

    public AdapterProducto(List<Producto> productos, MainActivity act) {
        this.productos = productos;
        this.act = act;
    }

    @NonNull
    @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ViewHolderProducto(view, this.act);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto holder, int position) {
        Producto p = this.productos.get(position);

        holder.tvProducto.setText(p.getNombre());
        holder.tvCantidad.setText(p.getCantidad().toString());
        holder.tvPrecio.setText(p.getPrecio().toString());
    }

    @Override
    public int getItemCount() { return this.productos.size(); }
}
