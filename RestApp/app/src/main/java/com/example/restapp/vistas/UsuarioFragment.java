package com.example.restapp.vistas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.restapp.R;
import com.example.restapp.pojos.Usuario;
import com.example.restapp.sw.ObjectRequest;

import java.util.HashMap;
import java.util.Map;


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

        consume();
    }

    public void consume(){
        String url = "";
        ObjectRequest objectRequest = new ObjectRequest<Usuario>
                //Se movieron de lugar el url y put
                ( Request.Method.GET,url, null, Usuario.class, new Response.Listener<Usuario>() {

                    @Override
                    public void onResponse(Usuario response) {
                        txtId.setText( response.getId());
                        txtNombre.setText(response.getNombre());
                        txtApellido.setText(response.getApellido());
                        txtContrasena.setText(response.getContrasena());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Toast.makeText(getContext(),"Error al recibir datos",Toast.LENGTH_LONG).show();
                    }
                });
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
                    actualiza();
                }
            });
        return v;
    }
    public void actualiza(){
        String url = "/usuario/"+ Integer.parseInt(txtId.getText().toString()) ;
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
