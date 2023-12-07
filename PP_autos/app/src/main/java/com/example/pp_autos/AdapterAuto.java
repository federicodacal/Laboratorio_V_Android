package com.example.pp_autos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterAuto extends RecyclerView.Adapter<ViewHolderAuto> {

    List<Auto> autos;

    MainActivity act;

    public AdapterAuto(List<Auto> autos, MainActivity act) {
        this.autos = autos;
        this.act = act;
    }

    @NonNull
    @Override
    public ViewHolderAuto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_auto, parent, false);
        return new ViewHolderAuto(view, this.act);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAuto holder, int position) {
        Auto a = this.autos.get(position);

        holder.tvModelo.setText(a.getModel());
        holder.tvMarca.setText(a.getMake());
    }

    @Override
    public int getItemCount() { return this.autos.size(); }
}
