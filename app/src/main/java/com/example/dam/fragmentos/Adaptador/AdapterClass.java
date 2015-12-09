package com.example.dam.fragmentos.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dam.fragmentos.Datos.Agenda;
import com.example.dam.fragmentos.Datos.GestionContactos;
import com.example.dam.fragmentos.R;

import java.util.ArrayList;

/**
 * Created by 2dam on 05/10/2015.
 */
public class AdapterClass extends ArrayAdapter<String> {

    private Context contexto;
    private LayoutInflater i;
    private Agenda a;


    public AdapterClass(Context context, Agenda objects) {
        super(context, R.layout.lista_detalle, objects);
        this.contexto=context;
        this.a = objects;

        i = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv1, tv2;
        ViewHolder gv;

        if (convertView==null) {
            gv = new ViewHolder();
            convertView = i.inflate(R.layout.lista_detalle, null);
            tv1 = (TextView) convertView.findViewById(R.id.tvDetalle1);
            gv.t1=tv1;
            tv2 = (TextView) convertView.findViewById(R.id.tvDetalle2);
            gv.t2=tv2;
            convertView.setTag(gv);
        } else {
            gv= (ViewHolder) convertView.getTag();
        }

        gv.t1.setText(a.getContacto(position).getNombre());
        GestionContactos gc = new GestionContactos();
        ArrayList list = gc.getListaTelefonos(a.getContacto(position).getId(),convertView.getContext());
        gv.t2.setText(""+list.get(0));
        return convertView;
    }

    static class ViewHolder {
        public TextView t1,t2;
    }
}
