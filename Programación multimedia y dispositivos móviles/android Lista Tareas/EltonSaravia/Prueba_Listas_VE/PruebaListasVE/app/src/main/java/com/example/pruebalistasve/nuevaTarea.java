package com.example.pruebalistasve;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class nuevaTarea extends Fragment {

    private EditText editFechaLimite;
    Button btnCancel;
    Button btnOk;

    private OnTareaAddedListener onTareaAddedListener;

    public void setOnTareaAddedListener(OnTareaAddedListener listener) {
        this.onTareaAddedListener = listener;
    }

    public nuevaTarea() {
        // Required empty public constructor
    }

    public static nuevaTarea newInstance() {
        return new nuevaTarea();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nueva_tarea, container, false);
        EditText editTitulo = view.findViewById(R.id.cambiarTitulo);
        EditText editDesc = view.findViewById(R.id.cambiarDescripcion);
        editFechaLimite = view.findViewById(R.id.editFechaLimite); // Asumiendo que tienes un EditText con este id para la fecha
        btnOk = view.findViewById(R.id.btnOkEdit);
        btnCancel = view.findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(v -> {
            String fecha = editFechaLimite.getText().toString();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            try {
                format.setLenient(false);
                Date date = format.parse(fecha);
                // Si la fecha es correcta, no hagas nada. La variable date contiene la fecha correcta.
            } catch (ParseException e) {
                // Si la fecha no es correcta, pon la de mañana y avisa al usuario.
                Calendar c = Calendar.getInstance();
                c.add(Calendar.DAY_OF_YEAR, 1);
                fecha = format.format(c.getTime());
                editFechaLimite.setText(fecha);
                Toast.makeText(getActivity(), "Formato de fecha no válido, se ha establecido para mañana.", Toast.LENGTH_LONG).show();
            }

            // Procede con la creación de la Tarea
            if (onTareaAddedListener != null) {
                Tarea newTarea = new Tarea(editTitulo.getText().toString(), editDesc.getText().toString(), fecha, false);
                onTareaAddedListener.onTareaAdded(newTarea);
            }

            // Pop the fragment from the back stack
            getParentFragmentManager().popBackStack();
        });

        btnCancel.setOnClickListener(v -> {
            // Pop the fragment from the back stack
            getParentFragmentManager().popBackStack();
        });

        return view;
    }

    public interface OnTareaAddedListener {
        void onTareaAdded(Tarea tarea);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnTareaAddedListener) {
            onTareaAddedListener = (OnTareaAddedListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnTareaAddedListener");
        }
    }

}
