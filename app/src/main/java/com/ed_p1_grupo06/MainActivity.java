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
        jugar.setOnClickListener(v ->{
            //Seccion menu_seleccion
            setContentView(R.layout.menu_seleccion);
            jugvsbot = (Button) findViewById(R.id.escenario1);
            jugvsjug = (Button) findViewById(R.id.escenario2);
            botvsbot = (Button) findViewById(R.id.escenario3);
            volver = (Button) findViewById(R.id.escenario4);

            //jugvsbot
            jugvsbot.setOnClickListener(s ->{
                setContentView(R.layout.menu_escogerjugvsbot);
                //Ir a sala del juego
                salajugvsbot = (Button) findViewById(R.id.IngresoSala);
                salajugvsbot.setOnClickListener(u ->{
                    setContentView(R.layout.salajugvsbot);
                });
                //Regreso al menú de selección
                regresoSelc = (Button) findViewById(R.id.RegresoSeleccion);
                regresoSelc.setOnClickListener(u ->{
                    setContentView(R.layout.menu_seleccion);
                });
            });
            //jugvsjug
            jugvsjug.setOnClickListener(s ->{
                setContentView(R.layout.menu_escogerjugvsjug);
            });
            //botvsbot
            botvsbot.setOnClickListener(s ->{
                setContentView(R.layout.menu_escogerbotvsbot);
            });
            //volver
            volver.setOnClickListener(s ->{
                setContentView(R.layout.menu_principal);
            });
        });
        salir.setOnClickListener(v ->{
            finishAffinity();
        });

    }
}