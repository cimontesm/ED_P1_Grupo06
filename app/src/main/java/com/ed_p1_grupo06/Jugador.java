package com.ed_p1_grupo06;

public class Jugador {
    private String nombre;
    private Ficha.TipoFicha ficha;

    public Jugador(String nombre, Ficha.TipoFicha ficha) {
        this.nombre = nombre;
        this.ficha = ficha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ficha.TipoFicha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha.TipoFicha ficha) {
        this.ficha = ficha;
    }
}
