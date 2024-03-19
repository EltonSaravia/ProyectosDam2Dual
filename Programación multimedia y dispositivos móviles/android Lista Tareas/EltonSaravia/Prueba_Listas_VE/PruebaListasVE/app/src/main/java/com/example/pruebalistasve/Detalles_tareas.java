package com.example.pruebalistasve;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;


import android.view.*;

import android.widget.*;


public class Detalles_tareas extends Fragment {

    Button btnEliminarTarea, btnModificarTarea;

    public interface OnTareaDeletedListener {
        void onTareaDeleted(int position, Tarea t);
    }

    private OnTareaDeletedListener onTareaChangedListener;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnTareaDeletedListener) {
            onTareaChangedListener = (OnTareaDeletedListener) context;

        } else {
            throw new ClassCastException(context.toString() + " error no se ha implementado el OnTareaDeletedListener");
        }

    }


    public Detalles_tareas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detalles_tarea, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tituloTextView = view.findViewById(R.id.tituloTextView);
        TextView descripcionTextView = view.findViewById(R.id.descripcionTextView);
        TextView fechaLimiteTextView = view.findViewById(R.id.fechaLimiteTextView);
        CheckBox completadaCheckBox = view.findViewById(R.id.completadaCheckBox);
        btnEliminarTarea = view.findViewById(R.id.btnEliminarTarea);
        btnModificarTarea = view.findViewById(R.id.btnModificarTarea);
        Tarea tarea = requireArguments().getParcelable("tarea");
        int position = requireArguments().getInt("position");
        btnEliminarTarea.setOnClickListener(v -> {
            // Call a method to handle the deletion of the current Tarea
            if (onTareaChangedListener != null) {
                onTareaChangedListener.onTareaDeleted(position,tarea);
            }
            // Pop the fragment from the back stack
            getParentFragmentManager().popBackStack();
        });
        // Retrieve the Tarea object from the arguments
        btnModificarTarea.setOnClickListener(v -> {
            Modificar_Tarea modificarTarea = new Modificar_Tarea();

            // Pass the clicked Tarea to the DetallesTareaFragment
            Bundle bundle = new Bundle();
            bundle.putParcelable("tarea", tarea);
            bundle.putInt("position", position);
            modificarTarea.setArguments(bundle);

            /*
            esto es lo de volver hacia atras y que al final salga de la app
             */
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, modificarTarea)
                    .addToBackStack(null)
                    .commit();

        });

        if (tarea != null) {
            tituloTextView.setText(tarea.getTitulo());
            descripcionTextView.setText(tarea.getDescripcion());
            fechaLimiteTextView.setText(tarea.getFechaLimite());
            completadaCheckBox.setChecked(tarea.isCompletada());
        }
    }
}