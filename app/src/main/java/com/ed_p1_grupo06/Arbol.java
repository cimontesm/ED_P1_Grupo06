package com.ed_p1_grupo06;

public class Arbol {
    private Nodo raiz;

    public Arbol(Tablero estadoInicial) {
        this.raiz = new Nodo(estadoInicial);
    }

    public Nodo getRaiz() {
        return raiz;
    }
}
