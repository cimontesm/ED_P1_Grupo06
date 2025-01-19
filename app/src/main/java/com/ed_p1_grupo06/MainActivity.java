package com.ed_p1_grupo06;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button jugar, salir, jugvsbot, jugvsjug, botvsbot,volver,salajugvsbot,regresoSelc, salajugvsjug, regresoSelc2, salabotvsbot, regresoSelec3;
    String modoDeJuego;
    Jugador jugador1, jugador2;  // Jugadores humanos
    Bot bot1, bot2;  // Bots
    Button[][] botones = new Button[3][3];
    boolean esTurnoJugador1 = true;  // Indica si es el turno del Jugador 1
    boolean juegoTerminado = false;

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

        salajugvsbot.setOnClickListener(v -> cargarTablero());
        regresoSelc.setOnClickListener(v -> cargarMenuSeleccion());

    }

    //Cargar Tablero
    private void cargarTablero(){
        setContentView(R.layout.tablero);

        // Inicializar los botones del tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String botonId = "button_" + i + "_" + j;
                int resID = getResources().getIdentifier(botonId, "id", getPackageName());
                botones[i][j] = findViewById(resID);
                botones[i][j].setText(""); // Limpiar texto de los botones
                botones[i][j].setEnabled(true); // Habilitar el botón para la jugada
                int finalI = i;
                int finalJ = j;
                botones[i][j].setOnClickListener(v -> realizarJugada(finalI, finalJ));
            }
        }

        switch (modoDeJuego){
            case "Jugador vs Bot":
                jugador1 = new Jugador("Jugador 1");  // Crear jugador
                bot1 = new Bot("Bot 1");  // Crear bot
                break;

            case "Jugador vs Jugador":
                jugador1 = new Jugador("Jugador 1");  // Crear jugador 1
                jugador2 = new Jugador("Jugador 2");  // Crear jugador 2
                break;

            case "Bot vs Bot":
                bot1 = new Bot("Bot 1");  // Crear bot 1
                bot2 = new Bot("Bot 2");  // Crear bot 2
                break;
        }

//        if (modoDeJuego.equals("Bot vs Bot") || modoDeJuego.equals("Jugador vs Bot")) {
//            // Si es "Bot vs Bot" o "Jugador vs Bot", el bot hará su primer movimiento automáticamente
//            if (modoDeJuego.equals("Bot vs Bot")) {
//                jugarBotVsBot();
//            } else {
//                jugarJugadorVsBot();
//            }
//        }
    }

    private void realizarJugada(int i,int j){
        if (juegoTerminado) return;

        Button botonSeleccionado = botones[i][j];
    }

    private void jugarJugadorVsBot(){

    }

    private void jugarBotVsBot(){

    }
}