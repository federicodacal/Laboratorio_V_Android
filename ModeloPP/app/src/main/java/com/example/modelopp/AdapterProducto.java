package com.example.modelopp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterProducto extends RecyclerView.Adapter<ViewHolderProducto>{
    List<ProductoModel> productos;

    public AdapterProducto(List<ProductoModel> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto, parent, false);
        return new ViewHolderProducto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto holder, int position) {
        ProductoModel p = this.productos.get(position);

        holder.tvNombre.setText(p.getNombre());
        holder.tvPrecio.setText(p.getPrecio().toString());
        holder.tvCantidad.setText(p.getCantidad().toString());
    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }
}
