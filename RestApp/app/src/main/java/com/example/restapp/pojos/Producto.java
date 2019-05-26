package com.example.restapp.pojos;

public class Producto {
    private String nombre;
    private String descripcion;
    private int fotoID;
    private String precio;
    private int status;
    private int tipo;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, int fotoID, String precio, int status, int tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotoID = fotoID;
        this.precio = precio;
        this.status = status;
        this.tipo = tipo;
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

    public int getFotoID() {
        return fotoID;
    }

    public void setFotoID(int fotoID) {
        this.fotoID = fotoID;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
