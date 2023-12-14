package com.example.ejemploficheros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    TextView tv, textoEscrito;
    Button btnLeer, buttonEscribir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tvTextoFichero);
        textoEscrito = findViewById(R.id.textoEscrito);

        btnLeer = findViewById(R.id.btnLeer);
        btnLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leerFichero(view);
            }
        });

        buttonEscribir = findViewById(R.id.buttonEscribir);
        buttonEscribir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escribirFichero(view);
            }
        });
    }

    public void escribirFichero(View view) {
        // Fichero donde voy a escribir
        File f = new File(getApplicationContext().getFilesDir(), "pruebaEscritura.txt");
        // Stream de salida a fichero
        FileOutputStream fos;
        // PrintWriter para escribir al stream
        PrintWriter pw;

        try {
            fos = new FileOutputStream(f, true);
            pw = new PrintWriter(fos);

            pw.println("Una línea de texto");
            textoEscrito.append("\nSe ha escrito una línea");

            pw.flush();
            pw.close();
            fos.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void leerFichero(View view) {
        tv.append("\nLeyendo datos de archivos internos:");

        try {
            File archivoInterno = new File(getApplicationContext().getFilesDir(), "pruebaEscritura.txt");
            BufferedReader buffer = new BufferedReader(new InputStreamReader(openFileInput("pruebaEscritura.txt")));

            String linea;
            while ((linea = buffer.readLine()) != null) {
                tv.append("\n" + linea);
            }

            buffer.close();
        } catch (Exception e) {
            tv.append("\n " + e);
        }

        tv.append("\nHemos llegado al final del fichero\n");
    }
}


