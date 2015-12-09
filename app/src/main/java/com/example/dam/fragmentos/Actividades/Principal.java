package com.example.dam.fragmentos.Actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.dam.fragmentos.Datos.Contacto;
import com.example.dam.fragmentos.Fragmentos.Fragmento1;
import com.example.dam.fragmentos.Fragmentos.Fragmento2;
import com.example.dam.fragmentos.Fragmentos.OnFragmentInteractionListener;
import com.example.dam.fragmentos.R;

public class Principal extends AppCompatActivity implements OnFragmentInteractionListener {

    public static final String TAG = "FRAGMENTOS";
    public static final int ALTA = 1;
    private Contacto c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad1); //Contiene 1 o dos fragmentos


    }

    @Override
    public void onFragmentoInteraccion(Contacto contacto) {

        Fragmento2 f2 = (Fragmento2)getFragmentManager().findFragmentById(R.id.fragment3);
        System.out.println("PRINCIPAL CONTACTO ALALALA");
        Fragmento1 f1 = (Fragmento1)getFragmentManager().findFragmentById(R.id.fragmento1);
        if(f2 == null||!f2.isInLayout()){
            System.out.println(contacto);
            System.out.println("F!: "+f1);
            f1.lanzarContacto(contacto);
        }else{
            System.out.println(contacto+"PRINCIPAL ASDFASDF");
            f2.update(contacto);
        }
    }


    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragmento2 f2 = (Fragmento2)getFragmentManager().findFragmentById(R.id.fragment3);
        if(resultCode == ALTA || requestCode == RESULT_OK){
            Bundle b = getIntent().getExtras();
            c = (Contacto) b.getSerializable("contacto");
            f2.update(c);
        }

    }*/
}
