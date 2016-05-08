package mx.edu.utng.franciscojs.gato;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import mx.edu.utng.franciscojs.R;


public class Juego extends Activity{

    private TextView x1;
    private TextView x2;
    private TextView x3;
    private TextView x4;
    private TextView x5;
    private TextView x6;
    private TextView x7;
    private TextView x8;
    private TextView x9;
    private String casilla1=new String("-1");
    private String casilla2=new String("-1");
    private String casilla3=new String("-1");
    private String casilla4=new String("-1");
    private String casilla5=new String("-1");
    private String casilla6=new String("-1");
    private String casilla7=new String("-1");
    private String casilla8=new String("-1");
    private String casilla9=new String("-1");
    private String mensaje;
    private String titulo;
    private String aceptar;

    private TextView xborrar;
    private int jugador=0;
    private MediaPlayer mp;
    private TextView ventanaFin;
    private String Textofinal;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.extra);

        this.x1 = (TextView) findViewById(R.id.x1);
        this.x2 = (TextView) findViewById(R.id.x2);
        this.x3 = (TextView) findViewById(R.id.x3);
        this.x4 = (TextView) findViewById(R.id.x4);
        this.x5 = (TextView) findViewById(R.id.x5);
        this.x6 = (TextView) findViewById(R.id.x6);
        this.x7 = (TextView) findViewById(R.id.x7);
        this.x8 = (TextView) findViewById(R.id.x8);
        this.x9 = (TextView) findViewById(R.id.x9);
        this.xborrar = (TextView) findViewById(R.id.xborrar);
        this.ventanaFin= (TextView) findViewById(R.id.juegoFin);


    }

    public void pulsax1(View view){

        mp.start();

        if(this.jugador==0 && view.isClickable()){
            this.casilla1="X";
            this.x1.setBackgroundResource(R.drawable.cruz);
            view.setClickable(false);

            int fin= this.juegoAcabado();
            if(fin!=-1){

                if(fin==0){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Crosses";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan las Cruces";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=1;

        }
        else if (this.jugador==1 && view.isClickable()){
            this.casilla1="0";
            this.x1.setBackgroundResource(R.drawable.circulo);
            view.setClickable(false);
            int fin= this.juegoAcabado();

            if(fin!=-1){
                if(fin==1){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Circles";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan los Circulos";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=0;

        }
    }

    public void pulsax2(View view){

        mp.start();

        if(this.jugador==0 && view.isClickable()){
            this.casilla2="X";
            this.x2.setBackgroundResource(R.drawable.cruz);
            view.setClickable(false);

            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==0){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Crosses";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan las Cruces";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=1;

        }
        else if (view.isClickable()){
            this.casilla2="0";
            this.x2.setBackgroundResource(R.drawable.circulo);
            view.setClickable(false);
            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==1){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Circles";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan los Circulos";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=0;

        }

    }
    public void pulsax3(View view){

        mp.start();

        if(this.jugador==0 && view.isClickable()){
            this.casilla3="X";
            this.x3.setBackgroundResource(R.drawable.cruz);
            view.setClickable(false);

            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==0){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Crosses";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan las Cruces";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=1;

        }
        else if (view.isClickable()){
            this.casilla3="0";
            this.x3.setBackgroundResource(R.drawable.circulo);
            view.setClickable(false);
            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==1){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Circles";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan los Circulos";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=0;

        }

    }
    public void pulsax4(View view){

        mp.start();

        if(this.jugador==0 && view.isClickable()){
            this.casilla4="X";
            this.x4.setBackgroundResource(R.drawable.cruz);
            view.setClickable(false);

            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==0){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Crosses";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan las Cruces";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=1;

        }
        else if (view.isClickable()){
            this.casilla4="0";
            this.x4.setBackgroundResource(R.drawable.circulo);
            view.setClickable(false);
            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==1){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Circles";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan los Circulos";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=0;

        }


    }
    public void pulsax5(View view){

        mp.start();

        if(this.jugador==0 && view.isClickable()){
            this.casilla5="X";
            this.x5.setBackgroundResource(R.drawable.cruz);
            view.setClickable(false);

            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==0){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Crosses";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan las Cruces";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=1;

        }
        else if (view.isClickable()){
            this.casilla5="0";
            this.x5.setBackgroundResource(R.drawable.circulo);
            view.setClickable(false);
            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==1){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Circles";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan los Circulos";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=0;

        }


    }
    public void pulsax6(View view){

        mp.start();

        if(this.jugador==0 && view.isClickable()){
            this.casilla6="X";
            this.x6.setBackgroundResource(R.drawable.cruz);
            view.setClickable(false);

            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==0){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Crosses";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan las Cruces";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=1;

        }
        else if (view.isClickable()){
            this.casilla6="0";
            this.x6.setBackgroundResource(R.drawable.circulo);
            view.setClickable(false);
            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==1){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Circles";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan los Circulos";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=0;

        }


    }
    public void pulsax7(View view){

        mp.start();

        if(this.jugador==0 && view.isClickable()){
            this.casilla7="X";
            this.x7.setBackgroundResource(R.drawable.cruz);
            view.setClickable(false);

            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==0){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Crosses";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan las Cruces";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=1;

        }
        else if (view.isClickable()){
            this.casilla7="0";
            this.x7.setBackgroundResource(R.drawable.circulo);
            view.setClickable(false);
            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==1){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Circles";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan los Circulos";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=0;

        }


    }
    public void pulsax8(View view){

        mp.start();

        if(this.jugador==0 && view.isClickable()){
            this.casilla8="X";
            this.x8.setBackgroundResource(R.drawable.cruz);
            view.setClickable(false);

            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==0){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Crosses";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan las Cruces";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=1;

        }
        else if (view.isClickable()){
            this.casilla8="0";
            this.x8.setBackgroundResource(R.drawable.circulo);
            view.setClickable(false);
            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==1){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Circles";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan los Circulos";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=0;

        }


    }
    public void pulsax9(View view){

        mp.start();

        if(this.jugador==0 && view.isClickable()){
            this.casilla9="X";
            this.x9.setBackgroundResource(R.drawable.cruz);
            view.setClickable(false);

            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==0){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Crosses";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan las Cruces";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=1;

        }
        else if (view.isClickable()){
            this.casilla9="0";
            this.x9.setBackgroundResource(R.drawable.circulo);
            view.setClickable(false);
            int fin= this.juegoAcabado();
            if(fin!=-1){
                if(fin==1){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="Win Circles";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Ganan los Circulos";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

                else if(fin==2){

                    if (this.ventanaFin.getText().equals("EN")){
                        mensaje="They tied";
                        titulo="Game Over";
                        aceptar="Accept";
                    }
                    else if(this.ventanaFin.getText().equals("ES")){
                        mensaje="Han Empatado";
                        titulo="Juego Acabado";
                        aceptar="Aceptar";
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage(mensaje)
                            .setTitle(titulo)
                            .setCancelable(false)
                            .setNeutralButton(aceptar,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                    AlertDialog alert = builder.create();
                    alert.show();

                }

            }
            this.jugador=0;

        }


    }
    public void pulsaxborrar(View view){

        mp.start();

        this.casilla1="-1";
        this.x1.setBackgroundResource(R.drawable.casilla_vacia);
        this.x1.setClickable(true);

        this.casilla2="-1";
        this.x2.setBackgroundResource(R.drawable.casilla_vacia);
        this.x2.setClickable(true);

        this.casilla3="-1";
        this.x3.setBackgroundResource(R.drawable.casilla_vacia);
        this.x3.setClickable(true);

        this.casilla4="-1";
        this.x4.setBackgroundResource(R.drawable.casilla_vacia);
        this.x4.setClickable(true);

        this.casilla5="-1";
        this.x5.setBackgroundResource(R.drawable.casilla_vacia);
        this.x5.setClickable(true);

        this.casilla6="-1";
        this.x6.setBackgroundResource(R.drawable.casilla_vacia);
        this.x6.setClickable(true);

        this.casilla7="-1";
        this.x7.setBackgroundResource(R.drawable.casilla_vacia);
        this.x7.setClickable(true);

        this.casilla8="-1";
        this.x8.setBackgroundResource(R.drawable.casilla_vacia);
        this.x8.setClickable(true);

        this.casilla9="-1";
        this.x9.setBackgroundResource(R.drawable.casilla_vacia);
        this.x9.setClickable(true);

        this.jugador=0;

    }

    public void fin(){


        this.x1.setClickable(false);

        this.x2.setClickable(false);

        this.x3.setClickable(false);

        this.x4.setClickable(false);

        this.x5.setClickable(false);

        this.x6.setClickable(false);

        this.x7.setClickable(false);

        this.x8.setClickable(false);

        this.x9.setClickable(false);


    }

    public int juegoAcabado(){

		 /* Diagonales */
        if(!this.x1.isClickable() && !this.x5.isClickable()  && !this.x9.isClickable()
                && this.casilla1.equals(this.casilla5) && this.casilla1.equals(this.casilla9)){
            this.fin();
            return jugador;
        }
        if(!this.x3.isClickable() && !this.x5.isClickable()  && !this.x7.isClickable()
                && this.casilla3.equals(this.casilla5)&& this.casilla3.equals(this.casilla7)){

            this.fin();
            return jugador;
        }

		/* Horizontales */
        if(!this.x1.isClickable() && !this.x2.isClickable()  && !this.x3.isClickable()
                && this.casilla1.equals(this.casilla2) && this.casilla1.equals(this.casilla3)){

            this.fin();
            return jugador;
        }

        if(!this.x4.isClickable() && !this.x5.isClickable()  && !this.x6.isClickable()
                && this.casilla4.equals(this.casilla5) && this.casilla4.equals(this.casilla6)){

            this.fin();
            return jugador;
        }

        if(!this.x7.isClickable() && !this.x8.isClickable()  && !this.x9.isClickable()
                && this.casilla7.equals(this.casilla8) && this.casilla7.equals(this.casilla9)){

            this.fin();
            return jugador;
        }

			/* Verticales */

        if(!this.x1.isClickable() && !this.x4.isClickable()  && !this.x7.isClickable()
                && this.casilla1.equals(this.casilla4) && this.casilla1.equals(this.casilla7)){

            this.fin();
            return jugador;
        }

        if(!this.x2.isClickable() && !this.x5.isClickable()  && !this.x8.isClickable()
                && this.casilla2.equals(this.casilla5) && this.casilla2.equals(this.casilla8)){

            this.fin();
            return jugador;
        }

        if(!this.x3.isClickable() && !this.x6.isClickable()  && !this.x9.isClickable()
                && this.casilla3.equals(this.casilla6) && this.casilla3.equals(this.casilla9)){

            this.fin();
            return jugador;
        }

        if(!this.x1.isClickable() && !this.x3.isClickable()  && !this.x3.isClickable()
                && !this.x4.isClickable() && !this.x5.isClickable()  && !this.x6.isClickable()
                && !this.x7.isClickable() && !this.x8.isClickable()  && !this.x9.isClickable() ){

            this.fin();
            return 2;//empate
        }

        return -1;//continua el juego

    }

    @Override
    public void onResume() {
        if(mp == null){
            mp = MediaPlayer.create(getBaseContext(), R.raw.click_casilla);
        }

        super.onResume();
    }

    @Override
    public void onStop() {
        mp.release();
        mp = null;

        super.onStop();
    }

}



