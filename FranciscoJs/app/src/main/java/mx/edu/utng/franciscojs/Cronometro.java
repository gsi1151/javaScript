package mx.edu.utng.franciscojs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;

public class Cronometro extends Activity {
    Button contar,pausar;
    Chronometer crono;
    long Time=0;

    Button btnSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronome);
        btnSiguiente=(Button)findViewById(R.id.btn_calculadora);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent siguiente= new Intent(Cronometro.this,Calculadora.class);
                startActivity(siguiente);
            }
        });


        crono =(Chronometer)findViewById(R.id.cronometro);
        contar = (Button)findViewById(R.id.btn_contar);
        pausar=(Button)findViewById(R.id.btn_pausar);

        contar.setEnabled(true);
        pausar.setEnabled(false);

        contar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contar.setEnabled(false);
                pausar.setEnabled(true);
                crono.setBase(SystemClock.elapsedRealtime());
                crono.start();
            }
        });
        pausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contar.setEnabled(true);
                pausar.setEnabled(false);
                crono.stop();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
