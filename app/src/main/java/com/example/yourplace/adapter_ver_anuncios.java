package com.example.yourplace;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter_ver_anuncios extends RecyclerView.Adapter <adapter_ver_anuncios.ViewHolder>
{


    private List<String> items4;
    private List<String> items5;
    private List<String> items6;
    private List<String> items7;

    //Crear una variable de instancia
    private adapter_ver_anuncios.OnItemClickListener listener;

    public adapter_ver_anuncios(
            List<String> items4,
            List<String> items5,
            List<String> items6,
            List <String> item7) {
        this.items4 = items4;
        this.items5 = items5;
        this.items6 = items6;
        this.items7 = item7;
    }

    //Creación del item en el holder:
    @Override
    public adapter_ver_anuncios.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_anunos_vernotificaciones, parent, false);
        return new adapter_ver_anuncios.ViewHolder(view);
    }
    //mapeo de los datos a la vista del item
    @Override
    public void onBindViewHolder(adapter_ver_anuncios.ViewHolder holder, int position) {
        holder.nombreAnuncio.setText(items4.get(position));
        holder.distancia.setText(items5.get(position));
        holder.pago.setText(items6.get(position));
        holder.des.setText(items4.get(position));

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
        return items7.size();
    }
    //La interfaz y el metodo de setOnItemClickListener
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(adapter_ver_anuncios.OnItemClickListener listener) {this.listener = listener;
    }
    //Clase del holder para identificar las vistas
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreAnuncio,distancia,pago,des;

        public ViewHolder( View itemView) {
            super(itemView);
            nombreAnuncio= itemView.findViewById(R.id.nombre_ver_anuncio);
            distancia = itemView.findViewById(R.id.distancia_ver_anuncio);
            pago = itemView.findViewById(R.id.pago_ver_anuncio_Txt);
            des = itemView.findViewById(R.id.txt__desver_anuncio_item_veranuncio);
        }

    }
    //Tamaño de la lista





}
