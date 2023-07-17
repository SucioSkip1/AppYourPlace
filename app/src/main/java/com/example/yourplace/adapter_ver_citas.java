package com.example.yourplace;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter_ver_citas extends RecyclerView.Adapter <adapter_ver_citas.ViewHolder>{
    private List<String> items;
    private List<String> items2;
    private List<String> items3;

    //Crear una variable de instancia
    private OnItemClickListener listener;

    public adapter_ver_citas(List<String> items,
                     List<String> items2,
                     List<String> items3) {
        this.items = items;
        this.items2 = items2;
        this.items3 = items3;

    }

    //Creación del item en el holder:
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_de_chat_ver_citas, parent, false);
        return new ViewHolder(view);
    }
    //mapeo de los datos a la vista del item
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txthora.setText(items.get(position));
        holder.txtpago.setText(items2.get(position));
        holder.notas.setText(items3.get(position));


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
    public void setOnItemClickListener(OnItemClickListener listener) {this.listener = listener;
    }
    //Clase del holder para identificar las vistas
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txthora,txtpago,notas;

        public ViewHolder( View itemView) {
            super(itemView);
            txthora= itemView.findViewById(R.id.txt_hora_ver_cita);
            txtpago = itemView.findViewById(R.id.txt_pago_ver_citas);
            notas = itemView.findViewById(R.id.txt_notas_ver_citas);
        }

    }
    //Tamaño de la lista


}