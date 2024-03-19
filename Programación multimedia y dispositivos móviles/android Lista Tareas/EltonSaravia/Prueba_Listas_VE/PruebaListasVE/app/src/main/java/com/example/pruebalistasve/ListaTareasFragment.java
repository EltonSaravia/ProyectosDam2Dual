package com.example.pruebalistasve;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListaTareasFragment extends Fragment implements AdaptadorParaTarea.OnItemClickListener, nuevaTarea.OnTareaAddedListener,
        Detalles_tareas.OnTareaDeletedListener, Modificar_Tarea.OnTareaModifiedListener {

    private RecyclerView recyclerView;
    private AdaptadorParaTarea adapter;
    private ArrayList<Tarea> listaTareas;


    public ListaTareasFragment(AdaptadorParaTarea adapter, ArrayList<Tarea> listaTareas) {
        this.adapter = adapter;
        this.listaTareas = listaTareas;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_tareas, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewTareas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.setOnItemClickListener(this); // Set the item click listener
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(int position, Tarea tarea) {
        Detalles_tareas detallesTareas = new Detalles_tareas();

        // Pass the clicked Tarea to the DetallesTareaFragment
        Bundle bundle = new Bundle();
        bundle.putParcelable("tarea", tarea);
        bundle.putInt("position",position);
        detallesTareas.setArguments(bundle);

        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, detallesTareas)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void onTareaAdded(Tarea t) {
        listaTareas.add(t);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onTareaDeleted(int position, Tarea t) {
        Log.d("TareaDeleted", "Position: " + position + ", Tarea: " + t.toString()+" size: "+listaTareas.size());
        listaTareas.remove(t);
        adapter.notifyItemRemoved(position);
        adapter.notifyItemRangeChanged(position, listaTareas.size());
        Log.d("TareaDeleted", "After Deletion: " + listaTareas.size());
    }

    @Override
    public void onTareaModified(int position, Tarea t) {
        Log.d("TareaModified", "Position: " + position + ", Tarea: " + t.toString());
        listaTareas.set(position, t);
        adapter.notifyItemChanged(position);
        Log.d("TareaModified", "After Modification: " + t.toString());
    }
}