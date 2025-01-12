package com.ed_p1_grupo06;

public class Ficha {
    //en vez de tener la clase jugador y dividirla en 2 con la ficha se puede manejar los movimientos
    //ademas aqui se tienen los tipos de ficha
    public enum TipoFicha { CRUZ, CIRCULO, VACIO }

    private TipoFicha tipo;

    public Ficha(TipoFicha tipo) {
        this.tipo = tipo;
    }

    public TipoFicha getTipo() {
        return tipo;
    }

    public void setTipo(TipoFicha tipo) {
        this.tipo = tipo;
    }
}
