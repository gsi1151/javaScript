package mx.edu.utng.franciscojs.juegos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mx.edu.utng.franciscojs.JuegoNumero;
import mx.edu.utng.franciscojs.R;
import mx.edu.utng.franciscojs.Rocas;

public class MenusJuegosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus_juegos);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenusJuegosActivity.this, Buscaminas.class));
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenusJuegosActivity.this, MainMenuActivity.class));
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenusJuegosActivity.this, Rocas.class));
            }
        });
        findViewById(R.id.button_tres).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenusJuegosActivity.this, JuegoNumero.class));
            }
        });
       // findViewById(R.id.button_tres).setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
             //   startActivity(new Intent(MenusJuegosActivity.this, mx.edu.utng.franciscojs.gato.TresEnRaya.class));
            //}
        //});

    }
}
