package com.example.ejemploficheros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tv;
    Button btnLeer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tvTextoFichero);
        btnLeer = findViewById(R.id.btnLeer);
        btnLeer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        tv.append("\nLeyendo datos de res/raw/textos.txt:");
        tv.append("\n");

        //Declaramos el Stream de entrada (el fichero que queremos leer)
        InputStream input=  getResources().openRawResource(R.raw.textos);

        //Declaramos  el Reader para el Stream
        InputStreamReader stream=   new InputStreamReader(input);

        //Buffer para el Reader, leeremos el fichero por lineas
        BufferedReader buffer =  new BufferedReader(stream);

        //comenzamos a leer el fichero:
        try{
            boolean continuar = true;
            String linea;
            //Mientras haya lineas de texto en el fichero las añado al cuadro de texto
            while(continuar){
                linea=buffer.readLine();
                if(linea!=null) {
                    tv.append("\n" + linea);
                }else {
                    continuar=false;
                }
            }
            input.close();
            stream.close();
            buffer.close();
        }catch(Exception e){
            //Si ocurre un error, lo muestro en lugar del texto
            tv.append("\n "+e);
        }
        tv.append("\nHemos llegado al final del fichero\n");
    }
}