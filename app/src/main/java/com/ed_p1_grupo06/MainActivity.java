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
Button jugar, salir, jugvsbot, jugvsjug, botvsbot,volver,salajugvsbot,regresoSelc, salajugvsjug, regresoSelc2;
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
        jugar.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cafe));
        salir.setBackgroundTintList(ContextCompat.getColorStateList(this,R.color.cafe));


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

        jugvsbot.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cafe_claro));
        jugvsjug.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cafe_claro));
        botvsbot.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cafe_claro));
        volver.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cafe_oscuro));

        jugvsbot.setOnClickListener(s -> cargarMenuEscogerJugVsBot());
        jugvsjug.setOnClickListener(s -> cargarMenuEscogerJugvsJug());
        botvsbot.setOnClickListener(s -> setContentView(R.layout.menu_escogerbotvsbot));
        volver.setOnClickListener(s -> cargarMenuPrincipal());
    }

    //Menu principal
    private void cargarMenuPrincipal() {
        setContentView(R.layout.menu_principal);
        jugar = (Button) findViewById(R.id.ButtonJugar);
        salir = (Button) findViewById(R.id.ButtonSalir);

        jugar.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cafe));
        salir.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cafe));

        // Reasignar listeners
        jugar.setOnClickListener(v -> cargarMenuSeleccion());
        salir.setOnClickListener(v -> finishAffinity());
    }

    //Jugador vs Bot
    private void cargarMenuEscogerJugVsBot() {
        setContentView(R.layout.menu_escogerjugvsbot);
        salajugvsbot = (Button) findViewById(R.id.IngresoSala);
        regresoSelc = (Button) findViewById(R.id.RegresoSeleccion);

        salajugvsbot.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cafe));
        regresoSelc.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cafe_oscuro));
        salajugvsbot.setOnClickListener(v -> cargarSalajugvsbot());
        regresoSelc.setOnClickListener(v -> cargarMenuSeleccion());

    }

    private void cargarSalajugvsbot(){
        setContentView(R.layout.salajugvsbot);
    }

    private void cargarMenuEscogerJugvsJug(){
        setContentView(R.layout.menu_escogerjugvsjug);
        salajugvsjug = (Button) findViewById(R.id.IngresoSala2);
        regresoSelc2 = (Button) findViewById(R.id.RegresoSeleccion2);

        salajugvsjug.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cafe));
        regresoSelc2.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.cafe_oscuro));

        regresoSelc2.setOnClickListener(v -> cargarMenuSeleccion());

    }
}