package com.example.taller1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<producto> Listaprincipalproducto;
    private RecyclerView rv_listado_productos;

    private AdaptadorPersonalizado miAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.txt_listado));
        cargarDatos();

        rv_listado_productos = findViewById(R.id.rv_listado_productos);

        miAdaptador = new AdaptadorPersonalizado(Listaprincipalproducto);

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

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("Productos").get().addOnCompleteListener(
                new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(DocumentSnapshot document : task.getResult()){
                                producto productoAtrapado = document.toObject(producto.class);
                                productoAtrapado.setId(document.getId());
                                Listaprincipalproducto.add(productoAtrapado);
                            }

                            miAdaptador.setListainfo(Listaprincipalproducto);
                        }else{
                            Toast.makeText(MainActivity.this, "No se pudo conectar al servidor", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        );
    }
    public void clickAtras (View view){
        Intent miIntent2 = new Intent(this, Inicarsesion_activity.class);
        startActivity(miIntent2);
        finish();
    }
    public void clickAdd (View view){
        Intent miIntent3 = new Intent(this, formulario_1.class);
        startActivity(miIntent3);
        finish();
    }
}