package com.example.pruebalistasve;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Main extends AppCompatActivity implements AdaptadorParaTarea.OnItemClickListener, Detalles_tareas.OnTareaDeletedListener,
        Modificar_Tarea.OnTareaModifiedListener, nuevaTarea.OnTareaAddedListener {

    ListaTareasFragment listaTareasFragment;
    nuevaTarea nuevaTarea;
    ArrayList<Tarea> listaTareas;
    AdaptadorParaTarea adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Utiliza el método obtenerTareasEjemplo para obtener una lista de tareas
        listaTareas = Tarea.obtenerTareasEjemplo();
        adapter = new AdaptadorParaTarea(listaTareas);
        listaTareasFragment = new ListaTareasFragment(adapter, listaTareas);
        nuevaTarea = new nuevaTarea();

        if (savedInstanceState == null) {
            loadFragment(listaTareasFragment);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragmentContainer, new nuevaTarea());
            ft.addToBackStack(null);
            ft.commit();
        });
    }

    private void loadFragment(ListaTareasFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    public void onItemClick(int position, Tarea tarea) {
        // Handle item click, open DetallesTareaFragment with the clicked Tarea
        Detalles_tareas detallesTareas = new Detalles_tareas();

        // Pass the clicked Tarea to the DetallesTareaFragment
        Bundle bundle = new Bundle();
        bundle.putParcelable("tarea", (Parcelable) tarea);
        bundle.putInt("position", position);
        detallesTareas.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, detallesTareas)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Handles menu item selection
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Check which menu item is selected
        if (item.getItemId() == R.id.menu_lista_tareas) {
            // Replace the current fragment with ColorsFragment and add it to the back stack
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragmentContainer, listaTareasFragment).addToBackStack(null).commit();
        } else if (item.getItemId() == R.id.menu_aniadir_tarea) {
            // Replace the current fragment with PrimeNumberFragment and add it to the back stack
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragmentContainer, new nuevaTarea()).addToBackStack(null).commit();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTareaDeleted(int position,Tarea t) {
        listaTareasFragment.onTareaDeleted(position, t);
    }

    @Override
    public void onTareaModified(int position, Tarea t) {
        listaTareasFragment.onTareaModified(position, t);
    }

    @Override
    public void onTareaAdded(Tarea tarea) {
        listaTareasFragment.onTareaAdded(tarea);
    }
}