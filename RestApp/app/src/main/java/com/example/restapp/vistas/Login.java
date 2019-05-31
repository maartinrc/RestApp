package com.example.restapp.vistas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.restapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    public static final int MY_DEFAULT_TIMEOUT = 15000;
    EditText txtUsr;
    EditText txtPass;
    Button btnSesion;
    final Context ctx = this;
     RequestQueue requestQueue ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsr = findViewById(R.id.txtUsr);
        txtPass = findViewById(R.id.txtPass);
        btnSesion = findViewById(R.id.btnSesion);
        requestQueue = Volley.newRequestQueue(ctx);


        btnSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            consultaUsuario();
            }
        });

    }
    public boolean consultaUsuario(){



         StringRequest strq;
        String id =getSharedPreferences("login",MODE_PRIVATE).getString("usuario",txtUsr.getText().toString());
            String BASEURL = "http://192.168.1.108:8000/api/usuarios/"+id;

        strq = new StringRequest(Request.Method.GET, BASEURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
                        obtenerDatos(response);
                        getSharedPreferences("login",MODE_PRIVATE).edit().putString("usuario",txtUsr.getText().toString());
                        getSharedPreferences("login",MODE_PRIVATE).edit().putString("contrasena",txtPass.getText().toString());
                        //Conectarse a web service y verificar usr y pass
                        SharedPreferences preferences = getSharedPreferences("login",Context.MODE_PRIVATE);

                            String id =preferences.getString("usuario","nada");
                            String idApi = preferences.getString("usuarioAPI","nada");
                            String contrasena = preferences.getString("contrasena","nada");
                            String contrasenaApi = preferences.getString("contrasenaApi","nada");


                            if(id.equals(idApi) && contrasena.equals(contrasenaApi) ){
                                despliegaAcitivy();
                                Log.d("si son iguales","si son iguales");
                            }else{
                                Toast.makeText(getApplicationContext(),"Usuario o contraseña equivocados 2 " +
                                        "por favor, intente de nuevo",Toast.LENGTH_SHORT).show();
                            }

                        onConnectionFinished();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidorrrrrrrrrr", error.toString());
                onConnectionFailed(error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();


                return parametros;
            }
        };
        strq.setRetryPolicy(new DefaultRetryPolicy(
                MY_DEFAULT_TIMEOUT,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(strq);
        return true;

    }

    public void obtenerDatos(String res){
        final Context ctx = this;
        try{
            JSONObject objetc = new JSONObject(res);
            String success = objetc.get("success").toString();
            String result = objetc.get("result").toString();
            String errors = objetc.get("errors").toString();

            if (success.equals("true")){
                JSONObject json_result = new JSONObject(result);
                SharedPreferences preferences = getSharedPreferences("login",Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("usuarioAPI",json_result.get("usuario").toString());
                editor.putString("contrasenaAPI",json_result.get("contrasena").toString());
                editor.putString("nombreAPI",json_result.get("nombre").toString());
                editor.putString("apellidoAPI",json_result.get("apellido").toString());


                editor.commit();
            }else{
                Toast.makeText(ctx, "Error: " + errors, Toast.LENGTH_SHORT).show();
            }
        }catch (JSONException e){
            e.getMessage();
            Toast.makeText(ctx,"Error" + e, Toast.LENGTH_SHORT).show();
        }
    }
    public void despliegaAcitivy(){
     Intent i = new Intent(this, HomeActivity.class);
       // i.putExtra("Usuario", "Benito");//poner nombre del mesero que inició sesion
        this.startActivity(i);
    }
    public void onPreStartConnection() {
        this.setProgressBarIndeterminateVisibility(true);
    }

    public void onConnectionFinished() {
        this.setProgressBarIndeterminateVisibility(false);
    }

    public void onConnectionFailed(String error) {
        this.setProgressBarIndeterminateVisibility(false);
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
