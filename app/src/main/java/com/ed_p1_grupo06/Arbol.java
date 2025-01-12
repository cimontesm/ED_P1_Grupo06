package com.ed_p1_grupo06;

public class Arbol<T> {
    private Nodo<T> raiz;

    public Arbol(T estadoInicial) {
        this.raiz = new Nodo<>(estadoInicial);
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void construirArbol(T estado, Ficha.TipoFicha jugador, Tablero tablero) {
        Nodo<T> raiz = getRaiz();
        minimax(raiz, jugador, true);
    }

    // este es el minimax:
    // calcula la mejor jugada considerando los movimientos del jugador humano y las respuestas posibles de la computadora.
    private void minimax(Nodo<T> nodo, Ficha.TipoFicha jugador, boolean turnoComputadora) {
        T estadoActual = nodo.getEstado();
        Tablero estadoTablero = (Tablero) estadoActual;

        if (estadoTablero.estaLleno() || estadoTablero.verificarGanador(Ficha.TipoFicha.CRUZ) || estadoTablero.verificarGanador(Ficha.TipoFicha.CIRCULO)) {
            nodo.setUtilidad(estadoTablero.calcularUtilidad(jugador));
            return;
        }

        Ficha.TipoFicha siguienteJugador;
        if (turnoComputadora) {
            siguienteJugador = jugador;
        } else {
            if (jugador == Ficha.TipoFicha.CRUZ) {
                siguienteJugador = Ficha.TipoFicha.CIRCULO;
            } else {
                siguienteJugador = Ficha.TipoFicha.CRUZ;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tablero copia = estadoTablero.copiar();
                if (copia.colocarFicha(i, j, jugador)) {
                    Nodo<T> hijo = new Nodo<>((T) copia);
                    nodo.agregarHijo(hijo);
                    minimax(hijo, siguienteJugador, !turnoComputadora);
                }
            }
        }

        int mejorUtilidad;
        if (turnoComputadora) {
            mejorUtilidad = Integer.MIN_VALUE;
        } else {
            mejorUtilidad = Integer.MAX_VALUE;
        }

        for (Nodo<T> hijo : nodo.getHijos()) {
            if (turnoComputadora) {
                mejorUtilidad = Math.max(mejorUtilidad, hijo.getUtilidad());
            } else {
                mejorUtilidad = Math.min(mejorUtilidad, hijo.getUtilidad());
            }
        }
        nodo.setUtilidad(mejorUtilidad);
    }

    public Tablero obtenerMejorMovimiento(Tablero tablero, Ficha.TipoFicha ia) {
        construirArbol((T) tablero, ia, tablero);

        Nodo<T> raiz = getRaiz();
        Nodo<T> mejorHijo = null;
        int mejorUtilidad = Integer.MIN_VALUE;

        //esto era para ver por consola
        //System.out.println("Evaluando movimientos posibles:");
        //System.out.println("Utilidad > 0: Ventaja para la IA, < 0: Ventaja para el jugador, 0: Empate.");

        for (Nodo<T> hijo : raiz.getHijos()) {
           // System.out.println("Movimiento con utilidad: " + hijo.getUtilidad());
            if (hijo.getUtilidad() > mejorUtilidad) {
                mejorUtilidad = hijo.getUtilidad();
                mejorHijo = hijo;
            }
        }

        if (mejorHijo != null) {
            return (Tablero) mejorHijo.getEstado();
        } else {
            return tablero;
        }
    }
}
