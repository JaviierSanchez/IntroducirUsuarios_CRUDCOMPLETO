package com.example.introducirusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class ModificarPassword extends AppCompatActivity {


    EditText editTextUser;
    EditText editTextPasswordOld;
    EditText editTextPasswordNew;
    Button btnActualizar, btnAtras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_usu);

        editTextUser = findViewById(R.id.editTextUser);
        editTextPasswordOld = findViewById(R.id.editTextPasswordOld);
        editTextPasswordNew = findViewById(R.id.editTextPasswordNew);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnAtras = findViewById(R.id.btnAtras);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modificarContraseña();
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModificarPassword.this, MenusCRUD.class);
                startActivity(intent);
            }
        });

    }

    private void modificarContraseña() {
        String usuario = editTextUser.getText().toString().trim();
        String contraseñaOld = editTextPasswordOld.getText().toString().trim();
        String nuevaContraseña = editTextPasswordNew.getText().toString().trim();

        if (!usuario.isEmpty() && !contraseñaOld.isEmpty() && !nuevaContraseña.isEmpty()) {
            new ModificarContraseñaTask().execute(usuario, contraseñaOld, nuevaContraseña);
        } else {
            Toast.makeText(this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
        }
    }
    private class ModificarContraseñaTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            HashMap<String, String> postDataParams = new HashMap<>();
            postDataParams.put("user", params[0]);
            postDataParams.put("password", params[1]);
            postDataParams.put("new_password", params[2]);

            return ConexionPHP.enviarPost("http://192.168.1.12/inicio/modificar.php", postDataParams);
        }



        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(ModificarPassword.this, result, Toast.LENGTH_SHORT).show();
            editTextUser.setText("");
            editTextPasswordOld.setText("");
            editTextPasswordNew.setText("");
        }
    }







}