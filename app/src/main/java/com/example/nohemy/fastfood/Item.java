package com.example.nohemy.fastfood;

import android.graphics.Bitmap;

/**
 * Created by Nohemy on 22/06/2015.
 */
public class Item {
    private int precio;
    private String url;
    private String descripcion;
    private String nombre;
    private Bitmap img;

    public Bitmap getBitmap() {
        return this.img;
    }

    public void setBitmap(Bitmap i) {
        this.img = i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
