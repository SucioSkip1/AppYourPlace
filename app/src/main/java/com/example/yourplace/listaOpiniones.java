package com.example.yourplace;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class listaOpiniones extends RecyclerView.Adapter <listaOpiniones.ViewHolder>{

    private final List<String> nombreCliente;
    private final List<String> opinion;
    private final List<String> calificacion;
    private final List<Integer> listaImgClientes;

    //Crear una variable de instancia
    private OnItemClickListener listener;

    public listaOpiniones(List<String> nombreCliente, List<String> opinion, List<String> calificacion, List<Integer> listaImgClientes) {
        this.nombreCliente= nombreCliente;
        this.opinion = opinion;
        this.calificacion = calificacion;
        this.listaImgClientes= listaImgClientes;

    }




    //Creación del item en el holder:
    @Override
    public listaOpiniones.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_catalogo_cortes, parent, false);
        return new ViewHolder(view);
    }
    //mapeo de los datos a la vista del item
    @Override
    public void onBindViewHolder(listaOpiniones.ViewHolder holder, int position) {
        holder.txtCorte.setText(nombreCliente.get(position));
        holder.txtdesCorte.setText(opinion.get(position));
        holder.imageView.setImageResource(listaImgClientes.get(position));
        holder.txtPrecio.setText(calificacion.get(position));


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
        return listaImgClientes.size();
    }
    //La interfaz y el metodo de setOnItemClickListener
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(listaOpiniones.OnItemClickListener listener) {
        this.listener = listener;
    }
    //Clase del holder para identificar las vistas
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtCorte,txtdesCorte,txtPrecio;
        public ImageView imageView;

        public ViewHolder( View itemView) {
            super(itemView);
            txtCorte= itemView.findViewById(R.id.nombreCorte_item_catalogo);
            txtdesCorte = itemView.findViewById(R.id.des_item_catalogoCortes);
            imageView = itemView.findViewById(R.id.img_item_catalogo);
            txtPrecio = itemView.findViewById(R.id.precio_item_catalogo);
        }

    }
}
