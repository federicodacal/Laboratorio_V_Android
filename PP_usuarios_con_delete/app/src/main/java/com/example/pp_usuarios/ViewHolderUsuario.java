package com.example.pp_usuarios;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderUsuario extends RecyclerView.ViewHolder implements View.OnClickListener {

    MainActivity act;
    TextView tvName;
    TextView tvType;

    public ViewHolderUsuario(@NonNull View itemView, MainActivity act) {
        super(itemView);
        itemView.setOnClickListener(this);
        this.act = act;
        this.tvName = this.itemView.findViewById(R.id.tvName);
        this.tvType = this.itemView.findViewById(R.id.tvType);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), UsuarioActivity.class);

        if(super.getAbsoluteAdapterPosition() != RecyclerView.NO_POSITION) {
            i.putExtra("user", this.act.usuarios.get(super.getAbsoluteAdapterPosition()));
            i.putExtra("pos", super.getAbsoluteAdapterPosition());

            Log.d("Click", this.act.usuarios.get(super.getAbsoluteAdapterPosition()).toString());

            v.getContext().startActivity(i);
        }
    }
}
