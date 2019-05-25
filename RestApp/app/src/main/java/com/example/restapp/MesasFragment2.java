package com.example.restapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MesasFragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MesasFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MesasFragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    LinearLayout fila5, fila6,fila7,fila8;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MesasFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MesasFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static MesasFragment2 newInstance(String param1, String param2) {
        MesasFragment2 fragment = new MesasFragment2();
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
    public void agregarBotones(){
        final Context context = getContext();



        LinearLayout btnsContainer = new LinearLayout(context);
        btnsContainer.setLayoutParams(new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        btnsContainer.setOrientation(LinearLayout.VERTICAL);
        btnsContainer.setGravity(Gravity.CENTER);
        //Crea botons dinamicamente.
        for (int i = 17; i < 21; i++){
            final LinearLayout buttonContainer = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.btn_mesa,null);
            final ImageView btnImg = (ImageView) buttonContainer.findViewById(R.id.btn_image);
            TextView btnTxt = (TextView) buttonContainer.findViewById(R.id.btn_text);
            btnTxt.setText("mesa " +  i);
            buttonContainer.setTag(i);

            buttonContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, " Listener botón " + v.getTag(), Toast.LENGTH_SHORT).show();
                    btnImg.setImageResource(R.drawable.ic_mesadis);
                    Intent i = new Intent(getContext(),MenuActivity.class);
                    i.putExtra("mesa",Integer.parseInt(v.getTag().toString()));
                    i.putExtra("piso",2);
                    getContext().startActivity(i);
                    v.setEnabled(false);
                }
            });
            //Va agregegando botones al contenedor.
            btnsContainer.addView(buttonContainer);
        }

        fila5.addView(btnsContainer);

        LinearLayout btnsContainer2 = new LinearLayout(context);
        btnsContainer2.setLayoutParams(new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        btnsContainer2.setOrientation(LinearLayout.VERTICAL);
        btnsContainer2.setGravity(Gravity.CENTER);
        //Crea botons dinamicamente.
        for (int i = 21; i < 25; i++){
            final LinearLayout buttonContainer = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.btn_mesa,null);
            final ImageView btnImg = (ImageView) buttonContainer.findViewById(R.id.btn_image);
            TextView btnTxt = (TextView) buttonContainer.findViewById(R.id.btn_text);
            btnTxt.setText("mesa " +  i);
            buttonContainer.setTag(i);

            buttonContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, " Listener botón " + v.getTag(), Toast.LENGTH_SHORT).show();
                    btnImg.setImageResource(R.drawable.ic_mesadis);
                    Intent i = new Intent(getContext(),MenuActivity.class);
                    i.putExtra("mesa",Integer.parseInt(v.getTag().toString()));
                    i.putExtra("piso",2);
                    getContext().startActivity(i);
                    v.setEnabled(false);
                }
            });
            //Va agregegando botones al contenedor.
            btnsContainer2.addView(buttonContainer);
        }
        //   LinearLayout fila2 = getView().findViewById(R.id.fila2);
        fila6.addView(btnsContainer2);

        LinearLayout btnsContainer3 = new LinearLayout(context);
        btnsContainer3.setLayoutParams(new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        btnsContainer3.setOrientation(LinearLayout.VERTICAL);
        btnsContainer3.setGravity(Gravity.CENTER);
        //Crea botons dinamicamente.
        for (int i = 25; i < 29; i++){
            final LinearLayout buttonContainer = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.btn_mesa,null);
            final ImageView btnImg = (ImageView) buttonContainer.findViewById(R.id.btn_image);
            TextView btnTxt = (TextView) buttonContainer.findViewById(R.id.btn_text);
            btnTxt.setText("mesa " +  i);
            buttonContainer.setTag(i);

            buttonContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, " Listener botón " + v.getTag(), Toast.LENGTH_SHORT).show();
                    btnImg.setImageResource(R.drawable.ic_mesadis);
                    Intent i = new Intent(getContext(),MenuActivity.class);
                    i.putExtra("mesa",Integer.parseInt(v.getTag().toString()));
                    i.putExtra("piso",2);
                    getContext().startActivity(i);
                    v.setEnabled(false);
                }
            });
            //Va agregegando botones al contenedor.
            btnsContainer3.addView(buttonContainer);
        }
        //   LinearLayout fila3 = getView().findViewById(R.id.fila3);
        fila7.addView(btnsContainer3);


        LinearLayout btnsContainer4 = new LinearLayout(context);
        btnsContainer4.setLayoutParams(new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        btnsContainer4.setOrientation(LinearLayout.VERTICAL);
        btnsContainer4.setGravity(Gravity.CENTER);
        //Crea botons dinamicamente.
        for (int i = 29; i < 33; i++){
            final LinearLayout buttonContainer4 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.btn_mesa,null);
            final ImageView btnImg = (ImageView) buttonContainer4.findViewById(R.id.btn_image);
            TextView btnTxt = (TextView) buttonContainer4.findViewById(R.id.btn_text);
            btnTxt.setText("mesa " +  i);
            buttonContainer4.setTag(i);

            buttonContainer4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, " Listener botón " + v.getTag(), Toast.LENGTH_SHORT).show();
                    btnImg.setImageResource(R.drawable.ic_mesadis);
                    Intent i = new Intent(getContext(),MenuActivity.class);
                    i.putExtra("mesa",Integer.parseInt(v.getTag().toString()));
                    i.putExtra("piso",2);
                    getContext().startActivity(i);
                    v.setEnabled(false);

                }
            });
            //Va agregegando botones al contenedor.
            btnsContainer4.addView(buttonContainer4);
        }
        //  LinearLayout fila4 = findViewById(R.id.fila4);
        fila8.addView(btnsContainer4);




    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mesas2, container, false);
        fila5 = view.findViewById(R.id.fila5);
        fila6 = view.findViewById(R.id.fila6);
        fila7 = view.findViewById(R.id.fila7);
        fila8 = view.findViewById(R.id.fila8);
        agregarBotones();
        return view;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
