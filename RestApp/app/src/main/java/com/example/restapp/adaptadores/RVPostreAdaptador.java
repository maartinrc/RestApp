package com.example.restapp.adaptadores;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restapp.R;
import com.example.restapp.pojos.Postre;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RVPostreAdaptador extends RecyclerView.Adapter<RVPostreAdaptador.PostreViewHolder> implements View.OnClickListener {

    List<Postre> postres;
    int cantidad = 0;

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
    public void onBindViewHolder(final PostreViewHolder postreViewHolder, int i){
        postreViewHolder.nombrePostre.setText(postres.get(i).getNombre());
        postreViewHolder.descripcionPostre.setText(postres.get(i).getDescripcion());
        Picasso.get().load(postres.get(i).getFotoID()).into(postreViewHolder.postreFoto);
        postreViewHolder.precioPostre.setText(postres.get(i).getPrecio());

        postreViewHolder.btnOrdenPostre.setText("Agregar "+ postres.get(i).getNombre()+" a tu orden");
        postreViewHolder.btnOrdenPostre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn_agregar_orden_postre:

                        break;
                }

            }
        });
        postreViewHolder.btnmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidad++;
                if (cantidad >15){
                    cantidad = 15;
                }
                postreViewHolder.txtCantidad.setText(String.valueOf(cantidad));
            }
        });

        postreViewHolder.btnmenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidad--;
                if (cantidad < 0){
                    cantidad = 0;
                }
                postreViewHolder.txtCantidad.setText(String.valueOf(cantidad));

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

    public class PostreViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView nombrePostre;
        TextView descripcionPostre;
        TextView precioPostre;
        ImageView postreFoto;
        Button btnOrdenPostre;
        EditText txtCantidad;
        Button btnmas;
        Button btnmenos;

        public PostreViewHolder(View itemView){
            super(itemView);
            cv = itemView.findViewById(R.id.cv_postre);
            nombrePostre = itemView.findViewById(R.id.nombre_postre);
            descripcionPostre = itemView.findViewById(R.id.descripcion_postre);
            precioPostre = itemView.findViewById(R.id.precio_postre);
            postreFoto = itemView.findViewById(R.id.postre_foto);

            btnOrdenPostre = itemView.findViewById(R.id.btn_agregar_orden_postre);
            txtCantidad = itemView.findViewById(R.id.txtCantidad_postre);

            btnmas = itemView.findViewById(R.id.btn_mas_postre);
            btnmenos = itemView.findViewById(R.id.btn_menos_postre);
        }
    }
}
