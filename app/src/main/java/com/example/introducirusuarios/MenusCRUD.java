package com.example.introducirusuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenusCRUD extends AppCompatActivity {

    Button añdir, borrar, modifiar, listar, atras,modificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus_crud);

        añdir = findViewById(R.id.buttonAñadir);
        borrar = findViewById(R.id.buttonBorrar);
        modifiar = findViewById(R.id.buttonModificar);
        listar = findViewById(R.id.buttonListar);
        modificar = findViewById(R.id.buttonModificar);
        atras = findViewById(R.id.buttonAtras);

        añdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenusCRUD.this, CrearUsu.class);
                // Iniciar la nueva actividad
                startActivity(intent);
            }
        });
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenusCRUD.this, BorrarUsu.class);
                // Iniciar la nueva actividad
                startActivity(intent);
            }
        });
        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenusCRUD.this, ListarUsu.class);
                // Iniciar la nueva actividad
                startActivity(intent);
            }
        });

        modifiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenusCRUD.this, ModificarPassword.class);
                startActivity(intent);
            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenusCRUD.this,MainActivity.class);
                // Iniciar la nueva actividad
                startActivity(intent);
            }
        });
    }
}