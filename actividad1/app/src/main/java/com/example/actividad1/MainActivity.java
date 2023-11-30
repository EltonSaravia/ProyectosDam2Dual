package com.example.actividad1;

import static android.graphics.Color.toArgb;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
public class MainActivity extends AppCompatActivity {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         buttonR = (Button) findViewById(R.id.buttonR);
         buttonG = (Button) findViewById(R.id.buttonG);
         buttonB = (Button) findViewById(R.id.buttonB);
         colorFondo = (TextView) findViewById(R.id.color);
         numeroR = (TextView) findViewById(R.id.numeroR);
         numeroG = (TextView) findViewById(R.id.numeroG);
         numeroB = (TextView) findViewById(R.id.numeroB);

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




    }


}
