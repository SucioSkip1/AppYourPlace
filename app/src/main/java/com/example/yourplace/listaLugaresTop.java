package com.example.yourplace;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class listaLugaresTop extends  RecyclerView.Adapter <listaLugaresTop.ViewHolder>{
    private final List<String> nombreLocal,desLocal;
    private final List<Integer> imgLocal;

    //Crear una variable de instancia
    private OnItemClickListener listener;
    public listaLugaresTop(List<String> nombreNegocio, List<String> desNegocio, List<Integer> img_Negocio)
    {
        this.nombreLocal = nombreNegocio;
        this.desLocal = desNegocio;
        this.imgLocal = img_Negocio;
    }




    //Creación del item en el holder:
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lugares_top, parent, false);
        return new ViewHolder(view);
    }
    //mapeo de los datos a la vista del item
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtTitulo.setText(nombreLocal.get(position));
        holder.txtDes.setText(desLocal.get(position));
        holder.imageView.setImageResource(imgLocal.get(position));



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
        return nombreLocal.size();
    }
    //La interfaz y el metodo de setOnItemClickListener
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    //Clase del holder para identificar las vistas
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitulo,txtDes;
        public ImageView imageView;

        public ViewHolder( View itemView) {
            super(itemView);
            txtTitulo= itemView.findViewById(R.id.item_lista_lugares_top_mapa);
            txtDes = itemView.findViewById(R.id.des_item_lista_lugares_top);
            imageView = itemView.findViewById(R.id.img_item_lista_lugares_top);
        }

    }
}
