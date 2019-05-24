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

public class RVPostreAdaptador extends RecyclerView.Adapter<RVPostreAdaptador.PostreViewHolder> implements View.OnClickListener {

    List<Postre> postres;

    public RVPostreAdaptador(List<Postre> postres){
        this.postres = postres;
    }

    //Métodos Abstractos de Recycler.Adapter
    @Override
    public int getItemCount(){
        return postres.size();
    }

    @Override
    public PostreViewHolder onCreateViewHolder(ViewGroup viewGroup,int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_menu_postres,viewGroup,false);
        PostreViewHolder pvh = new PostreViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PostreViewHolder postreViewHolder, int i){
        postreViewHolder.nombrePostre.setText(postres.get(i).nombre);
        postreViewHolder.descripcionPostre.setText(postres.get(i).descripcion);
        postreViewHolder.postreFoto.setImageResource(postres.get(i).fotoID);
        postreViewHolder.precioPostre.setText(postres.get(i).precio);

        postreViewHolder.btnOrdenPostre.setText("Agregar "+ postres.get(i).nombre+" a tu orden");
        postreViewHolder.btnOrdenPostre.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_agregar_orden:

                break;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class PostreViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView nombrePostre;
        TextView descripcionPostre;
        TextView precioPostre;
        ImageView postreFoto;
        Button btnOrdenPostre;

        public PostreViewHolder(View itemView){
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            nombrePostre = itemView.findViewById(R.id.nombre_postre);
            descripcionPostre = itemView.findViewById(R.id.descripcion_postre);
            precioPostre = itemView.findViewById(R.id.precio_postre);
            postreFoto = itemView.findViewById(R.id.postre_foto);

            btnOrdenPostre = itemView.findViewById(R.id.btn_agregar_orden_postre);
        }
    }
}
