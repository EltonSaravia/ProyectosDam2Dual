package com.example.ejemplofragmentos;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Fragmento2 extends Fragment {
    private EditText editTextText;
    private Button buttonCountLetters;
    private TextView textViewLetterCount;

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

        editTextText = view.findViewById(R.id.editTextText);
        buttonCountLetters = view.findViewById(R.id.buttonCountLetters);
        textViewLetterCount = view.findViewById(R.id.textViewLetterCount);

        buttonCountLetters.setOnClickListener(v -> {
            String text = editTextText.getText().toString();
            textViewLetterCount.setText("Conteo de letras: " + countLetters(text));
        });

        return view;
    }
    private int countLetters(String text) {
        return text.replaceAll("\\s+","").length(); // Removes all whitespace and counts characters
    }
}