package com.example.pruebalistasve;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorParaTarea extends RecyclerView.Adapter<AdaptadorParaTarea.ViewHolder> {

    private final ArrayList<Tarea> tareas;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position, Tarea tarea);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
    public AdaptadorParaTarea(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorParaTarea.ViewHolder holder, int position) {
        Tarea tarea = tareas.get(position);
        String status = "pendiente";
        if (tarea.isCompletada()) {
            status = "completada";
        }
        // Bind data to the ViewHolder
        holder.textTitulo.setText(tarea.getTitulo());
        holder.textDescripcion.setText(tarea.getDescripcion());
        holder.fechaLimite.setText(tarea.getFechaLimite());
        holder.completada.setText(status);

        holder.itemView.setOnClickListener(view -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position, tarea);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tareas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textTitulo, textDescripcion, fechaLimite, completada;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitulo = itemView.findViewById(R.id.tituloTextView);
            textDescripcion = itemView.findViewById(R.id.descripcionTextView);
            fechaLimite = itemView.findViewById(R.id.fechaLimiteTextView);
            completada = itemView.findViewById(R.id.completadaTextView);

        }
    }
}
