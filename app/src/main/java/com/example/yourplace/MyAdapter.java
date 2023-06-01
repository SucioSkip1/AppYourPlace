package com.example.yourplace;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends  RecyclerView.Adapter <MyAdapter.ViewHolder>{
    private final List<String> nombreNegocio,desNegocio;
    private final List<Integer> img_Negocio;

    //Crear una variable de instancia
    private OnItemClickListener listener;
    public MyAdapter(List<String> nombreNegocio, List<String> desNegocio, List<Integer> img_Negocio)
    {
        this.nombreNegocio = nombreNegocio;
        this.desNegocio = desNegocio;
        this.img_Negocio = img_Negocio;
    }




    //Creación del item en el holder:
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_interfaz_negocio, parent, false);
        return new ViewHolder(view);
    }
    //mapeo de los datos a la vista del item
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtTitulo.setText(nombreNegocio.get(position));
        holder.txtDes.setText(desNegocio.get(position));
        holder.imageView.setImageResource(img_Negocio.get(position));



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
        return img_Negocio.size();
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
            txtTitulo= itemView.findViewById(R.id.txt_nombreNegocio_Interfaz_negocio);
            txtDes = itemView.findViewById(R.id.txt_descripcion_negocio_interfaz_negocio);
            imageView = itemView.findViewById(R.id.img_negocio_interfaz_negocio);
        }

    }
}
