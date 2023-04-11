package com.example.taller1;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.ViewHolder> {
    private ArrayList<producto> listadoInformacion;
    private OnItemClickListener onItemClickListener;
    private ArrayList<producto> listinfo;

    public AdaptadorPersonalizado(ArrayList<producto> listadoInformacion){
        this.listadoInformacion = listadoInformacion;
        this.onItemClickListener = null;
    }

    @NonNull
    @Override
    public AdaptadorPersonalizado.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View miview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listaprducto,parent, false);
        return new ViewHolder(miview);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.ViewHolder holder, int position) {
        producto miProducto = listadoInformacion.get(position);

        holder.enlazar(miProducto);

    }

    @Override
    public int getItemCount() {
        return listadoInformacion.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setListainfo(ArrayList<producto> listaprincipalproducto) {
        this.listinfo = listaprincipalproducto;
        this.onItemClickListener=null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombre, tvPrecio;
        private ImageView ivProducto;
        private Button BtnEliminar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tv_item_nombre);
            tvPrecio = itemView.findViewById(R.id.tv_item_precio);
            ivProducto = itemView.findViewById(R.id.tv_item_imagen);
        }

        public void enlazar(producto miproducto){
            tvNombre.setText(miproducto.getNombre());
            tvPrecio.setText(miproducto.getPrecio().toString());
            Picasso.get()
                    .load(miproducto.getUrlimagen())
                    .error(R.drawable.ic_launcher_background)
                    .into(ivProducto);

            if(onItemClickListener != null) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "CLICK EN TODO EL ITEM", Toast.LENGTH_SHORT).show();
                    }
            });

            BtnEliminar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItembtnEraseClick(miproducto, getAdapterPosition());
                }
            });
            
        }
    }
    }
    public interface OnItemClickListener {
        void onItemClick(producto miproducto, int posicion);
        void onItembtnEraseClick(producto miproducto, int posicion);
    }
}
