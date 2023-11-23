package com.example.lista_de_personas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  Persona p1 = new Persona(1,"Persona1","nose","nose");
    private  Persona p2 = new Persona(1,"Persona1","nose","nose");
    private  Persona p3 = new Persona(1, "Persona1", "nose", "nose");
    private  Persona p4 = new Persona(1,"Persona1","nose","nose");

    private List<Persona> listaPersonas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creamos una lista donde meteremos los objetos

        listaPersonas.add(p1);
        listaPersonas.add(p2);
        listaPersonas.add(p3);
        listaPersonas.add(p4);

        ListView listaPersonas12 = (ListView) findViewById(R.id.lvListaPersonas);
        ArrayAdapter<Persona> aaPersona = new AdapterPersona( this,
                listaPersonas);
        listaPersonas12.setAdapter(aaPersona);

    }


}