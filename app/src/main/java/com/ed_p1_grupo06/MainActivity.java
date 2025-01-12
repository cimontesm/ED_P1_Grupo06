package com.ed_p1_grupo06;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button salir;
    Button jugar;
    Button jvb;
    Button jvj;
    Button salir1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        jugar = (Button) findViewById(R.id.ButtonJugar);
        salir = (Button) findViewById(R.id.ButtonSalir);

        jugar.setOnClickListener(v ->{
            setContentView(R.layout.menu_seleccion);
            jvb = findViewById(R.id.JGB);
            jvj = findViewById(R.id.JGJG);
            salir1 = findViewById(R.id.button4);
        });

        jvb.setOnClickListener(v ->{

        });

        salir1.setOnClickListener(v ->{
            finishAffinity();
        });

        salir.setOnClickListener(v ->{
            finishAffinity();
        });

    }
}