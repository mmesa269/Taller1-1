package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Inicarsesion_activity extends AppCompatActivity {

    private EditText editTextTextEmailAddress, editTextTextPassword;
    private SharedPreferences misPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicarsesion);

        referenciar();

        misPreferencias = getSharedPreferences("tienda_app", MODE_PRIVATE);

        if (misPreferencias.getBoolean("logueado", false) == true){
            Intent miIntent = new Intent(this, MainActivity);
            startActivity(miIntent);
            finish();
        }
    }

    private void referenciar() {

        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
    }

    public void clickIniciarSesion (View view){
        String PASS = "123456";
        String User = "fabian";

        String passUser = editTextTextEmailAddress.getText().toString();
        String useruser = editTextTextPassword.getText().toString();

        if (PASS.equals(passUser) && User.equals(useruser)) {
            SharedPreferences.Editor mieditor = misPreferencias.edit();
            mieditor.putBoolean("loqued", true);
            mieditor.apply();
            Intent miIntent = new Intent(this, MainActivity);
            startActivity(miIntent);
            finish();
        } else {
            Toast.makeText(this, "No estas en el registro", Toast.LENGTH_SHORT).show();
        }
    }
}
