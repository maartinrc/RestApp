package com.example.restapp;

public class Platillo {
    String nombre;
    String descripcion;
    int fotoID;
    String precio;

    public Platillo(){

    }

    public Platillo(String nombre, String descripcion, int fotoID,String precio){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoID = fotoID;
        this.precio = precio;
    }
}
