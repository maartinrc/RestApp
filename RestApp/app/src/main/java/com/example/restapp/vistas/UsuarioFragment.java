package com.example.restapp.vistas;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.restapp.R;
import com.example.restapp.pojos.Usuario;
import com.example.restapp.sw.ObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;
import static com.example.restapp.vistas.Login.MY_DEFAULT_TIMEOUT;


public class UsuarioFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText txtNombre;
    EditText txtApellido;
    EditText txtContrasena;
    EditText txtId;
    Button btnGuardar;
    RequestQueue requestQueue ;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public UsuarioFragment() {
        // Required empty public constructor

    }


    // TODO: Rename and change types and number of parameters
    public static UsuarioFragment newInstance(String param1, String param2) {
        UsuarioFragment fragment = new UsuarioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    public void sustituirDatos(){
        SharedPreferences preferences = getContext().getSharedPreferences("login",MODE_PRIVATE);


        txtId.setText(preferences.getString("usuarioAPI","Id"));
        txtContrasena.setText(preferences.getString("contrasenaAPI","Contraseña"));
        txtNombre.setText(preferences.getString("nombreAPI","Nombre(s)"));
        txtApellido.setText(preferences.getString("apellidoAPI","Apellido(s)"));
    }
    public boolean consume(){
            requestQueue = Volley.newRequestQueue(getContext());

        StringRequest strq;
        String id =getContext().getSharedPreferences("login",MODE_PRIVATE).getString("usuario","");
        String BASEURL = "http://192.168.1.108:8000/api/usuarios/"+id;

        strq = new StringRequest(Request.Method.GET, BASEURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("rta_servidor", response);
                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                        obtenerDatos(response);
                        //Conectarse a web service y verificar usr y pass
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error_servidorrrrrrrrrr", error.toString());

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
        final Context ctx = getContext();
        try{
            JSONObject objetc = new JSONObject(res);
            String success = objetc.get("success").toString();
            String result = objetc.get("result").toString();
            String errors = objetc.get("errors").toString();

            if (success.equals("true")){
                JSONObject json_result = new JSONObject(result);
                txtId.setText(json_result.getString("id"));
                txtNombre.setText(json_result.getString("nombre"));
                txtApellido.setText(json_result.getString("apellido"));
                txtContrasena.setText(json_result.getString("contrasena"));

            }else{
                Toast.makeText(ctx, "Error: " + errors, Toast.LENGTH_SHORT).show();
            }
        }catch (JSONException e){
            e.getMessage();
            Toast.makeText(ctx,"Error" + e, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_usuario, container, false);
            txtNombre = v.findViewById(R.id.txtNombre);
            txtApellido = v.findViewById(R.id.txtApellidos);
            txtContrasena = v.findViewById(R.id.txtContrasenia);
            txtId = v.findViewById(R.id.txtId);
            btnGuardar = v.findViewById(R.id.btn_guardar_c_usuario);
            btnGuardar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sustituirDatos();

                 //   actualiza();
                }
            });


        return v;
    }
    public void actualiza(){
     //   String url = "/usuario/"+ Integer.parseInt(txtId.getText().toString()) ;
        String url = "http//10.55.108.44:8000/api/usuarios/1" ;
        Map<String,Object> parametros = new HashMap<>();

        //Preguntar si hay que adaptar los String a como están escritos en la bd
        parametros.put("id", Integer.parseInt(txtId.getText().toString()));
        parametros.put("nombre",txtNombre.getText().toString());
        parametros.put("apellido",txtApellido.getText().toString());
        parametros.put("contrasena",txtContrasena.getText().toString());


        ObjectRequest objectRequest = new ObjectRequest<Usuario>
                //Se movieron de lugar el url y put
                ( Request.Method.PUT,url, parametros, Usuario.class, new Response.Listener<Usuario>() {

                    @Override
                    public void onResponse(Usuario response) {
                        Log.d("Response",response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Toast.makeText(getContext(),"No se pudo actualizar",Toast.LENGTH_LONG);

                    }
                });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
