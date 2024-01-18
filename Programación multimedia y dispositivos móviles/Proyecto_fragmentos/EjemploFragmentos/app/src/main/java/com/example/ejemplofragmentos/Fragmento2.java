package com.example.ejemplofragmentos;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Fragmento2 extends Fragment {
    Button buttonR;
    Button buttonG ;
    Button buttonB ;
    TextView colorFondo ;
    TextView numeroR ;
    TextView numeroG ;
    TextView numeroB ;
    int numerAsignadoR = 0;
    int numerAsignadoG = 0 ;
    int numerAsignadoB = 0 ;

    public Fragmento2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento2, container, false);

        buttonR = view.findViewById(R.id.buttonR);
        buttonG = view.findViewById(R.id.buttonG);
        buttonB = view.findViewById(R.id.buttonB);
        colorFondo = view.findViewById(R.id.color);
        numeroR = view.findViewById(R.id.numeroR);
        numeroG = view.findViewById(R.id.numeroG);
        numeroB = view.findViewById(R.id.numeroB);

        buttonR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numerAsignadoR  = (int) (Math.random() * 255);
                numeroR.setText(String.valueOf(numerAsignadoR));
                colorFondo.setBackgroundColor(Color.argb(255,numerAsignadoR,numerAsignadoG, numerAsignadoB ));

            }
        });

        buttonG.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numerAsignadoG  = (int) (Math.random() * 255);
                numeroG.setText(String.valueOf(numerAsignadoG));
                colorFondo.setBackgroundColor(Color.argb(255,numerAsignadoR,numerAsignadoG, numerAsignadoB ));

            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                numerAsignadoB  = (int) (Math.random() * 255);
                numeroB.setText(String.valueOf(numerAsignadoB));
                colorFondo.setBackgroundColor(Color.argb(255,numerAsignadoR,numerAsignadoG, numerAsignadoB ));

            }
        });

        return view;
    }
    private int countLetters(String text) {
        return text.replaceAll("\\s+","").length(); // Removes all whitespace and counts characters
    }
}