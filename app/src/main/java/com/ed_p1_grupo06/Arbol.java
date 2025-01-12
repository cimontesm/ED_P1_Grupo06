package com.ed_p1_grupo06;

public class Arbol<T> {
    private Nodo<T> raiz;

    public Arbol(T estadoInicial) {
        this.raiz = new Nodo<>(estadoInicial);
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void construirArbol(T estado, Tablero tablero, Ficha.TipoFicha jugador) {
        construirArbolRecursivo(raiz, jugador, true, tablero);
    }

    private void  construirArbolRecursivo(Nodo<T> nodo, Ficha.TipoFicha jugador, boolean turnoComputadora, Tablero tablero){
        T estadoActual = nodo.getEstado();
        Tablero estadoTablero = (Tablero) estadoActual;
    }

    public Tablero obtenerMejorMovimiento(Tablero tablero, Ficha.TipoFicha ia){
        construirArbol((T) tablero, tablero, ia);

        Nodo<T> raiz = getRaiz();
        Nodo<T> mejorHijo = null;

        return tablero;
    }
}
