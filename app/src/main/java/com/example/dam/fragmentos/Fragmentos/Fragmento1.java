package com.example.dam.fragmentos.Fragmentos;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dam.fragmentos.Actividades.ActividadSecundaria;
import com.example.dam.fragmentos.Adaptador.AdapterClass;
import com.example.dam.fragmentos.Datos.Agenda;
import com.example.dam.fragmentos.Datos.Contacto;
import com.example.dam.fragmentos.Datos.GestionContactos;
import com.example.dam.fragmentos.R;

import java.util.ArrayList;

/**
 * Created by 2dam on 17/11/2015.
 */
public class Fragmento1 extends Fragment {
    private Agenda a;
    private ListView lv;
    private AdapterClass ad;
    private View viewFragmento;
    private ArrayList<Contacto> lista;
    private OnFragmentInteractionListener listener;
    public static final int ALTA = 1;

    public Fragmento1() {
    }

    @Override
    public void onAttach(Activity activity) { //deprecated API 23
        super.onAttach(activity);
        try {
            listener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
            listener = (OnFragmentInteractionListener) context;
        }else{
            throw new ClassCastException();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        viewFragmento = inflater.inflate(R.layout.fragmento1,container, false);

        lista = new ArrayList<Contacto>();
        GestionContactos gc = new GestionContactos();
        lista = gc.getListaContactos(viewFragmento.getContext());

        a = new Agenda(lista);

        lv = (ListView)viewFragmento.findViewById(R.id.lvFragmento1);
        ad = new AdapterClass(this.getActivity(), a);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contacto aux = a.get(position);
                System.out.println(a.get(position));
                listener.onFragmentoInteraccion(aux);
            }
        });
        lv.setAdapter(ad);
        return viewFragmento;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == ALTA){
            Contacto c = (Contacto) data.getSerializableExtra("contacto");
            System.out.println("FRAGM CONTACTO: "+c);
            listener.onFragmentoInteraccion(c);
        }
    }

    public void lanzarContacto(Contacto c){
        Intent i = new Intent(getActivity(), ActividadSecundaria.class);
        Bundle b = new Bundle();
        b.putSerializable("contacto", c);
        i.putExtras(b);
        startActivityForResult(i, ALTA);
    }
}
