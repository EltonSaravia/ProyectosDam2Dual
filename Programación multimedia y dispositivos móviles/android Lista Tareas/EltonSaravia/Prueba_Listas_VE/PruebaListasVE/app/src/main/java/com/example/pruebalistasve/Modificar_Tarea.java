package com.example.pruebalistasve;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Modificar_Tarea extends Fragment {

    private EditText cambiarTitulo;
    private EditText cambiarDescripcion;
    private EditText editFechaLimite; // Convertimos el TextView a EditText para la fecha
    private CheckBox marcarCompletada;
    private Button btnCancelar;
    private Button btnEditar;

    private OnTareaModifiedListener onTareaModifiedListener;

    public void setOnTareaModifiedListener(OnTareaModifiedListener onTareaModifiedListener) {
        this.onTareaModifiedListener = onTareaModifiedListener;
    }

    public static Modificar_Tarea newInstance() {
        return new Modificar_Tarea();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.modificar_tarea, container, false);
        Tarea tarea = requireArguments().getParcelable("tarea");
        int position = requireArguments().getInt("position");

        cambiarTitulo = view.findViewById(R.id.cambiarTitulo);
        cambiarDescripcion = view.findViewById(R.id.cambiarDescripcion);
        editFechaLimite = view.findViewById(R.id.editFechaLimite); // Nuevo EditText para la fecha
        marcarCompletada = view.findViewById(R.id.editCompletadaCheckBox);
        btnCancelar = view.findViewById(R.id.btnCancelEdit);
        btnEditar = view.findViewById(R.id.btnOkEdit);

        cambiarTitulo.setText(tarea.getTitulo());
        cambiarDescripcion.setText(tarea.getDescripcion());
        editFechaLimite.setText(tarea.getFechaLimite());
        marcarCompletada.setChecked(tarea.isCompletada());

        btnEditar.setOnClickListener(v -> {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String fecha = editFechaLimite.getText().toString();
            try {
                format.setLenient(false);
                format.parse(fecha); // Si la fecha es correcta, no hagas nada. La variable date contiene la fecha correcta.
            } catch (ParseException e) {
                // Si la fecha no es correcta, manten la fecha original y avisa al usuario.
                fecha = tarea.getFechaLimite();
                Toast.makeText(getActivity(), "Formato de fecha no válido, se ha mantenido la fecha original.", Toast.LENGTH_LONG).show();
            }

            if (onTareaModifiedListener != null) {
                // Actualiza la tarea con los nuevos valores
                tarea.setTitulo(cambiarTitulo.getText().toString());
                tarea.setDescripcion(cambiarDescripcion.getText().toString());
                tarea.setFechaLimite(fecha);
                tarea.setCompletada(marcarCompletada.isChecked());

                // Notifica al listener con la tarea modificada y su posición
                onTareaModifiedListener.onTareaModified(position, tarea);

                // Vuelve al fragmento anterior
                getParentFragmentManager().popBackStack();
            }
        });

        btnCancelar.setOnClickListener(v -> getParentFragmentManager().popBackStack());

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnTareaModifiedListener) {
            onTareaModifiedListener = (OnTareaModifiedListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnTareaModifiedListener");
        }
    }

    public interface OnTareaModifiedListener {
        void onTareaModified(int position, Tarea t);
    }
}
