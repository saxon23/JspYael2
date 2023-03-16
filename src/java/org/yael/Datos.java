package org.yael;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC
 */
public class Datos implements Serializable {

    private String nombre;
    private float calf;

    public Datos() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCalf() {
        return calf;
    }

    public void setCalf(float calf) {
        this.calf = calf;
    }

}
