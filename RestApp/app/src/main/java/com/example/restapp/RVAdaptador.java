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

public class RVAdaptador extends RecyclerView.Adapter<RVAdaptador.PlatilloViewHolder> implements View.OnClickListener {

    List<Platillo> platillos;

    public RVAdaptador(List<Platillo> platillos){
        this.platillos = platillos;

    }

    //Métodos Abstractos de Recycler.Adapter
    @Override
    public int getItemCount(){
        return platillos.size();
    }

    @Override
    public PlatilloViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_menu,viewGroup,false);
        PlatilloViewHolder pvh = new PlatilloViewHolder(v);
        return  pvh;
    }

    @Override
    public void onBindViewHolder(PlatilloViewHolder platilloViewHolder, int i){
        platilloViewHolder.nombrePlatillo.setText(platillos.get(i).nombre);
        platilloViewHolder.descripcionPlatillo.setText(platillos.get(i).descripcion);
        platilloViewHolder.platilloFoto.setImageResource(platillos.get(i).fotoID);
        platilloViewHolder.precioPlatillo.setText(platillos.get(i).precio);

        platilloViewHolder.btnOrden.setText("agregar "+platillos.get(i).nombre+" a tu orden");
        platilloViewHolder.btnOrden.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_agregar_orden:

                break;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public class PlatilloViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView nombrePlatillo;
        TextView descripcionPlatillo;
        TextView precioPlatillo;
        ImageView platilloFoto;
        Button btnOrden;



        public PlatilloViewHolder(View itemView){
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            nombrePlatillo= itemView.findViewById(R.id.nombre_platillo);
            descripcionPlatillo = itemView.findViewById(R.id.descripcion_platillo);
            platilloFoto = itemView.findViewById(R.id.platillo_foto);
            precioPlatillo= itemView.findViewById(R.id.precio_platillo);

            btnOrden = itemView.findViewById(R.id.btn_agregar_orden);


        }
    }
}
