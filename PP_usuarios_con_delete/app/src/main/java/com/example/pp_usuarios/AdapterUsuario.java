package com.example.pp_usuarios;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterUsuario extends RecyclerView.Adapter<ViewHolderUsuario> {

    List<Usuario> usuarios;

    MainActivity act;

    public AdapterUsuario(List<Usuario> usuarios, MainActivity act) {
        this.usuarios = usuarios;
        this.act = act;
    }

    @NonNull
    @Override
    public ViewHolderUsuario onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new ViewHolderUsuario(view, this.act);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUsuario holder, int position) {
        Usuario u = this.usuarios.get(position);

        holder.tvName.setText(u.getNombre());
        holder.tvType.setText(u.getTipo());
    }

    @Override
    public int getItemCount() {
        return this.usuarios.size();
    }
}
