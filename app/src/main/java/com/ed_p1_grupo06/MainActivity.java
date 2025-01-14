package com.ed_p1_grupo06;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button jugar, salir, jugvsbot, jugvsjug, botvsbot,volver,salajugvsbot,regresoSelc;
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
        jugar.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.brownish_gray));
        salir.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.brownish_gray));


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

        jugvsbot.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.brownish_gray));
        jugvsjug.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.brownish_gray));
        botvsbot.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.brownish_gray));
        volver.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.brownish_gray));

        jugvsbot.setOnClickListener(s -> cargarMenuEscogerJugVsBot());
        jugvsjug.setOnClickListener(s -> setContentView(R.layout.menu_escogerjugvsjug));
        botvsbot.setOnClickListener(s -> setContentView(R.layout.menu_escogerbotvsbot));
        volver.setOnClickListener(s -> cargarMenuPrincipal());
    }

    //Menu principal
    private void cargarMenuPrincipal() {
        setContentView(R.layout.menu_principal);
        jugar = (Button) findViewById(R.id.ButtonJugar);
        salir = (Button) findViewById(R.id.ButtonSalir);

        jugar.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.brownish_gray));
        salir.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.brownish_gray));

        // Reasignar listeners
        jugar.setOnClickListener(v -> cargarMenuSeleccion());
        salir.setOnClickListener(v -> finishAffinity());
    }

    //Jugador vs Bot
    private void cargarMenuEscogerJugVsBot() {
        setContentView(R.layout.menu_escogerjugvsbot);
        salajugvsbot = (Button) findViewById(R.id.IngresoSala);
        regresoSelc = (Button) findViewById(R.id.RegresoSeleccion);

        regresoSelc.setOnClickListener(v -> cargarMenuSeleccion());

    }
}