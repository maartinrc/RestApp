package com.example.restapp;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ConsumidorWeb {

    private RequestQueue requestQueue;
    private final String BASEURL;
    private Context ctx;
    private StringRequest strq;

    public ConsumidorWeb(String indicador, Context ctx){
        this.BASEURL = "http://192.168.137.235:8000/api/" + indicador+"/";
        this.ctx = ctx;
        requestQueue = Volley.newRequestQueue(this.ctx);
    }



    public void crear() {

        strq = new StringRequest(Request.Method.POST, BASEURL+"insertar",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
                    }
                },  new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

              //  parametros.put("nombre", et_dato.getText().toString());

                return parametros;
            }
        };

        requestQueue.add(strq);

    }

    public void actualizar(String id) {

        strq = new StringRequest(Request.Method.POST, BASEURL+"actualizar/"+id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

               // parametros.put("nombre", et_dato.getText().toString());

                return parametros;
            }
        };

        requestQueue.add(strq);

    }

    public void eliminar(String id) {

        strq = new StringRequest(Request.Method.DELETE, BASEURL+"eliminar/"+id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

             //   parametros.put("nombre", et_dato.getText().toString());
                return parametros;
            }
        };

        requestQueue.add(strq);
    }

    public void show(String id) {//mostrar por id

        strq = new StringRequest(Request.Method.GET, BASEURL+id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

              //  parametros.put("nombre", et_dato.getText().toString());
                return parametros;
            }
        };

        requestQueue.add(strq);
    }
    public void showAll() {//mostrar todos

        strq = new StringRequest(Request.Method.GET, BASEURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(ctx, response, Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidor", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams()  {
                Map<String, String> parametros = new HashMap<>();

                //  parametros.put("nombre", et_dato.getText().toString());
                return parametros;
            }
        };

        requestQueue.add(strq);
    }


    public void responseHandler(String res){
        try {
            JSONArray response = new JSONArray(res);
            //Toast.makeText(this, res, Toast.LENGTH_LONG).show();
            for(int i = 0, e = response.length(); i < e; i++){
                JSONObject categoria = (JSONObject) response.get(i);

                String nombre = categoria.get("nombre").toString();

              /*  Categoria cat = new Categoria(
                        Integer.parseInt(categoria.get("id").toString()),
                        (String) categoria.get("nombre")
                );*/


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
