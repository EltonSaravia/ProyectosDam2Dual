package com.example.ejemplofragmentos;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Fragmento1 extends Fragment {
    private EditText editTextNumber;
    private Button buttonCheckPrime;
    private TextView textViewResult;

    public Fragmento1() {
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
        View view = inflater.inflate(R.layout.fragment_fragmento1, container, false);

        editTextNumber = view.findViewById(R.id.editTextNumber);
        buttonCheckPrime = view.findViewById(R.id.buttonCheckPrime);
        textViewResult = view.findViewById(R.id.textViewResult);

        buttonCheckPrime.setOnClickListener(v -> {
            int number = Integer.parseInt(editTextNumber.getText().toString());
            textViewResult.setText(esPrimo(number) ? "Es primo" : "No es primo");
        });

        return view;
    }

    private boolean esPrimo(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}