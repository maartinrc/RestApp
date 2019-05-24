package com.example.restapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVBebidaAdaptador extends RecyclerView.Adapter<RVBebidaAdaptador.BebidaViewHolder> implements View.OnClickListener {
    List<Bebida> bebidas;

    public RVBebidaAdaptador(List<Bebida> bebidas){
        this.bebidas = bebidas;
    }

    //Métodos abstractos de Recycler.Adapter
    @Override
    public int getItemCount(){
        return bebidas.size();
    }

    @Override
    public BebidaViewHolder onCreateViewHolder(ViewGroup viewGroup,int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_menu_bebidas,viewGroup,false);
        BebidaViewHolder bvh = new BebidaViewHolder(v);
        return bvh;
    }

    @Override
    public void onBindViewHolder (BebidaViewHolder bebidaViewHolder, int i){
        bebidaViewHolder.nombreBebida.setText(bebidas.get(i).nombre);
        bebidaViewHolder.descripcionBebida.setText(bebidas.get(i).descripcion);
        bebidaViewHolder.bebidaFoto.setImageResource(bebidas.get(i).fotoID);
        bebidaViewHolder.precioBebida.setText(bebidas.get(i).precio);

        bebidaViewHolder.btnOrdenBebida.setText("Agregar "+ bebidas.get(i).nombre + " a tu orden");
        bebidaViewHolder.btnOrdenBebida.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_agregar_orden_bebida:

                break;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }


    public class BebidaViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView nombreBebida;
        TextView descripcionBebida;
        TextView precioBebida;
        ImageView bebidaFoto;
        Button btnOrdenBebida;

        public BebidaViewHolder(View itemView){
            super(itemView);
            cv = itemView.findViewById(R.id.cv_bebidas);
            nombreBebida = itemView.findViewById(R.id.nombre_bebida);
            descripcionBebida = itemView.findViewById(R.id.descripcion_bebida);
            precioBebida = itemView.findViewById(R.id.precio_bebida);
            bebidaFoto = itemView.findViewById(R.id.bebida_foto);
            btnOrdenBebida = itemView.findViewById(R.id.btn_agregar_orden_bebida);

        }
    }

}
