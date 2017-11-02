package com.edwindeleon.org.ejemploandroidagenda.activities;

import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edwindeleon.org.ejemploandroidagenda.R;

import static android.support.design.widget.Snackbar.*;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView about = (TextView) findViewById(R.id.about);
        registerForContextMenu(about);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto, menu);
    }

    public void snackbar(View view){
        Snackbar.make(view, "About", LENGTH_LONG).show();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.mEditar:
                Toast editar = Toast.makeText(this, "Editar", Toast.LENGTH_LONG);
                editar.show();
                break;

            case R.id.mEliminar:
                Toast eliminar = Toast.makeText(this, "Eliminar", Toast.LENGTH_LONG);
                eliminar.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void levantarMenuPoput(View view){
        ImageView imgAbout = (ImageView) findViewById(R.id.imgAbout);
        PopupMenu popupMenu = new PopupMenu(this, imgAbout);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
    }
}
