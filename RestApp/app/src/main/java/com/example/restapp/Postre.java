package com.example.restapp;

public class Postre {
    String nombre;
    String descripcion;
    int fotoID;
    String precio;

    public Postre(){

    }


    public Postre(String nombre, String descripcion, int fotoID, String precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoID = fotoID;
        this.precio = precio;
    }
}
