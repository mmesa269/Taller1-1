package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class formulario_1 extends AppCompatActivity {

    private TextView prod_nombre;
    private TextView prod_precio;
    private TextView prod_imagen;
    private Button crear_prod;
    private ArrayList<producto> Listaprincipalproducto;
    private RecyclerView rv_listado_productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario1);
        crear_prod = findViewById(R.id.crear_prod);
        crear_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                producto productonuevo = new producto();
                productonuevo.setNombre(prod_nombre.getText().toString());
                productonuevo.setPrecio(Double.parseDouble(prod_precio.getText().toString()));
                productonuevo.setUrlimagen(prod_imagen.getText().toString());

                Listaprincipalproducto = new ArrayList<>();
                Listaprincipalproducto.add(productonuevo);

                FirebaseFirestore firestore = FirebaseFirestore.getInstance();
                firestore.collection("Porductos").add(productonuevo);

                Toast.makeText(formulario_1.this, "Se creo el producto", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
}
