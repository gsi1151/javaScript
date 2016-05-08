package mx.edu.utng.franciscojs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.franciscojs.acerca.AcercaDeScrollingActivity;
import mx.edu.utng.franciscojs.activity.ModuloCinco;
import mx.edu.utng.franciscojs.activity.ModuloCuatro;
import mx.edu.utng.franciscojs.activity.ModuloDos;
import mx.edu.utng.franciscojs.activity.ModuloTres;
import mx.edu.utng.franciscojs.activity.ModuloUno;
import mx.edu.utng.franciscojs.answers.practicas.PracticasCodigo;

//import mx.edu.utng.franciscojs.pdfgrafics.CreatePDFActivity;
//import mx.edu.utng.franciscojs.pdfgrafics.GrapicsActivity;


//import android.support.v7.app.AppCompatActivity;

/**
 * Created by LUISITO on 21/02/2016.
 */
public class TemarioActivity extends Activity implements View.OnClickListener {

    DatabaseHelperPoints helperPoints= new DatabaseHelperPoints(this);
    DatabaseHelper helper = new DatabaseHelper(this);

    private Button btnPracticas;


	private Button btnModulouno;
    private Button btnModuloDos;
    private Button btnModuloTres;
    private Button btnModulocuatro;
    private Button btnModulocinco;
    private Button btnProgreso;

    private Button btnSettings;
    private Button btnScrolling;
    private Button btnGames;
    private Button btnTeme;
    private TextView porcentaje;
    private Button btnJuego;
    private Button btnUtilerias;

	public MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temario);

        btnPracticas = (Button) findViewById(R.id.btn_practicas);
        btnPracticas.setOnClickListener(this);

        btnUtilerias = (Button) findViewById(R.id.btn_utilerias);
        btnUtilerias.setOnClickListener(this);

        btnModulouno = (Button) findViewById(R.id.btn_modulo_uno);
        btnModulouno.setOnClickListener(this);

        btnModuloDos = (Button) findViewById(R.id.btn_modulo_dos);
        btnModuloDos.setOnClickListener(this);

        btnModuloTres = (Button) findViewById(R.id.btn_modulo_tres);
        btnModuloTres.setOnClickListener(this);

        btnModulocuatro = (Button) findViewById(R.id.btn_modulo_cuatro);
        btnModulocuatro.setOnClickListener(this);

        btnModulocinco = (Button) findViewById(R.id.btn_modulo_cinco);
        btnModulocinco.setOnClickListener(this);

        btnProgreso = (Button) findViewById(R.id.btn_progress);
        btnProgreso.setOnClickListener(this);


        btnSettings = (Button) findViewById(R.id.btn_settings);
        btnSettings.setOnClickListener(this);

        btnScrolling = (Button) findViewById(R.id.btn_scroll);
        btnScrolling.setOnClickListener(this);



        btnJuego = (Button) findViewById(R.id.btn_juego);
        btnJuego.setOnClickListener(this);

        btnTeme = (Button) findViewById(R.id.btn_tema);
        btnTeme.setOnClickListener(this);

        porcentaje = (TextView) findViewById(R.id.txv_porcentaje);

        int po = helperPoints.porsentajeCurso();
        porcentaje.setText("Tienes un " + po + "0% de avance");

        //CAMBIAR DE TEMA
        ScrollView temario = (ScrollView) findViewById(R.id.ScrollView01);
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
        String name = helper.traerNombre();
        int block=helperPoints.bloqueo();
        switch (v.getId()) {
            case R.id.btn_modulo_uno:
                play_mp();
		        startActivity(new Intent(this, ModuloUno.class));
                break;
            case R.id.btn_modulo_dos:
                if(block>=2&&name!=""){
                    play_mp();
                    Intent i= new Intent(this, ModuloDos.class);
                    startActivity(i);
                }else {
                    if (block >= 2 && name == "") {
                        new AlertDialog.Builder(this)
                                .setTitle("JPA (Java Persisten API)")
                                .setMessage("Necesitas registrate para continuar")
                                .setNegativeButton(R.string.cancel, null)
                                .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(TemarioActivity.this, SignUp.class);
                                        startActivity(intent);
                                    }
                                }).show();
                    } else {
                        Toast temp = Toast.makeText(TemarioActivity.this, "Bloqueado", Toast.LENGTH_LONG);
                        temp.show();
                    }
                }
                break;
            case R.id.btn_modulo_tres:

                if(block>=3&&name!=""){
                    play_mp();
                    Intent i= new Intent(this, ModuloTres.class);
                    startActivity(i);
                }else {
                if (block >= 3 && name == "") {
                    new AlertDialog.Builder(this)
                            .setTitle("JPA (Java Persisten API)")
                            .setMessage("Necesitas registrate para continuar")
                            .setNegativeButton(R.string.cancel, null)
                            .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(TemarioActivity.this, SignUp.class);
                                    startActivity(intent);
                                }
                            }).show();
                } else {
                    Toast temp = Toast.makeText(TemarioActivity.this, "Bloqueado", Toast.LENGTH_LONG);
                    temp.show();
                }
            }

                break;
            case R.id.btn_modulo_cuatro:
                if(block>=4&&name!=""){
                    play_mp();
                    Intent i= new Intent(this, ModuloCuatro.class);
                    startActivity(i);
                }else {
                    if (block >= 4 && name == "") {
                        new AlertDialog.Builder(this)
                                .setTitle("JPA (Java Persisten API)")
                                .setMessage("Necesitas registrate para continuar")
                                .setNegativeButton(R.string.cancel, null)
                                .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(TemarioActivity.this, SignUp.class);
                                        startActivity(intent);
                                    }
                                }).show();
                    } else {
                        Toast temp = Toast.makeText(TemarioActivity.this, "Bloqueado", Toast.LENGTH_LONG);
                        temp.show();
                    }
                }

                break;
            case R.id.btn_modulo_cinco:
                if(block>=5&&name!=""){
                    play_mp();
                    Intent i= new Intent(this, ModuloCinco.class);
                    startActivity(i);
                }else {
                    if (block >= 5 && name == "") {
                        new AlertDialog.Builder(this)
                                .setTitle("JPA (Java Persisten API)")
                                .setMessage("Necesitas registrate para continuar")
                                .setNegativeButton(R.string.cancel, null)
                                .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(TemarioActivity.this, SignUp.class);
                                        startActivity(intent);
                                    }
                                }).show();
                    } else {
                        Toast temp = Toast.makeText(TemarioActivity.this, "Bloqueado", Toast.LENGTH_LONG);
                        temp.show();
                    }
                }

                break;

            case R.id.btn_settings:
                play_mp();
                startActivity(new Intent(this, SettingsActivity.class));
                break;
            case R.id.btn_scroll:
                play_mp();
                startActivity(new Intent(this, AcercaDeScrollingActivity.class));
                break;
          case R.id.btn_tema:
                play_mp();
                startActivity(new Intent(this, TemeActivity.class));
                break;

            case R.id.btn_juego:
                play_mp();
                startActivity(new Intent(this, JuegoNumero.class));
                break;

            case R.id.btn_utilerias:
                play_mp();
                startActivity(new Intent(this, Utilerias.class));
                break;

            case R.id.btn_practicas:
                 Intent i = new Intent(this, PracticasCodigo.class);
                startActivity(i);
                break;

        }
    }
    private void play_mp() {
    // TODO Auto-generated method stub
    mp= MediaPlayer.create(this, R.raw.clic);
    mp.start();
    }
}

