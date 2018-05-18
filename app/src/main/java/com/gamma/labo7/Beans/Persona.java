package com.gamma.labo7.Beans;

public class Persona {
    String dui, nombre;

    public Persona(){}

    public Persona(String dui, String nombre) {
        this.dui = dui;
        this.nombre = nombre;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
