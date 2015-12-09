package com.example.dam.fragmentos.Fragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dam.fragmentos.Datos.Contacto;
import com.example.dam.fragmentos.Datos.GestionContactos;
import com.example.dam.fragmentos.R;

import java.util.ArrayList;

/**
 * Created by 2dam on 17/11/2015.
 */
public class Fragmento2 extends Fragment {

    private View viewFragmento;
    private TextView tv1, tv2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        viewFragmento = inflater.inflate(R.layout.fragmento2,container, false);
        tv1 = (TextView) viewFragmento.findViewById(R.id.tv1);
        tv2 = (TextView) viewFragmento.findViewById(R.id.tv2);
        return viewFragmento;

    }

    public void update(Contacto c){
        tv1.setText(c.getNombre());
        ArrayList lista = new ArrayList();
        GestionContactos gc = new GestionContactos();
        lista = gc.getListaTelefonos(c.getId(),viewFragmento.getContext());
        tv2.setText(toStringMod(lista));
    }
    public String toStringMod(ArrayList<String> lista){
        String aux = new String();
        for(String a: lista){
            aux += a+"\n";
        }
        System.out.println(aux);
        return aux;

    }

}
