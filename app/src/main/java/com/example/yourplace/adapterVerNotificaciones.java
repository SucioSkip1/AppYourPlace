package com.example.yourplace;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapterVerNotificaciones extends RecyclerView.Adapter <adapterVerNotificaciones.ViewHolder> {


    private List<String> items;
    private List<String> items2;
    private List<String> items3;

    //Crear una variable de instancia
    private adapterVerNotificaciones.OnItemClickListener listener;

    public adapterVerNotificaciones(List<String> items,
                             List<String> items2,
                             List<String> items3) {
        this.items = items;
        this.items2 = items2;
        this.items3 = items3;

    }

    //Creación del item en el holder:
    @Override
    public adapterVerNotificaciones.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ver_notificaciones, parent, false);
        return new adapterVerNotificaciones.ViewHolder(view);
    }
    //mapeo de los datos a la vista del item
    @Override
    public void onBindViewHolder(adapterVerNotificaciones.ViewHolder holder, int position) {
        holder.nombreCorte.setText(items.get(position));
        holder.precio.setText(items2.get(position));
        holder.des.setText(items3.get(position));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int pos = holder.getAbsoluteAdapterPosition();
                    listener.onItemClick(pos);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    //La interfaz y el metodo de setOnItemClickListener
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(adapterVerNotificaciones.OnItemClickListener listener) {this.listener = listener;
    }
    //Clase del holder para identificar las vistas
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreCorte,precio,des;

        public ViewHolder( View itemView) {
            super(itemView);
            nombreCorte= itemView.findViewById(R.id.txt_nombre_corte_vernotificacion);
            precio = itemView.findViewById(R.id.txt_precio_corte_verNotificacion);
            des = itemView.findViewById(R.id.txt_des_verNotificacion);
        }

    }
    //Tamaño de la lista


}
