package com.ed_p1_grupo06;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {
    Button jugar, salir, jugvsbot, jugvsjug, botvsbot,volver,salajugvsbot,regresoSelc, salajugvsjug, regresoSelc2, salabotvsbot, regresoSelec3;
    String modoDeJuego;
    Jugador jugador1, jugador2;  // Jugadores humanos
    Bot bot1, bot2;  // Bots

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Seccion menu_principal
        jugar = (Button) findViewById(R.id.ButtonJugar);
        salir = (Button) findViewById(R.id.ButtonSalir);

        jugar.setOnClickListener(v -> cargarMenuSeleccion());
        salir.setOnClickListener(v -> finishAffinity());
    }

    //Pantalla de carga
    private void cargarMenuSeleccion(){
        setContentView(R.layout.menu_seleccion);
        jugvsbot = (Button) findViewById(R.id.escenario1);
        jugvsjug = (Button) findViewById(R.id.escenario2);
        botvsbot = (Button) findViewById(R.id.escenario3);
        volver = (Button) findViewById(R.id.escenario4);

        jugvsbot.setOnClickListener(s -> {
            modoDeJuego = "Jugador vs Bot";
            cargarMenuEscoger();
        });
        jugvsjug.setOnClickListener(s -> {
            modoDeJuego = "Jugador vs Jugador";
            cargarMenuEscoger();
        });
        botvsbot.setOnClickListener(s -> {
            modoDeJuego = "Bot vs Bot";
            cargarMenuEscoger();
        });
        volver.setOnClickListener(s -> cargarMenuPrincipal());
    }

    //Menu principal
    private void cargarMenuPrincipal() {
        setContentView(R.layout.menu_principal);
        jugar = (Button) findViewById(R.id.ButtonJugar);
        salir = (Button) findViewById(R.id.ButtonSalir);

        // Reasignar listeners
        jugar.setOnClickListener(v -> cargarMenuSeleccion());
        salir.setOnClickListener(v -> finishAffinity());
    }

    //Jugador vs Bot
    private void cargarMenuEscoger() {
        setContentView(R.layout.menu_escoger);
        salajugvsbot = (Button) findViewById(R.id.IngresoSala3);
        regresoSelc = (Button) findViewById(R.id.RegresoSeleccion3);

        RadioGroup grupoFichas = findViewById(R.id.radioGroup);
        RadioButton radioX = findViewById(R.id.radioButton4);
        RadioButton radioO = findViewById(R.id.radioButton6);

        salajugvsbot.setOnClickListener(v -> {
            int seleccionado = grupoFichas.getCheckedRadioButtonId();
            if (modoDeJuego.equals("Jugador vs Bot")) {
                if (seleccionado == radioX.getId()) {
                    jugador1 = new Jugador("Jugador 1", Ficha.TipoFicha.CRUZ);
                    bot1 = new Bot("Bot 1", Ficha.TipoFicha.CIRCULO);
                } else if (seleccionado == radioO.getId()) {
                    jugador1 = new Jugador("Jugador 1", Ficha.TipoFicha.CIRCULO);
                    bot1 = new Bot("Bot 1", Ficha.TipoFicha.CRUZ);
                } else {
                    Toast.makeText(this, "Por favor selecciona una ficha", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(this, "Jugador: " + jugador1.getFicha() + ", Bot: " + bot1.getFicha(), Toast.LENGTH_SHORT).show();

            } else if (modoDeJuego.equals("Jugador vs Jugador")) {
                if (seleccionado == radioX.getId()) {
                    jugador1 = new Jugador("Jugador 1", Ficha.TipoFicha.CRUZ);
                    jugador2 = new Jugador("Jugador 2", Ficha.TipoFicha.CIRCULO);
                } else if (seleccionado == radioO.getId()) {
                    jugador1 = new Jugador("Jugador 1", Ficha.TipoFicha.CIRCULO);
                    jugador2 = new Jugador("Jugador 2", Ficha.TipoFicha.CRUZ);
                } else {
                    Toast.makeText(this, "Por favor selecciona una ficha", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(this, "Jugador 1: " + jugador1.getFicha() + ", Jugador 2: " + jugador2.getFicha(), Toast.LENGTH_SHORT).show();

            } else if (modoDeJuego.equals("Bot vs Bot")) {
                bot1 = new Bot("Bot 1", Ficha.TipoFicha.CRUZ);
                bot2 = new Bot("Bot 2", Ficha.TipoFicha.CIRCULO);
                Toast.makeText(this, "Bot 1: X, Bot 2: O", Toast.LENGTH_SHORT).show();
            }

            cargarTablero();
        });
        regresoSelc.setOnClickListener(v -> cargarMenuSeleccion());

    }

    //Cargar Tablero
    private void cargarTablero() {
        setContentView(R.layout.tablero);

        switch (modoDeJuego) {
            case "Jugador vs Bot":
                jugarJugadorVsBot();
                break;

            case "Jugador vs Jugador":
                jugarJugadorVsJugador();
                break;

            case "Bot vs Bot":
                jugarBotVsBot();
                break;
        }
    }

    private void jugarJugadorVsBot() {

    }

    private void jugarBotVsBot() {

    }

    private void jugarJugadorVsJugador() {
        Tablero tablero = new Tablero();
        final Ficha.TipoFicha[] turnoActual = {jugador1.getFicha()};

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                int finalFila = fila, finalColumna = columna;
                Button boton = findViewById(getResources().getIdentifier(
                        "button_" + fila + "_" + columna, "id", getPackageName()
                ));

                boton.setOnClickListener(v -> {
                    if (tablero.colocarFicha(finalFila, finalColumna, turnoActual[0])) {
                        boton.setText(turnoActual[0] == Ficha.TipoFicha.CRUZ ? "X" : "O");

                        if (tablero.verificarGanador(turnoActual[0])) {
                            Toast.makeText(this, "¡" + (turnoActual[0] == jugador1.getFicha() ? "Jugador 1" : "Jugador 2") + " gana!", Toast.LENGTH_SHORT).show();
                            return;
                        } else if (tablero.estaLleno()) {
                            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        turnoActual[0] = (turnoActual[0] == jugador1.getFicha()) ? jugador2.getFicha() : jugador1.getFicha();
                    }
                });
            }
        }
    }

    private void actualizarTablero(Tablero actual, Tablero nuevo) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (actual.getCasillas()[i][j].getTipo() != nuevo.getCasillas()[i][j].getTipo()) {
                    actual.colocarFicha(i, j, nuevo.getCasillas()[i][j].getTipo());
                    int finalI = i, finalJ = j;
                    int finalI1 = i, finalJ1 = j;
                    runOnUiThread(() -> {
                        Button boton = findViewById(getResources().getIdentifier(
                                "button_" + finalI + "_" + finalJ, "id", getPackageName()
                        ));
                        boton.setText(nuevo.getCasillas()[finalI1][finalJ1].getTipo() == Ficha.TipoFicha.CRUZ ? "X" : "O");
                    });
                }
            }
        }
    }
}