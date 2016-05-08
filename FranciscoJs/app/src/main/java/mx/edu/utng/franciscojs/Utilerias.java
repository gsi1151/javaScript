package mx.edu.utng.franciscojs;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import mx.edu.utng.franciscojs.juegos.MenusJuegosActivity;


public class Utilerias extends Activity implements View.OnClickListener {


    DatabaseHelperPoints helperPoints= new DatabaseHelperPoints(this);



private Button btnGaleriaUtng;
    private Button btnNotificaciones;

private  Button btnGaleria;
    private Button btnJuego;
    private Button btnCronometro;
    private Button btnUbicacion;
    private Button btnUtileria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilerias);






        btnUbicacion=(Button)findViewById(R.id.btn_ubicacion);
        btnUbicacion.setOnClickListener(this);


        btnNotificaciones=(Button)findViewById(R.id.btn_notificacion);
        btnNotificaciones.setOnClickListener(this);


        btnGaleriaUtng=(Button)findViewById(R.id.btn_galeria_dos_utng);
        btnGaleriaUtng.setOnClickListener(this);


        btnJuego=(Button)findViewById(R.id.btn_juego);
        btnJuego.setOnClickListener(this);

        btnGaleria=(Button)findViewById(R.id.btn_galeria);
        btnGaleria.setOnClickListener(this);




        btnUtileria=(Button)findViewById(R.id.btn_utileria_doss);
        btnUtileria.setOnClickListener(this);


        btnUbicacion = (Button) findViewById(R.id.btn_canvas);
        btnUbicacion.setOnClickListener(this);

        btnCronometro = (Button) findViewById(R.id.btn_cronometro);
        btnCronometro.setOnClickListener(this);


        LinearLayout temario=(LinearLayout)findViewById(R.id.ScrollView01);
        int tema = helperPoints.tema();
        if (tema == 1) {
            temario.setBackgroundResource(R.drawable.fondo1);
        } else {
            if (tema == 2) {
                temario.setBackgroundResource(R.drawable.fondo2);
            } else {
                if (tema == 3) {
                    temario.setBackgroundResource(R.drawable.fondo3);
                } else {
                    if (tema == 4) {
                        temario.setBackgroundResource(R.drawable.fondo4);
                    }
                }
            }
        }





    }






    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_cronometro:
                startActivity(new Intent(this, Cronometro.class));
                break;

                case R.id.btn_canvas:
                    startActivity(new Intent(this, DibujarImage.class));
                    break;

            case R.id.btn_utileria_doss:
                startActivity(new Intent(this, Galeria.class));
            break;
            case R.id.btn_juego:
                startActivity(new Intent(this, MenusJuegosActivity.class));
                break;


            case R.id.btn_galeria:
                startActivity(new Intent(this, GaleriaProf.class));
                break;

            case R.id.btn_galeria_dos_utng:
                startActivity(new Intent(this, GaleriaUtng.class));
                break;


            case R.id.btn_notificacion:
                startActivity(new Intent(this, Notificacion.class));
                break;

            case R.id.btn_ubicacion:
                startActivity(new Intent(this, Map.class));
                break;


        }
    }
}