package com.example.taller1;

import java.io.Serializable;

public class producto implements Serializable {

    private String nombre;
    private Double precio;
    private String urlimagen;

    public producto(){}

    public producto(String Nombre, Double precio, String urlimagen) {
        this.nombre = Nombre;
        this.precio = precio;
        this.urlimagen = urlimagen;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public String getUrlimagen() {
        return urlimagen;
    }
    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }
}
