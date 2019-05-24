package com.example.restapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private List<Platillo> platillo;
    private RecyclerView rv;

    private List<Bebida> bebidas;
    private RecyclerView rvBebidas;

    private List<Postre> postres;
    private  RecyclerView rvPostres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        extraeDatos();


        /*TODO cambiar a las clases Bebida, Platillo, Postre y Producto el fotoID por fotoRuta tipo
        * String*/
    }


   public void extraeDatos(){

    }
}
