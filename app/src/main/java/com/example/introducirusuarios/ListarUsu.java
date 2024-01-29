package com.example.introducirusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class ListarUsu extends AppCompatActivity {

    TextView lista;
    Button atras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usu);
        lista = findViewById(R.id.textView7);
        atras = findViewById(R.id.buttonAtras8);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListarUsu.this, MenusCRUD.class);
                startActivity(intent);
            }
        });

        new AgregarUsuarioTask().execute();
    }


    private class AgregarUsuarioTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {

            return ConexionPHP.enviarPost("http://192.168.1.12/inicio/listar.php");
        }

        @Override
        protected void onPostExecute(String result) {
            lista.setText(Html.fromHtml(result));

        }
    }
}