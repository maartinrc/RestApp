package com.example.restapp.vistas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.restapp.R;
import com.example.restapp.adaptadores.RVAdaptador;
import com.example.restapp.adaptadores.RVBebidaAdaptador;
import com.example.restapp.adaptadores.RVPostreAdaptador;
import com.example.restapp.pojos.Bebida;
import com.example.restapp.pojos.Platillo;
import com.example.restapp.pojos.Postre;
import com.example.restapp.pojos.Producto;
import com.example.restapp.pojos.Usuario;
import com.example.restapp.sw.ObjectRequest;

import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private List<Platillo> platillo;
    private RecyclerView rv;

    private List<Bebida> bebidas;
    private RecyclerView rvBebidas;

    private List<Postre> postres;
    private  RecyclerView rvPostres;

    int piso;
    int mesa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent i = getIntent();

        rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        rvBebidas = findViewById(R.id.rv_bebidas);
        LinearLayoutManager llmBebidas = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvBebidas.setLayoutManager(llmBebidas);
        rvBebidas.setHasFixedSize(true);

        rvPostres = findViewById(R.id.rv_postres);
        LinearLayoutManager llmPostres = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        rvPostres.setLayoutManager(llmPostres);
        rvPostres.setHasFixedSize(true);


        piso = i.getIntExtra("piso",0);
        mesa =i.getIntExtra("mesa",0);
        if(piso == 0){
            Toast.makeText(this,"Error, piso no detectado correctamente",Toast.LENGTH_LONG).show();
        }else if (mesa == 0){
            Toast.makeText(this,"Error, mesa no detectado correctamente",Toast.LENGTH_LONG).show();
        }

        extraeDatos();
        inicilizarAdaptador();


        /*TODO cambiar a las clases Bebida, Platillo, Postre y Producto el fotoID por fotoRuta tipo
        * String*/
    }


   public void extraeDatos(){
        String url = "http://10.55.108.44:8000/api/productos";


       ObjectRequest objectRequest = new ObjectRequest<Producto[]>
               (Request.Method.GET,url, null, Producto[].class, new Response.Listener<Producto[]>() {

                   @Override
                   public void onResponse(Producto[] response) {
                       //categorizar platillo, bebida,postre
                       for(Producto prod : response){
                           if(prod.getTipo()==0){//Platillo
                               Platillo p = new Platillo(prod.getNombre(),prod.getDescripcion(),prod.getFotoID(),prod.getPrecio());
                                platillo.add(p);
                           }else if(prod.getTipo()== 1){//bebida
                               Bebida b = new Bebida(prod.getNombre(),prod.getDescripcion(),prod.getFotoID(),prod.getPrecio());
                               bebidas.add(b);
                           }else {//postre
                               Postre pos = new Postre(prod.getNombre(),prod.getDescripcion(),prod.getFotoID(),prod.getPrecio());
                                postres.add(pos);
                           }
                       }

                   }
               }, new Response.ErrorListener() {

                   @Override
                   public void onErrorResponse(VolleyError error) {
                       // TODO Auto-generated method stub
                    Toast.makeText(getApplicationContext(),"No se pudieron obtener los datos", Toast.LENGTH_LONG);
                   }
               });

    }

    private void inicilizarAdaptador(){
        try {

            RVAdaptador adaptador = new RVAdaptador(platillo);
            rv.setAdapter(adaptador);

            RVBebidaAdaptador adaptadorB = new RVBebidaAdaptador(bebidas);
            rvBebidas.setAdapter(adaptadorB);

            RVPostreAdaptador adaptadorP = new RVPostreAdaptador(postres);
            rvPostres.setAdapter(adaptadorP);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
