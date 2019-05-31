package com.example.restapp.pojos;

public class Bebida {
    String nombre;
    String descripcion;
    String fotoID;
    String precio;

    public Bebida(){

    }

    public Bebida(String nombre, String descripcion, String fotoID, String precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoID = fotoID;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoID() {
        return fotoID;
    }

    public void setFotoID(String fotoID) {
        this.fotoID = fotoID;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
