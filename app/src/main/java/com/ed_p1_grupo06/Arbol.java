package com.ed_p1_grupo06;

public class Arbol {
    private Nodo raiz;

    public Arbol(Tablero estadoInicial) {
        this.raiz = new Nodo(estadoInicial);
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void construirArbol(Tablero tablero, Ficha.TipoFicha jugador) {
        construirArbolRecursivo(raiz, jugador, true);
    }

    private void  construirArbolRecursivo(Nodo nodo, Ficha.TipoFicha jugador, boolean turnoComputadora){

    }

    public static Tablero obtenerMejorMovimiento(Tablero tablero, Ficha.TipoFicha ia){
        Arbol arbol = new Arbol(tablero.copiar());
        arbol.construirArbol(tablero, ia);
        return tablero;
    }
}
