package com.example.restapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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


        piso = i.getIntExtra("piso",0);
        mesa =i.getIntExtra("mesa",0);
        if(piso == 0){
            Toast.makeText(this,"Error, piso no detectado correctamente",Toast.LENGTH_LONG).show();
        }else if (mesa == 0){
            Toast.makeText(this,"Error, mesa no detectado correctamente",Toast.LENGTH_LONG).show();
        }

        extraeDatos();


        /*TODO cambiar a las clases Bebida, Platillo, Postre y Producto el fotoID por fotoRuta tipo
        * String*/
    }


   public void extraeDatos(){
        ConsumidorWeb cw = new ConsumidorWeb("postres",this);

        cw.showAll();
    }

    private void inicilizarAdaptador(){
        RVAdaptador adaptador = new RVAdaptador(platillo);
        rv.setAdapter(adaptador);

        RVBebidaAdaptador adaptadorB = new RVBebidaAdaptador(bebidas);
        rvBebidas.setAdapter(adaptadorB);

        RVPostreAdaptador adaptadorP = new RVPostreAdaptador(postres);
        rvPostres.setAdapter(adaptadorP);
    }
}
