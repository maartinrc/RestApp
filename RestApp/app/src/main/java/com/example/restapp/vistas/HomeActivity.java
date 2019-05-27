package com.example.restapp.vistas;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.restapp.R;

public class HomeActivity extends AppCompatActivity
        implements
        NavigationView.OnNavigationItemSelectedListener,
        DrawerLayout.DrawerListener,
        UsuarioFragment.OnFragmentInteractionListener,
        MesasFragment.OnFragmentInteractionListener,
        SeccionesFragment.OnFragmentInteractionListener,
        MesasFragment2.OnFragmentInteractionListener{

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Verificar conexion a internet
        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork.isConnectedOrConnecting();
        Toast.makeText(this,""+isConnected,Toast.LENGTH_LONG).show();

        navigationView = findViewById(R.id.navigation_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        drawerLayout.addDrawerListener(this);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        menuItem = navigationView.getMenu().getItem(1);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int title;
        switch (menuItem.getItemId()) {
            case R.id.nav_usr:
                title = R.string.menu_usr;
                Fragment fragmentUsr = UsuarioFragment.newInstance(getString(title),"");
                FragmentManager fragmentManagerUsr = getSupportFragmentManager();
                fragmentManagerUsr.beginTransaction().replace(R.id.home_content, fragmentUsr).commit();
                break;
            case R.id.nav_mesa:
                title = R.string.menu_mesas;
               /* Fragment fragmentMesas = MesasFragment.newInstance(getString(title),"");
                FragmentManager fragmentManagerMesas = getSupportFragmentManager();
                fragmentManagerMesas.beginTransaction().replace(R.id.home_content, fragmentMesas).commit();*/

               Fragment fragmentSecciones = SeccionesFragment.newInstance(getString(title),"");
               FragmentManager fragmentManagerSecciones = getSupportFragmentManager();
               fragmentManagerSecciones.beginTransaction().replace(R.id.home_content,fragmentSecciones).commit();
                break;
            case R.id.nav_comanda:
                title = R.string.menu_comandas;
                break;
            case R.id.nav_info:
                title = R.string.menu_info;
                break;
            case R.id.nav_logout:
                title = R.string.menu_logout;
                //borrar shared preferences
                //Intent a Main activity que verificará si hay un shared preferences con id y pass
                ///si no, Intent al login
                break;
            default:
                throw new IllegalArgumentException("menu option not implemented!!");
        }

       /*Fragment fragment = HomeContentFragment.newInstance(getString(title),"");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.home_content, fragment).commit();*/

        setTitle(getString(title));

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onDrawerSlide(@NonNull View view, float v) {
        //cambio en la posición del drawer
    }

    @Override
    public void onDrawerOpened(@NonNull View view) {
        //el drawer se ha abierto completamente

    }

    @Override
    public void onDrawerClosed(@NonNull View view) {
        //el drawer se ha cerrado completamente
    }

    @Override
    public void onDrawerStateChanged(int i) {
        //cambio de estado, puede ser STATE_IDLE, STATE_DRAGGING or STATE_SETTLING
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
