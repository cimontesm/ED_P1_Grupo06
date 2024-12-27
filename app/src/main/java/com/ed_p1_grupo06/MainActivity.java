package com.ed_p1_grupo06;

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
        jugar = (Button) findViewById(R.id.ID_button);
        salir = (Button) findViewById(R.id.button3);

        jugar.setOnClickListener(v ->{
            setContentView(R.layout.menu_seleccion);
        });

        salir.setOnClickListener(v ->{
            finishAffinity();
        });
    }
}