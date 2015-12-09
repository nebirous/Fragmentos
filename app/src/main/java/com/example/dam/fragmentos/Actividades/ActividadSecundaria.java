package com.example.dam.fragmentos.Actividades;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.example.dam.fragmentos.Datos.Contacto;
import com.example.dam.fragmentos.Fragmentos.Fragmento2;
import com.example.dam.fragmentos.R;

/**
 * Created by 2dam on 17/11/2015.
 */
public class ActividadSecundaria extends AppCompatActivity {

    private Contacto c;
    private static Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);
        if(savedInstanceState != null){
            c = (Contacto) savedInstanceState.getSerializable("contacto");
        }
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Bundle e = getIntent().getExtras();
            c = (Contacto) e.getSerializable("contacto"); //e.getString("valor");
            Fragmento2 fragmento = (Fragmento2) getFragmentManager().findFragmentById(R.id.fragmento2);
            fragmento.update(c);
        }else{
            Intent intent=new Intent(this,Principal.class);
            Bundle b = new Bundle();
            b.putSerializable("contacto",c);
            System.out.println("Contacto: "+c);
            intent.putExtras(b);
            setResult(Activity.RESULT_OK,intent);
            finish();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("contacto", c);
    }

}
