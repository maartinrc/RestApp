package com.example.restapp.vistas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


/*TODO -------------- LEER -------------------
* Esta Activity será la que se ejecute primero,
* Aquí irá la lógica del login y el HomeActivity
* Primero, el programa se asegura que exista un archivo de shared preferences, este
* achivo tiene las credenciales del usuario.
* si existe, pasa a HomeActivity directamente, y si no,
* el login consume el servicio web y si se encuentran coincidencias,
* se crea un archivo shared preferences.
* */
public class MainActivity extends AppCompatActivity {
    private Typeface righteous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
       // String fuente = "fuentes/Righteous.ttf";
      //  this.righteous = Typeface.createFromAsset(getAssets(),fuente);

        SharedPreferences credenciales = getSharedPreferences("login", Context.MODE_PRIVATE);
        String username = credenciales.getString("usuario",null);
        String password = credenciales.getString("contrasena",null);

        if(username != null && password != null){
            Intent intent = new Intent(this,HomeActivity.class);
            this.startActivity(intent);

        }else{
            Intent intent = new Intent(this, Login.class);
            this.startActivity(intent);
        }


    }
}
