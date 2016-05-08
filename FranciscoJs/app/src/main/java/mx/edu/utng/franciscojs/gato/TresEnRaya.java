package mx.edu.utng.franciscojs.gato;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import mx.edu.utng.franciscojs.R;


public class TresEnRaya extends Activity {

    private TextView jugar;
    private TextView confi;
    private TextView acercade;
    private TextView salir;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_gato);

        TextView texto = (TextView) findViewById(R.id.titulo);
        Animation animacion = AnimationUtils.loadAnimation(this,R.anim.girozoom);
        texto.startAnimation(animacion);



        Button config = (Button) findViewById(R.id.acercaDe);
        Animation animacion3 = AnimationUtils.loadAnimation(this, R.anim.desplazarderecha);
        config.startAnimation(animacion3);

        Button acercade = (Button) findViewById(R.id.salir);
        Animation animacion4 = AnimationUtils.loadAnimation(this,R.anim.aparecer);
        acercade.startAnimation(animacion4);


    }

    public void pulsaSalir(View view){

        finish();
    }


    public void pulsaJugar(View view){

        Intent i = new Intent(this, Juego.class);
        startActivity(i);
    }

    public void pulsaJugarCpu(View view){

        Intent i = new Intent(this, JuegoCpu.class);
        startActivity(i);
    }

    public void pulsaAcercaDe(View view){

        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }
}
