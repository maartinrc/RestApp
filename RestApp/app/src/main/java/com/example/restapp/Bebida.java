package com.example.restapp;

public class Bebida {
    String nombre;
    String descripcion;
    int fotoID;
    String precio;

    public Bebida(){

    }

    public Bebida(String nombre, String descripcion, int fotoID, String precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoID = fotoID;
        this.precio = precio;
    }
}
