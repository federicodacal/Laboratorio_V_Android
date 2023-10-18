package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterPersona extends RecyclerView.Adapter<ViewHolderPersona> {

    List<Persona> personas;

    public AdapterPersona(List<Persona> personas) {
        this.personas = personas;
    }

    @NonNull
    @Override
    public ViewHolderPersona onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persona, parent, false);
        return new ViewHolderPersona(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersona holder, int position) {
        Persona p = this.personas.get(position);

        holder.tvNombre.setText(p.getNombre());
        holder.tvApellido.setText(p.getApellido());
    }

    @Override
    public int getItemCount() {
        return this.personas.size();
    }
}
