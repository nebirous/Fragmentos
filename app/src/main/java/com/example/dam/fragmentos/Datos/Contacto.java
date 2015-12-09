package com.example.dam.fragmentos.Datos;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Nebirous on 08/12/2015.
 */
public class Contacto implements Serializable, Comparable<Contacto>{
    private long id;
    private String nombre;
    private ArrayList<String> nums;


    /* *********** CONSTRUCTORES *********** */
    public Contacto() {
    }

    public Contacto(long id, String nombre, ArrayList numeros) {
        this.id = id;
        nombre = nombre;
        this.nums = numeros;
    }
    protected Contacto(Parcel in) {
        id = in.readLong();
        nombre = in.readString();
        nums = new ArrayList<String>();
        in.readList(nums,null);

    }
    public static final Parcelable.Creator<Contacto> CREATOR = new Parcelable.Creator<Contacto>() {
        @Override
        public Contacto createFromParcel(Parcel in) {
            return new Contacto(in);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };

    /* ******************* Getter y setters ******************** */

    public long getId(){return id;}

    public void setId(long id){this.id= id;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero(int posicion){
        return nums.get(posicion);
    }
    public String getNums() {
        String numeros = toStringMod();
        return numeros;
    }
    public ArrayList<String> devolverNums(){
        return nums;
    }
    public String getPrimero(){
        return nums.get(0);
    }
    public void setNum(ArrayList<String> num){
        nums = num;
    }
    public int tamNumeros(){
        return nums.size();
    }
    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", Nombre='" + nombre + '\'' +
                '}';
    }
    public String toStringMod(){
        String numeros = "";
        for(int i = 0; i < nums.size(); i++){
            numeros += getNumero(i) + "\n";
            System.out.println("------"+ numeros+"\n");
        }
        return numeros;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacto contacto = (Contacto) o;

        return !(nums != null ? !nums.equals(contacto.nums) : contacto.nums != null);

    }
    @Override
    public int hashCode() {
        return nums != null ? nums.hashCode() : 0;
    }

    @Override
    public int compareTo(Contacto contacto) {
        int r = this.nombre.compareToIgnoreCase(contacto.nombre);
        if(r==0){
            r=(int)(this.id-contacto.id);
        }
        return r;
    }
    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nombre);
        dest.writeList(nums);
    }


}
