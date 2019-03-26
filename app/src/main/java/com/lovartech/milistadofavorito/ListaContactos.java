package com.lovartech.milistadofavorito;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaContactos extends AppCompatActivity {

    ArrayList<Contactos> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contactos);

        contactos = new ArrayList<Contactos>();

        contactos.add(new Contactos("Francisco Lopez","1111111111","flopez@email.com"));
        contactos.add(new Contactos("Carolina Vargas","2222222222","cvargas@email.com"));
        contactos.add(new Contactos("Franco Vargas","3333333333","fvargas@email.com"));
        contactos.add(new Contactos("Emiliano Vargas","4444444444","evargas@email.com"));

        ArrayList<String> nombreContacto = new ArrayList<>();
        for (Contactos contacto : contactos) {
            nombreContacto.add(contacto.getNombre());
            //nombreContacto.add(contacto.getEmail());
        }

        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);

        lstContactos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombreContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaContactos.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pNombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.pTelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pEmail),contactos.get(position).getEmail());
                intent.putExtra(getResources().getString(R.string.pDescripcion), contactos.get(position).getDescripcion());
                startActivity(intent);
            }
        });
    }
}
