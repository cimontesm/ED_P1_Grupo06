package com.ed_p1_grupo06;

public class Tablero {

    //tablero estandar de 3x3
    private Ficha[][] casillas;
    private static final int TAMANO = 3;

    //constructor para iniciar el tablero. este se llena de fichas vacias
    public Tablero() {
        casillas = new Ficha[TAMANO][TAMANO];
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                casillas[i][j] = new Ficha(Ficha.TipoFicha.VACIO);
            }
        }
    }

    //este de aqui es para poner la ficha en el lugar. mira si la ficha esta en el rango permitido y que el espacio este vacio
    public boolean colocarFicha(int fila, int columna, Ficha.TipoFicha tipo) {
        if (fila < 0 || fila >= TAMANO || columna < 0 || columna >= TAMANO
                || casillas[fila][columna].getTipo() != Ficha.TipoFicha.VACIO) {
            return false;
        }
        casillas[fila][columna].setTipo(tipo);
        return true;
    }

    //bastante obvio pero este verifica si se tiene el 3 en raya y usa lineaGanadora como ayuda para chequear
    public boolean verificarGanador(Ficha.TipoFicha tipo) {
        for (int i = 0; i < TAMANO; i++) {
            if (esLineaGanadora(casillas[i][0], casillas[i][1], casillas[i][2], tipo)) {
                return true;
            }
            if (esLineaGanadora(casillas[0][i], casillas[1][i], casillas[2][i], tipo)) {
                return true;
            }
        }
        return esLineaGanadora(casillas[0][0], casillas[1][1], casillas[2][2], tipo)
                || esLineaGanadora(casillas[0][2], casillas[1][1], casillas[2][0], tipo);
    }

    private boolean esLineaGanadora(Ficha a, Ficha b, Ficha c, Ficha.TipoFicha tipo) {
        return a.getTipo() == tipo && b.getTipo() == tipo && c.getTipo() == tipo;
    }

    //en ingles isFull() este metodo mira si el tablero esta lleno
    public boolean estaLleno() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (casillas[i][j].getTipo() == Ficha.TipoFicha.VACIO) {
                    return false;
                }
            }
        }
        return true;
    }

    public Ficha[][] getCasillas() {
        return casillas;
    }

    //crea una copia independiente del estado actual del tablero, esto es esencial para el minimax
    public Tablero copiar() {
        Tablero copia = new Tablero();
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                copia.casillas[i][j] = new Ficha(casillas[i][j].getTipo());
            }
        }
        return copia;
    }

    //el calcular utilidad mencionado en el pdf donde calcula la utilidad del tsblero para el jugador
    //Utilidad = P(jugador) - P(oponente)
    //usa el metodo contarLineasDispnibles para ver lo disponible para el jugador
    public int calcularUtilidad(Ficha.TipoFicha jugador) {
        Ficha.TipoFicha oponente;
        if (jugador == Ficha.TipoFicha.CRUZ) {
            oponente = Ficha.TipoFicha.CIRCULO;
        } else {
            oponente = Ficha.TipoFicha.CRUZ;
        }
        int utilidadJugador = contarLineasDisponibles(jugador);
        int utilidadOponente = contarLineasDisponibles(oponente);
        return utilidadJugador - utilidadOponente;
    }

    private int contarLineasDisponibles(Ficha.TipoFicha tipo) {
        int lineas = 0;
        for (int i = 0; i < TAMANO; i++) {
            if (lineaDisponible(casillas[i][0], casillas[i][1], casillas[i][2], tipo)) {
                lineas++;
            }
            if (lineaDisponible(casillas[0][i], casillas[1][i], casillas[2][i], tipo)) {
                lineas++;
            }
        }
        if (lineaDisponible(casillas[0][0], casillas[1][1], casillas[2][2], tipo)) {
            lineas++;
        }
        if (lineaDisponible(casillas[0][2], casillas[1][1], casillas[2][0], tipo)) {
            lineas++;
        }
        return lineas;
    }

    //metodo de apoyo para contar lineas disponibles, aqui verifico q si esten disponibles de verdad, osea q sean vacio
    private boolean lineaDisponible(Ficha a, Ficha b, Ficha c, Ficha.TipoFicha tipo) {
        return (a.getTipo() == tipo || a.getTipo() == Ficha.TipoFicha.VACIO)
                && (b.getTipo() == tipo || b.getTipo() == Ficha.TipoFicha.VACIO)
                && (c.getTipo() == tipo || c.getTipo() == Ficha.TipoFicha.VACIO);
    }
}