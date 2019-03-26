package com.lovartech.milistadofavorito;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString(getResources().getString(R.string.pNombre));
        String telefono = parametros.getString(getResources().getString(R.string.pTelefono));
        String email = parametros.getString(getResources().getString(R.string.pEmail));
        String descripcion = parametros.getString(getResources().getString(R.string.pDescripcion));

        TextView tvNombre = (TextView) findViewById(R.id.tvNombreCompleto);
        TextView tvTelefono = (TextView)  findViewById(R.id.tvTelefono);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                startActivity(intent);
            }
        });
    }
}
