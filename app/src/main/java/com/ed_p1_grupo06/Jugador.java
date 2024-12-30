package com.ed_p1_grupo06;

public abstract class Jugador {
    protected char simbolo;

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public abstract int[] realizarMovimiento(char[][] tablero);
}
