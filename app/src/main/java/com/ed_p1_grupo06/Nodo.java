package com.ed_p1_grupo06;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private Tablero estado;
    private List<Nodo> hijos;
    private int utilidad;

    public Nodo(Tablero estado) {
        this.estado = estado;
        this.hijos = new ArrayList<>();
    }

    public Tablero getEstado() {
        return estado;
    }

    public void agregarHijo(Nodo hijo) {
        hijos.add(hijo);
    }

    public List<Nodo> getHijos() {
        return hijos;
    }

    public int getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(int utilidad) {
        this.utilidad = utilidad;
    }
}
