package com.example.restapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVBebidaAdaptador extends RecyclerView.Adapter<RVBebidaAdaptador.BebidaViewHolder> implements View.OnClickListener {
    List<Bebida> bebidas;
    int cantidad = 0;
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
    public void onBindViewHolder (final BebidaViewHolder bebidaViewHolder, int i){
        bebidaViewHolder.nombreBebida.setText(bebidas.get(i).nombre);
        bebidaViewHolder.descripcionBebida.setText(bebidas.get(i).descripcion);
        bebidaViewHolder.bebidaFoto.setImageResource(bebidas.get(i).fotoID);
        bebidaViewHolder.precioBebida.setText(bebidas.get(i).precio);

        bebidaViewHolder.btnOrdenBebida.setText("Agregar "+ bebidas.get(i).nombre + " a tu orden");
        bebidaViewHolder.btnOrdenBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_agregar_orden_bebida:

                        break;
                    case R.id.btn_mas:

                        cantidad++;
                        if (cantidad >15){
                            cantidad = 15;
                        }
                        bebidaViewHolder.txtCantidad.setText(String.valueOf(cantidad));

                        break;
                    case R.id.btn_menos:
                        cantidad--;
                        if (cantidad < 0){
                            cantidad = 0;
                        }
                        bebidaViewHolder.txtCantidad.setText(String.valueOf(cantidad));

                        break;
                }
            }
        });
    }

    @Override
    public void onClick(View v){

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
        EditText txtCantidad;

        public BebidaViewHolder(View itemView){
            super(itemView);
            cv = itemView.findViewById(R.id.cv_bebidas);
            nombreBebida = itemView.findViewById(R.id.nombre_bebida);
            descripcionBebida = itemView.findViewById(R.id.descripcion_bebida);
            precioBebida = itemView.findViewById(R.id.precio_bebida);
            bebidaFoto = itemView.findViewById(R.id.bebida_foto);
            btnOrdenBebida = itemView.findViewById(R.id.btn_agregar_orden_bebida);
            txtCantidad = itemView.findViewById(R.id.txtCantidad);

        }
    }

}
