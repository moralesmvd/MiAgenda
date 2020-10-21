package com.example.miagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto("Frida LaGatta","098768678","frida@whiskas.com"));
        contactos.add(new Contacto("Margarita LaGatta","098787698","maggie@whiskas.com"));
        contactos.add(new Contacto("Adolfo Canni","095668678","Adolfoc@hunter.com"));
        contactos.add(new Contacto("Paolo Cryer","094658276","PaoloC@mail.com"));

        ArrayList<String> nombresContacto= new ArrayList<>();
        for (Contacto contacto: contactos) {
            nombresContacto.add(contacto.getNombre());
            
        }

        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent (MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra((getResources().getString(R.string.ptelefono)), contactos.get(position).getTelefono());
                intent.putExtra((getResources().getString(R.string.pemail)), contactos.get(position).getEmail());
                startActivity(intent);
            }
        });
    }
}