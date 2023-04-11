package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<producto> Listaprincipalproducto;
    private RecyclerView rv_listado_productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.txt_listado));
        cargarDatos();

        rv_listado_productos = findViewById(R.id.rv_listado_productos);

        AdaptadorPersonalizado miAdaptador = new AdaptadorPersonalizado(Listaprincipalproducto);

        miAdaptador.setOnItemClickListener(new AdaptadorPersonalizado.OnItemClickListener() {
            @Override
            public void onItemClick(producto producto, int posicion) {
                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("Producto", producto);
                startActivity(intent);
 }

            @Override
            public void onItembtnEraseClick(producto producto, int posicion) {
                Listaprincipalproducto.remove(posicion);
                miAdaptador.setListainfo(Listaprincipalproducto);
            }
        });

        rv_listado_productos.setAdapter(miAdaptador);
        rv_listado_productos.setLayoutManager(new LinearLayoutManager(this));
    }

    public void cargarDatos(){
        producto producto1 = new producto();
        producto1.setNombre("Computador HP");
        producto1.setPrecio(1749000.00);
        producto1.setUrlimagen("https://http2.mlstatic.com/D_NQ_NP_600265-MLA48808603714_012022-O.jpg");

        producto producto2 = new producto();
        producto2.setNombre("Apple iPhone 9");
        producto2.setPrecio(4500000.00);
        producto1.setUrlimagen("https://http2.mlstatic.com/D_NQ_NP_737941-MLA44156685708_112020-O.jpg");

        Listaprincipalproducto = new ArrayList<>();
        Listaprincipalproducto.add(producto1);
        Listaprincipalproducto.add(producto2);

    }
}