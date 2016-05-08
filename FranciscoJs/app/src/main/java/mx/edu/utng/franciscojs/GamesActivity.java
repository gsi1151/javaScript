package mx.edu.utng.franciscojs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import mx.edu.utng.franciscojs.estrategia.Manager;
import mx.edu.utng.franciscojs.galeria.GaleryJs;
import mx.edu.utng.franciscojs.galeria.GaleryUTNG;

//import mx.edu.utng.FranciscoJs.estrategia.Manager;
//import mx.edu.utng.jpajavaluis.galeria.GaleryJs;
//import mx.edu.utng.jpajavaluis.galeria.GaleryUTNG;

/**
 * Created by LUISITO on 22/04/2016.
 */
public class GamesActivity extends AppCompatActivity implements View.OnClickListener{

    public Button btnPalabra, btnMemo,
                  btngalery,btnutng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_activity);

        btnMemo=(Button)findViewById(R.id.btn_memo);
        btnMemo.setOnClickListener(this);

        btnPalabra=(Button)findViewById(R.id.btn_formar);
        btnPalabra.setOnClickListener(this);

        btngalery=(Button)findViewById(R.id.btn_galery_jpa);
        btngalery.setOnClickListener(this);

        btnutng=(Button)findViewById(R.id.btn_galery_utng);
        btnutng.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_memo:
                Intent intent = new Intent(GamesActivity.this, Manager.class);
                startActivity(intent);
                break;
            case R.id.btn_formar:
                intent = new Intent(GamesActivity.this, PreguntaEjemplo.class);
                startActivity(intent);
                break;
            case R.id.btn_galery_jpa:
                intent = new Intent(GamesActivity.this, GaleryJs.class);
                startActivity(intent);
                break;
            case R.id.btn_galery_utng:
                intent = new Intent(GamesActivity.this, GaleryUTNG.class);
                startActivity(intent);
                break;

        }
    }
}
