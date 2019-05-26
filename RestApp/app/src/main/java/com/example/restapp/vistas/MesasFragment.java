package com.example.restapp.vistas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MesasFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MesasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MesasFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    LinearLayout fila1, fila2,fila3,fila4;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MesasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MesasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MesasFragment newInstance(String param1, String param2) {
        MesasFragment fragment = new MesasFragment();
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
        for (int i = 1; i < 5; i++){
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
                    i.putExtra("piso",1);
                    getContext().startActivity(i);
                    v.setEnabled(false);
                }
            });
            //Va agregegando botones al contenedor.
            btnsContainer.addView(buttonContainer);
        }

        fila1.addView(btnsContainer);

        LinearLayout btnsContainer2 = new LinearLayout(context);
        btnsContainer2.setLayoutParams(new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        btnsContainer2.setOrientation(LinearLayout.VERTICAL);
        btnsContainer2.setGravity(Gravity.CENTER);
        //Crea botons dinamicamente.
        for (int i = 5; i < 9; i++){
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
                    i.putExtra("piso",1);
                    getContext().startActivity(i);
                    v.setEnabled(false);
                }
            });
            //Va agregegando botones al contenedor.
            btnsContainer2.addView(buttonContainer);
        }
     //   LinearLayout fila2 = getView().findViewById(R.id.fila2);
        fila2.addView(btnsContainer2);

        LinearLayout btnsContainer3 = new LinearLayout(context);
        btnsContainer3.setLayoutParams(new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        btnsContainer3.setOrientation(LinearLayout.VERTICAL);
        btnsContainer3.setGravity(Gravity.CENTER);
        //Crea botons dinamicamente.
        for (int i = 9; i < 13; i++){
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
                    i.putExtra("piso",1);
                    getContext().startActivity(i);
                    v.setEnabled(false);
                }
            });
            //Va agregegando botones al contenedor.
            btnsContainer3.addView(buttonContainer);
        }
     //   LinearLayout fila3 = getView().findViewById(R.id.fila3);
        fila3.addView(btnsContainer3);


        LinearLayout btnsContainer4 = new LinearLayout(context);
        btnsContainer4.setLayoutParams(new LinearLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        btnsContainer4.setOrientation(LinearLayout.VERTICAL);
        btnsContainer4.setGravity(Gravity.CENTER);
        //Crea botons dinamicamente.
        for (int i = 13; i < 17; i++){
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
                    i.putExtra("piso",1);
                    getContext().startActivity(i);
                    v.setEnabled(false);

                }
            });
            //Va agregegando botones al contenedor.
            btnsContainer4.addView(buttonContainer4);
        }
      //  LinearLayout fila4 = findViewById(R.id.fila4);
        fila4.addView(btnsContainer4);




    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mesas, container, false);
        fila1 = view.findViewById(R.id.fila1);
        fila2 = view.findViewById(R.id.fila2);
        fila3 = view.findViewById(R.id.fila3);
        fila4 = view.findViewById(R.id.fila4);
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
