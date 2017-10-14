package com.edwindeleon.org.ejemploandroidagenda.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.edwindeleon.org.ejemploandroidagenda.R;
import com.edwindeleon.org.ejemploandroidagenda.beans.Contacto;

import java.util.ArrayList;

public class Contactos extends AppCompatActivity {

    private ArrayList<Contacto> listaContactos;
    private int idContacto = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        idContacto++;
        listaContactos = new ArrayList<>();

        listaContactos.add(new Contacto(idContacto, "Juana", "45879639", "juana2016@hotmail.com"));
        listaContactos.add(new Contacto(idContacto, "Alan", "45879639", "alan@hotmail.com"));
        listaContactos.add(new Contacto(idContacto, "Perla", "58968939", "perla@hotmail.com"));

        final ArrayList<String> nombresContactos = new ArrayList<>();
        for(Contacto contacto: listaContactos){
            nombresContactos.add(contacto.getNombre());

        }

        ListView listaDeContactos = (ListView) findViewById(R.id.listaContactos);
        listaDeContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContactos));

        listaDeContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detalleContacto = new Intent(Contactos.this, DetalleContactos.class);
                detalleContacto.putExtra("Nombre", listaContactos.get(i).getNombre());
                detalleContacto.putExtra("Telefono", listaContactos.get(i).getTelefono());
                detalleContacto.putExtra("Correo", listaContactos.get(i).getCorreo());
                startActivity(detalleContacto);
                finish();
            }
        });



    }
}
