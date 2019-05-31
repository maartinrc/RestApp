package com.example.restapp.vistas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.restapp.interfaces.RecyclerInterface;
import com.example.restapp.pojos.Bebida;
import com.example.restapp.pojos.Platillo;
import com.example.restapp.pojos.Postre;
import com.example.restapp.pojos.Producto;
import com.example.restapp.pojos.Usuario;
import com.example.restapp.sw.ObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Retrofit;
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

        platillo = new ArrayList<>();
        bebidas = new ArrayList<>();
        postres = new ArrayList<>();

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
        fetchJSON();



        /*TODO cambiar a las clases Bebida, Platillo, Postre y Producto el fotoID por fotoRuta tipo
        * String*/
    }
//Este método crea u arma la solicitud HTTP y procesa la respuesta en el método onResponse
    private void fetchJSON(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RecyclerInterface.JSONURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        RecyclerInterface api = retrofit.create(RecyclerInterface.class);

        Call<String> call = api.getString();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                Log.i("Responsestring", response.body());
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body());

                        String jsonresponse = response.body();
                        writeRecycler(jsonresponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");
                        //Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            Log.d("Error retrofiiiit",t.getMessage());
                Toast.makeText(MenuActivity.this,"Errrooooooor",Toast.LENGTH_LONG);
            }
        });
    }
    private void writeRecycler(String response){

        try {
            //getting the whole json object from the response


                JSONArray dataArray  = new JSONArray(response);
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataobj = dataArray.getJSONObject(i);
                    Log.d("xxxxx",dataobj.getString("nombre"));
                    if(dataobj.getInt("status") == 1){//si el producto está activo
                        if(dataobj.getInt("tipo") == 0){//platillo
                           /* String imagen = dataobj.getString("imagen").replace('\\','/');
                            String[] partes = dataobj.getString(imagen).split("//");
                            String imgf= "http://192.168.1.108:8000/sistema_restaurant/public/productos/"+partes[0]+"/"+partes[1];*/
                            Platillo p = new Platillo(dataobj.getString("nombre"),
                                                      dataobj.getString("descripcion"),
                                                         dataobj.getString("imagen"),
                                                      String.valueOf(dataobj.getInt("precio")));
                            platillo.add(p);
                        }else if(dataobj.getInt("tipo") == 1){//bebida
                            Bebida b = new Bebida(dataobj.getString("nombre"),
                                    dataobj.getString("descripcion"),
                                    dataobj.getString("imagen"),
                                    String.valueOf(dataobj.getInt("precio")));
                            bebidas.add(b);
                        }else if(dataobj.getInt("tipo") == 2){//postre
                            Postre po = new Postre(dataobj.getString("nombre"),
                                    dataobj.getString("descripcion"),
                                    dataobj.getString("imagen"),
                                    String.valueOf(dataobj.getInt("precio")));
                            postres.add(po);
                        }
                    }
                }
                    inicilizarAdaptador();


        } catch (JSONException e) {
            e.printStackTrace();

        }

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
/*
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
*/

}
