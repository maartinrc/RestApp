package com.example.restapp.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.restapp.R;

public class Login extends AppCompatActivity {

    EditText txtUsr;
    EditText txtPass;
    Button btnSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsr = findViewById(R.id.txtUsr);
        txtPass = findViewById(R.id.txtPass);
        btnSesion = findViewById(R.id.btnSesion);

        btnSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Conectarse a web service y verificar usr y pass
                if(true){
                    despliegaAcitivy();
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario o contraseña equivocados " +
                            "por favor, intente de nuevo",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void despliegaAcitivy(){
      /*  Intent i = new Intent(this, MainActivity.class);
        i.putExtra("Usuario", "Benito");//poner nombre del mesero que inició sesion
        this.startActivity(i);*/
    }
}
