package com.example.restapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SeccionesFragmentAdaptador extends FragmentPagerAdapter {
    private Context mcontext;

    public  SeccionesFragmentAdaptador(Context context, FragmentManager fm){
        super(fm);
        mcontext = context;
    }

    //Determina el fragmento de cada pestaña
    @Override
    public Fragment getItem(int posicion) {
        if(posicion == 0){
            return new MesasFragment();

        }else {
            return new MesasFragment2();
        }
    }

    //Determina el número de pestañas
    @Override
    public int getCount() {
        return 2;
    }

    //Determina el título de cada pestaña
    @Override
    public CharSequence getPageTitle(int posicion){
        //Generamos el titulo basadonos en la posicion de la pestaña
        switch (posicion){
            case 0:
                return mcontext.getString(R.string.piso1);

            case 1:
                return mcontext.getString(R.string.piso2);

            default:
                return null;
        }
    }
}
