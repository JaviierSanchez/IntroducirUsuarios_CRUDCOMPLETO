package com.example.introducirusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class CrearUsu extends AppCompatActivity {

    EditText usu;
    EditText pass;
    Button crear, atras;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usu);

        usu = findViewById(R.id.editTextTextUsuario2);
        pass = findViewById(R.id.editTextTextPassword2);
        crear = findViewById(R.id.buttonCrear);
        atras = findViewById(R.id.buttonAtras1);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarUsuario();
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearUsu.this, MenusCRUD.class);
                startActivity(intent);
            }
        });

    }

    private void agregarUsuario() {
        String usuario = usu.getText().toString().trim();
        String contraseña = pass.getText().toString().trim();

        if (!usuario.isEmpty() && !contraseña.isEmpty()) {
            // Crear un objeto AsyncTask para manejar la operación de red en segundo plano
            new AgregarUsuarioTask().execute(usuario, contraseña);

        } else {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
        }
    }

    private class AgregarUsuarioTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            // Realizar la operación de red y enviar datos al servidor PHP
            // Utilizamos la clase ConexionPHP que definimos anteriormente
            HashMap<String, String> postDataParams = new HashMap<>();
            postDataParams.put("user", params[0]);
            postDataParams.put("password", params[1]);

            return ConexionPHP.enviarPost("http://192.168.1.12/inicio/crear.php", postDataParams);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(CrearUsu.this, result, Toast.LENGTH_SHORT).show();
            usu.setText("");
            pass.setText("");
        }
    }
}
