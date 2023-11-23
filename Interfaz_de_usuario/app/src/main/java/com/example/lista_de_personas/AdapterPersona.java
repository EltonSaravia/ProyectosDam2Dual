package com.example.lista_de_personas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterPersona extends ArrayAdapter<Persona> {


    public AdapterPersona(@NonNull Context context, @NonNull List objects) {
        super(context, 0, objects);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context. LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            convertView = inflater.inflate( R.layout. fila_persona, parent, false);
        }

        TextView nombre = (TextView) convertView.findViewById(R.id. tvNombre);
        TextView cargo = (TextView) convertView.findViewById(R.id. tvCargo);
        TextView empresa = (TextView) convertView.findViewById(R.id. tvEmpresa);
        Persona persona = getItem(position);
        nombre.setText(persona.getNombre());
        cargo.setText(persona.getCargo());
        empresa.setText(persona.getEmpresa());

        return convertView;
    }
}
