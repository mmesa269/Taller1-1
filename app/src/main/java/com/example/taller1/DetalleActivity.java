package com.example.taller1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetalleActivity  extends AppCompatActivity{

    private TextView tvTituloDetalle, tvPrecioDetalle;
    private ImageView ivImagenPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        setTitle((getString(R.string.txt_listado)));

        tvTituloDetalle = findViewById(R.id.tvTituloDetalle);
        tvPrecioDetalle = findViewById(R.id.tvItemDetalle);
        ivImagenPrincipal = findViewById(R.id.ivImagenDetalle);

        producto miProductoAtrapado = (producto) getIntent().getSerializableExtra("Producto");

        tvTituloDetalle.setText(miProductoAtrapado.getNombre());
        tvPrecioDetalle.setText(miProductoAtrapado.getPrecio().toString());
        Picasso.get()
                .load(miProductoAtrapado.getUrlimagen())
                .error(R.drawable.ic_launcher_background)
                .into(ivImagenPrincipal);
    }
}
