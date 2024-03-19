package com.example.pruebalistasve;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Tarea implements Parcelable {
    private String titulo;
    private String descripcion;
    private String fechaLimite;
    private boolean completada;

    public Tarea(String titulo, String descripcion, String fechaLimite, boolean completada) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completada = completada;
    }

    protected Tarea(Parcel in) {
        titulo = in.readString();
        descripcion = in.readString();
        fechaLimite = in.readString();
        completada = in.readByte() != 0;
    }

    public static final Creator<Tarea> CREATOR = new Creator<Tarea>() {
        @Override
        public Tarea createFromParcel(Parcel in) {
            return new Tarea(in);
        }

        @Override
        public Tarea[] newArray(int size) {
            return new Tarea[size];
        }
    };

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeString(descripcion);
        dest.writeString(fechaLimite);
        dest.writeByte((byte) (completada ? 1 : 0));
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaLimite='" + fechaLimite + '\'' +
                ", completada=" + completada +
                '}';
    }

    // Método para crear una lista de tareas de ejemplo
    public static ArrayList<Tarea> obtenerTareasEjemplo() {
        ArrayList<Tarea> lista = new ArrayList<>();
        // Añade aquí tareas de ejemplo
        lista.add(new Tarea("Tarea 1", "Descripción 1", "2024-01-01", false));
        lista.add(new Tarea("Tarea 2", "Descripción 2", "2024-02-01", true));
        // ... y así sucesivamente
        return lista;
    }
}
