package com.example.guardarimagen.entidades;

import java.sql.Blob;

public class Usuario {

    private int id;
    private int nombre;
    private int telefono;

    private Blob imagen;

    public Usuario(int id, int nombre, int telefono, Blob imagen) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
