package com.example.introducirusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUsuario, editTextContraseña;
    private Button botonAgregar;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsuario = findViewById(R.id.editTextTextUsuario);
        editTextContraseña = findViewById(R.id.editTextTextPassword);
        botonAgregar = findViewById(R.id.button);

        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarUsuario();
            }
        });
    }

    private void agregarUsuario() {
        String usuario = editTextUsuario.getText().toString().trim();
        String contraseña = editTextContraseña.getText().toString().trim();

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

            return ConexionPHP.enviarPost("http://192.168.1.12/inicio/insertar_usuario.php", postDataParams);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            if (result.equals("Bienvenido")) {
                // Iniciar la nueva actividad aquí
                Intent intent = new Intent(MainActivity.this, MenusCRUD.class);
                startActivity(intent);
            }
        }
    }
}