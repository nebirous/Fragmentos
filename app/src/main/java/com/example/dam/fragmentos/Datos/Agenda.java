package com.example.dam.fragmentos.Datos;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nebirous on 08/12/2015.
 */
public class Agenda extends ArrayList {

    private static ArrayList<Contacto> agenda = new ArrayList<>();

    public Agenda(List<Contacto> contactos) {
        agenda = (ArrayList<Contacto>) contactos;
    }

    public Agenda(Context ctx) {
        GestionContactos gc = new GestionContactos();
        List a = gc.getListaContactos(ctx);
        Contacto aux;
        for (int i = 0; a.size() > i; i++) {
            aux = (Contacto) a.get(i);
//            System.out.println("AA---_ " + aux);
            ArrayList<String> nums = (ArrayList) gc.getListaTelefonos(aux.getId(), ctx);
            aux.setNum(nums);
            agenda.add(aux);
        }
    }

    public ArrayList<Contacto> getAgenda() {
        return agenda;
    }

    public void add(int index, Contacto object) {
        agenda.add(index, object);
    }

    public static Contacto getContacto(int indice) {
        return agenda.get(indice);
    }

    public Contacto get(int indice) {
        return agenda.get(indice);
    }

    public static void setContacto(Contacto contacto) {
        agenda.add(contacto);
    }

    public int size() {
        return agenda.size();
    }
}