package com.edwindeleon.org.ejemploandroidagenda.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.edwindeleon.org.ejemploandroidagenda.R;

public class DetalleContactos extends AppCompatActivity {

    public TextView tvNombre;
    public TextView tvTelefono;
    public TextView tvCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contactos);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("Nombre");
        String telefono = parametros.getString("Telefono");
        String correo = parametros.getString("Correo");

        tvNombre = (TextView) findViewById(R.id.nombre);
        tvTelefono = (TextView) findViewById(R.id.telefono);
        tvCorreo = (TextView) findViewById(R.id.correo);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvCorreo.setText(correo);

    }


    public void llamar(View view) {
        String telefono = tvTelefono.getText().toString();
        Intent llamar = new Intent(Intent.ACTION_DIAL);
        llamar.setData(Uri.parse("tel:" + telefono));
        if(llamar.resolveActivity(getPackageManager()) != null){
            startActivity(llamar);
        }
    }

    public void enviarMensaje(View view){
        Intent mensajito = new Intent(Intent.ACTION_SENDTO);
        mensajito.setData(Uri.parse("smsto:"));
        if(mensajito.resolveActivity(getPackageManager()) != null){
            startActivity(mensajito);
        }
        //para crear toast´s
        //Toast correo = Toast.makeText(this, "No se puede enviar mensaje ahora.", Toast.LENGTH_LONG);
        //correo.show();
    }

    public void enviarCorreo(View view){
        String correo = tvCorreo.getText().toString();

        Intent correoIntent = new Intent((Intent.ACTION_SEND));
        correoIntent.setData(Uri.parse("mailto:"));
        correoIntent.putExtra(Intent.EXTRA_EMAIL, correo);
        correoIntent.setType("message/rfc822");
        if(correoIntent.resolveActivity(getPackageManager()) != null){
            startActivity(Intent.createChooser(correoIntent, "Email "));
        }

    }
}
