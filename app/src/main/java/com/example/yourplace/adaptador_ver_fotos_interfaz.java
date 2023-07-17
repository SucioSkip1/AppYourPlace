package com.example.yourplace;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

 /*Error*/   public class adaptador_ver_fotos_interfaz extends  RecyclerView.Adapter <adaptador_ver_fotos_interfaz.ViewHolder>{
    private final List<Integer> logo;

    //Crear una variable de instancia
    private OnItemClickListener listener;


    public adaptador_ver_fotos_interfaz(List<Integer> logo)
    {

        this.logo = logo;
    }




    //Creación del item en el holder:
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ver_fotos_interfaz, parent, false);
    /*Error*/    return new ViewHolder(view);
    }
    //mapeo de los datos a la vista del item
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(logo.get(position));


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
        return logo.size();
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

        public ImageView imageView;

        public ViewHolder( View itemView) {
            super(itemView);
/*Error*/            imageView = itemView.findViewById(R.id.img_ver_fotos_interfaz_item);
    }

    }



}
