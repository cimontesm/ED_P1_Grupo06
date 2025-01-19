package com.ed_p1_grupo06;

import java.util.ArrayList;
import java.util.List;

public class Nodo<T> {
    private T estado;
    private List<Nodo<T>> hijos;
    private int utilidad;

    public Nodo(T estado) {
        this.estado = estado;
        this.hijos = new ArrayList<>();
    }

    public T getEstado() {
        return estado;
    }

    public void agregarHijo(Nodo<T> hijo) {
        hijos.add(hijo);
    }

    public List<Nodo<T>> getHijos() {
        return hijos;
    }

    public int getUtilidad() {
        return utilidad;
    }

    public void setUtilidad(int utilidad) {
        this.utilidad = utilidad;
    }
}