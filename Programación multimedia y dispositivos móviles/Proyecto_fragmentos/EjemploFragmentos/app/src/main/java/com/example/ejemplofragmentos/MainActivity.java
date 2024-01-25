package com.example.ejemplofragmentos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Inflar el menu de la barra superior
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Gestionar las opciones del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (item.getItemId() == R.id.menu_fragmento1) {
            //lanzar el fragmento1
             ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.contenedorFragmentos, new Fragmento1()).commit();
        } else if (item.getItemId() == R.id.menu_fragmento2) {
            //lanzar el fragmento2
             ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.contenedorFragmentos, new Fragmento2()).commit();

        }

        ft.addToBackStack(null);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack(); // Regresa al fragmento anterior
        } else {
            super.onBackPressed(); // Si no hay más en la pila, sale de la aplicación
        }
    }
}