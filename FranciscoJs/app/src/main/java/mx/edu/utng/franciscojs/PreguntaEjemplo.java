package mx.edu.utng.franciscojs;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class PreguntaEjemplo extends Activity implements View.OnClickListener {

    DatabaseHelper helper = new DatabaseHelper(this);
    private TextView caja1,txvAnswer;
    private Button caja2, caja3, caja4,
                   caja5, caja6, caja7,
                   caja8, caja9, caja10,
                   caja11,caja12;

    private String cadena1, cadena2, cadena3,
                   cadena4, cadena5, cadena6,
                   cadena7, cadena8, cadena9,
                   cadena10, cadena11, cadena12;

    private int cont=1, contCuest=3,cambio=0;

    private String cadBtn1, cadBtn2, cadBtn3, cadBtn4,
                   cadBtn5, cadBtn6, cadBtn7, cadBtn8,
                   cadBtn9, cadBtn10, cadBtn11, cadBtn12,
                   cadBtn13, cadBtn14;
    private String mostrar;
    private Button btn1, btn2, btn3, btn4, btn5, btn6,
                   btn7, btn8, btn9, btn10, btn11,
                   btn12, btn13, btn14;

    private ImageButton btnEnviar;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fm_cuestionario_ejemplo);
        btnEnviar = (ImageButton) findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(this);


        SQLiteDatabase db = helper.getWritableDatabase();
        //Si hemos abierto correctamente la base de datos
        if (db != null) {
            //Insertamos los datos en la tabla Usuarios
            db.execSQL(getString(R.string.str_insert_answer_1));
            db.execSQL(getString(R.string.str_insert_answer_2));
            db.execSQL(getString(R.string.str_insert_answer_3));
            db.execSQL(getString(R.string.str_insert_answer_4));
            //Cerramos la base de datos
            db.close();
        }

        DatabaseHelperPoints helperPoints= new DatabaseHelperPoints(this);
        ScrollView temario=(ScrollView)findViewById(R.id.ScrollView01);
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

        caja1 = (TextView)findViewById(R.id.resultado);
        txvAnswer=(TextView)findViewById(R.id.txv_answer);

        caja2 = (Button)findViewById(R.id.caja2);
        caja2.setOnClickListener(this);

        caja3 = (Button)findViewById(R.id.caja3);
        caja3.setOnClickListener(this);

        caja4 = (Button)findViewById(R.id.caja4);
        caja4.setOnClickListener(this);

        caja5 = (Button)findViewById(R.id.caja5);
        caja5.setOnClickListener(this);

        caja6 = (Button)findViewById(R.id.caja6);
        caja6.setOnClickListener(this);

        caja7 = (Button)findViewById(R.id.caja7);
        caja7.setOnClickListener(this);

        caja8 = (Button)findViewById(R.id.caja8);
        caja8.setOnClickListener(this);

        caja9 = (Button)findViewById(R.id.caja9);
        caja9.setOnClickListener(this);

        caja10 = (Button)findViewById(R.id.caja10);
        caja10.setOnClickListener(this);

        caja11 = (Button)findViewById(R.id.caja11);
        caja11.setOnClickListener(this);

        caja12 = (Button)findViewById(R.id.caja12);
        caja12.setOnClickListener(this);

        //MOSTRAR CADENA


        //BOTONES DE LAS PREGUNTAS
        btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2=(Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3=(Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4=(Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        btn5=(Button)findViewById(R.id.btn5);
        btn5.setOnClickListener(this);

        btn6=(Button)findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        btn7=(Button)findViewById(R.id.btn7);
        btn7.setOnClickListener(this);

        btn8=(Button)findViewById(R.id.btn8);
        btn8.setOnClickListener(this);

        btn9=(Button)findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

        btn10=(Button)findViewById(R.id.btn10);
        btn10.setOnClickListener(this);

        btn11=(Button)findViewById(R.id.btn11);
        btn11.setOnClickListener(this);

        btn12=(Button)findViewById(R.id.btn12);
        btn12.setOnClickListener(this);

        btn13=(Button)findViewById(R.id.btn13);
        btn13.setOnClickListener(this);

        btn14=(Button)findViewById(R.id.btn14);
        btn14.setOnClickListener(this);
        //BOTON ENVIAR

        btn1.setText("O");
        btn2.setText("O");
        btn3.setText("X");
        btn4.setText("V");
        btn5.setText("E");
        btn6.setText("L");
        btn7.setText("O");
        btn8.setText("E");
        btn9.setText("H");
        btn10.setText("N");
        btn11.setText("A");
        btn12.setText("A");
        btn13.setText("T");
        btn14.setText("N");

        txvAnswer.setText(R.string.str_answer_onetoone);
        }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void onClick(View v) {
            cadena1=caja1.getText().toString();
            cadena2=caja2.getText().toString();
            cadena3=caja3.getText().toString();
            cadena4=caja4.getText().toString();
            cadena5=caja5.getText().toString();
            cadena6=caja6.getText().toString();
            cadena7=caja7.getText().toString();
            cadena8=caja8.getText().toString();
            cadena9=caja9.getText().toString();
            cadena10=caja10.getText().toString();
            cadena11=caja11.getText().toString();
            cadena12=caja12.getText().toString();


            cadBtn1=btn1.getText().toString();
            cadBtn2=btn2.getText().toString();
            cadBtn3=btn3.getText().toString();
            cadBtn4=btn4.getText().toString();
            cadBtn5=btn5.getText().toString();
            cadBtn6=btn6.getText().toString();
            cadBtn7=btn7.getText().toString();
            cadBtn8=btn8.getText().toString();
            cadBtn9=btn9.getText().toString();
            cadBtn10=btn10.getText().toString();
            cadBtn11=btn11.getText().toString();
            cadBtn12=btn12.getText().toString();
            cadBtn13=btn13.getText().toString();
            cadBtn14=btn14.getText().toString();

        mostrar=caja2.getText()+""+caja3.getText()+""+
                caja4.getText()+""+caja5.getText()+""+
                caja6.getText()+""+caja7.getText()+""+
                caja8.getText()+""+caja9.getText()+""+
                caja10.getText()+""+caja11.getText()+""+
                caja12.getText();

            switch (v.getId()){
                case R.id.btn1:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn1.getText());
                        btn1.setText("");
                    }else {
                        if(cadena3.isEmpty()){
                            caja3.setText(btn1.getText());
                            btn1.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn1.getText());
                                btn1.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn1.getText());
                                    btn1.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn1.getText());
                                        btn1.setText("");
                                    }else {
                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn1.getText());
                                            btn1.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn1.getText());
                                                btn1.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn1.getText());
                                                    btn1.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn1.getText());
                                                        btn1.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn1.getText());
                                                            btn1.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn1.getText());
                                                                btn1.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.btn2:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn2.getText());
                        btn2.setText("");
                    }else {
                        if(cadena3.isEmpty()){
                            caja3.setText(btn2.getText());
                            btn2.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn2.getText());
                                btn2.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn2.getText());
                                    btn2.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn2.getText());
                                        btn2.setText("");
                                    }else {

                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn2.getText());
                                            btn2.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn2.getText());
                                                btn2.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn2.getText());
                                                    btn2.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn2.getText());
                                                        btn2.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn2.getText());
                                                            btn2.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn2.getText());
                                                                btn2.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.btn3:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn3.getText());
                        btn3.setText("");
                    }else {
                        if(cadena3.isEmpty()){
                            caja3.setText(btn3.getText());
                            btn3.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn3.getText());
                                btn3.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn3.getText());
                                    btn3.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn3.getText());
                                        btn3.setText("");
                                    }else {
                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn3.getText());
                                            btn3.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn3.getText());
                                                btn3.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn3.getText());
                                                    btn3.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn3.getText());
                                                        btn3.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn3.getText());
                                                            btn3.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn3.getText());
                                                                btn3.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.btn4:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn4.getText());
                        btn4.setText("");
                    }else {
                        if(cadena3.isEmpty()){
                            caja3.setText(btn4.getText());
                            btn4.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn4.getText());
                                btn4.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn4.getText());
                                    btn4.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn4.getText());
                                        btn4.setText("");
                                    }else {
                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn4.getText());
                                            btn4.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn4.getText());
                                                btn4.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn4.getText());
                                                    btn4.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn4.getText());
                                                        btn4.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn4.getText());
                                                            btn4.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn4.getText());
                                                                btn4.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.btn5:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn5.getText());
                        btn5.setText("");
                    }else {
                        if(cadena3.isEmpty()){
                            caja3.setText(btn5.getText());
                            btn5.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn5.getText());
                                btn5.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn5.getText());
                                    btn5.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn5.getText());
                                        btn5.setText("");
                                    }else {
                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn5.getText());
                                            btn5.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn5.getText());
                                                btn5.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn5.getText());
                                                    btn5.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn5.getText());
                                                        btn5.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn5.getText());
                                                            btn5.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn5.getText());
                                                                btn5.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.btn6:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn6.getText());
                        btn6.setText("");
                    }else {
                        if(cadena3.isEmpty()){
                            caja3.setText(btn6.getText());
                            btn6.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn6.getText());
                                btn6.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn6.getText());
                                    btn6.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn6.getText());
                                        btn6.setText("");
                                    }else {

                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn6.getText());
                                            btn6.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn6.getText());
                                                btn6.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn6.getText());
                                                    btn6.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn6.getText());
                                                        btn6.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn6.getText());
                                                            btn6.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn6.getText());
                                                                btn6.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.btn7:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn7.getText());
                        btn7.setText("");
                    }else {

                        if(cadena3.isEmpty()){
                            caja3.setText(btn7.getText());
                            btn7.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn7.getText());
                                btn7.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn7.getText());
                                    btn7.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn7.getText());
                                        btn7.setText("");
                                    }else {

                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn7.getText());
                                            btn7.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn7.getText());
                                                btn7.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn7.getText());
                                                    btn7.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn7.getText());
                                                        btn7.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn7.getText());
                                                            btn7.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn7.getText());
                                                                btn7.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.btn8:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn8.getText());
                        btn8.setText("");
                    }else {

                        if(cadena3.isEmpty()){
                            caja3.setText(btn8.getText());
                            btn8.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn8.getText());
                                btn8.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn8.getText());
                                    btn8.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn8.getText());
                                        btn8.setText("");
                                    }else {

                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn8.getText());
                                            btn8.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn8.getText());
                                                btn8.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn8.getText());
                                                    btn8.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn8.getText());
                                                        btn8.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn8.getText());
                                                            btn8.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn8.getText());
                                                                btn8.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.btn9:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn9.getText());
                        btn9.setText("");
                    }else {
                        if(cadena3.isEmpty()){
                            caja3.setText(btn9.getText());
                            btn9.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn9.getText());
                                btn9.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn9.getText());
                                    btn9.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn9.getText());
                                        btn9.setText("");
                                    }else {

                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn9.getText());
                                            btn9.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn9.getText());
                                                btn9.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn9.getText());
                                                    btn9.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn9.getText());
                                                        btn9.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn9.getText());
                                                            btn9.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn9.getText());
                                                                btn9.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.btn10:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn10.getText());
                        btn10.setText("");
                    }else {

                        if(cadena3.isEmpty()){
                            caja3.setText(btn10.getText());
                            btn10.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn10.getText());
                                btn10.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn10.getText());
                                    btn10.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn10.getText());
                                        btn10.setText("");
                                    }else {

                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn10.getText());
                                            btn10.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn10.getText());
                                                btn10.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn10.getText());
                                                    btn10.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn10.getText());
                                                        btn10.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn10.getText());
                                                            btn10.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn10.getText());
                                                                btn10.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.btn11:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn11.getText());
                        btn11.setText("");
                    }else {
                        if(cadena3.isEmpty()){
                            caja3.setText(btn11.getText());
                            btn11.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn11.getText());
                                btn11.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn11.getText());
                                    btn11.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn11.getText());
                                        btn11.setText("");
                                    }else {
                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn11.getText());
                                            btn11.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn11.getText());
                                                btn11.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn11.getText());
                                                    btn11.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn11.getText());
                                                        btn11.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn11.getText());
                                                            btn11.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn11.getText());
                                                                btn11.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.btn12:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn12.getText());
                        btn12.setText("");
                    }else {
                        if(cadena3.isEmpty()){
                            caja3.setText(btn12.getText());
                            btn12.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn12.getText());
                                btn12.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn12.getText());
                                    btn12.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn12.getText());
                                        btn12.setText("");
                                    }else {

                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn12.getText());
                                            btn12.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn12.getText());
                                                btn12.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn12.getText());
                                                    btn12.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn12.getText());
                                                        btn12.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn12.getText());
                                                            btn12.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn12.getText());
                                                                btn12.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.btn13:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn13.getText());
                        btn13.setText("");
                    }else {

                        if(cadena3.isEmpty()){
                            caja3.setText(btn13.getText());
                            btn13.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn13.getText());
                                btn13.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn13.getText());
                                    btn13.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn13.getText());
                                        btn13.setText("");
                                    }else {

                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn13.getText());
                                            btn13.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn13.getText());
                                                btn13.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn13.getText());
                                                    btn13.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn13.getText());
                                                        btn13.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn13.getText());
                                                            btn13.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn13.getText());
                                                                btn13.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.btn14:
                    if(cadena2.isEmpty()){
                        caja2.setText(btn14.getText());
                        btn14.setText("");
                    }else {

                        if(cadena3.isEmpty()){
                            caja3.setText(btn14.getText());
                            btn14.setText("");
                        }else{
                            if(cadena4.isEmpty()){
                                caja4.setText(btn14.getText());
                                btn14.setText("");
                            }else{
                                if(cadena5.isEmpty()){
                                    caja5.setText(btn14.getText());
                                    btn14.setText("");
                                }else{
                                    if(cadena6.isEmpty()){
                                        caja6.setText(btn14.getText());
                                        btn14.setText("");
                                    }else {

                                        if(cadena7.isEmpty()){
                                            caja7.setText(btn14.getText());
                                            btn14.setText("");
                                        }else{
                                            if(cadena8.isEmpty()){
                                                caja8.setText(btn14.getText());
                                                btn14.setText("");
                                            }else{
                                                if(cadena9.isEmpty()){
                                                    caja9.setText(btn14.getText());
                                                    btn14.setText("");
                                                }else{
                                                    if(cadena10.isEmpty()){
                                                        caja10.setText(btn14.getText());
                                                        btn14.setText("");
                                                    }else {
                                                        if(cadena11.isEmpty()){
                                                            caja11.setText(btn14.getText());
                                                            btn14.setText("");
                                                        }else{
                                                            if(cadena12.isEmpty()){
                                                                caja12.setText(btn14.getText());
                                                                btn14.setText("");
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                //Regresar a botones
                case R.id.caja2:
                    if(cadBtn1.isEmpty()){
                        btn1.setText(caja2.getText());
                        caja2.setText("");
                    }else{
                        if(cadBtn2.isEmpty()){
                            btn2.setText(caja2.getText());
                            caja2.setText("");
                        }else {
                            if(cadBtn3.isEmpty()){
                                btn3.setText(caja2.getText());
                                caja2.setText("");
                            }else{
                                if(cadBtn4.isEmpty()){
                                    btn4.setText(caja2.getText());
                                    caja2.setText("");
                                }else{
                                    if(cadBtn5.isEmpty()){
                                        btn5.setText(caja2.getText());
                                        caja2.setText("");
                                    }else{
                                        if(cadBtn6.isEmpty()){
                                            btn6.setText(caja2.getText());
                                            caja2.setText("");
                                        }else{
                                            if(cadBtn7.isEmpty()){
                                                btn7.setText(caja2.getText());
                                                caja2.setText("");
                                            }else {
                                                if(cadBtn8.isEmpty()){
                                                    btn8.setText(caja2.getText());
                                                    caja2.setText("");
                                                }else{
                                                    if(cadBtn9.isEmpty()){
                                                        btn9.setText(caja2.getText());
                                                        caja2.setText("");
                                                    }else{
                                                        if(cadBtn10.isEmpty()){
                                                            btn10.setText(caja2.getText());
                                                            caja2.setText("");
                                                        }else{
                                                            if(cadBtn11.isEmpty()){
                                                                btn11.setText(caja2.getText());
                                                                caja2.setText("");
                                                            }else{
                                                                if(cadBtn12.isEmpty()){
                                                                    btn12.setText(caja2.getText());
                                                                    caja2.setText("");
                                                                }else {
                                                                    if(cadBtn13.isEmpty()){
                                                                        btn13.setText(caja2.getText());
                                                                        caja2.setText("");
                                                                    }else{
                                                                        if(cadBtn14.isEmpty()){
                                                                            btn14.setText(caja2.getText());
                                                                            caja2.setText("");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.caja3:
                    if(cadBtn1.isEmpty()){
                        btn1.setText(caja3.getText());
                        caja3.setText("");
                    }else{
                        if(cadBtn2.isEmpty()){
                            btn2.setText(caja3.getText());
                            caja3.setText("");
                        }else {
                            if(cadBtn3.isEmpty()){
                                btn3.setText(caja3.getText());
                                caja3.setText("");
                            }else{
                                if(cadBtn4.isEmpty()){
                                    btn4.setText(caja3.getText());
                                    caja3.setText("");
                                }else{
                                    if(cadBtn5.isEmpty()){
                                        btn5.setText(caja3.getText());
                                        caja3.setText("");
                                    }else{
                                        if(cadBtn6.isEmpty()){
                                            btn6.setText(caja3.getText());
                                            caja3.setText("");
                                        }else{
                                            if(cadBtn7.isEmpty()){
                                                btn7.setText(caja3.getText());
                                                caja3.setText("");
                                            }else {
                                                if(cadBtn8.isEmpty()){
                                                    btn8.setText(caja3.getText());
                                                    caja3.setText("");
                                                }else{
                                                    if(cadBtn9.isEmpty()){
                                                        btn9.setText(caja3.getText());
                                                        caja3.setText("");
                                                    }else{
                                                        if(cadBtn10.isEmpty()){
                                                            btn10.setText(caja3.getText());
                                                            caja3.setText("");
                                                        }else{
                                                            if(cadBtn11.isEmpty()){
                                                                btn11.setText(caja3.getText());
                                                                caja3.setText("");
                                                            }else{
                                                                if(cadBtn12.isEmpty()){
                                                                    btn12.setText(caja3.getText());
                                                                    caja3.setText("");
                                                                }else {
                                                                    if(cadBtn13.isEmpty()){
                                                                        btn13.setText(caja3.getText());
                                                                        caja3.setText("");
                                                                    }else{
                                                                        if(cadBtn14.isEmpty()){
                                                                            btn14.setText(caja3.getText());
                                                                            caja3.setText("");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.caja4:
                    if(cadBtn1.isEmpty()){
                        btn1.setText(caja4.getText());
                        caja4.setText("");
                    }else{
                        if(cadBtn2.isEmpty()){
                            btn2.setText(caja4.getText());
                            caja4.setText("");
                        }else {
                            if(cadBtn3.isEmpty()){
                                btn3.setText(caja4.getText());
                                caja4.setText("");
                            }else{
                                if(cadBtn4.isEmpty()){
                                    btn4.setText(caja4.getText());
                                    caja4.setText("");
                                }else{
                                    if(cadBtn5.isEmpty()){
                                        btn5.setText(caja4.getText());
                                        caja4.setText("");
                                    }else{
                                        if(cadBtn6.isEmpty()){
                                            btn6.setText(caja4.getText());
                                            caja4.setText("");
                                        }else{
                                            if(cadBtn7.isEmpty()){
                                                btn7.setText(caja4.getText());
                                                caja4.setText("");
                                            }else {
                                                if(cadBtn8.isEmpty()){
                                                    btn8.setText(caja4.getText());
                                                    caja4.setText("");
                                                }else{
                                                    if(cadBtn9.isEmpty()){
                                                        btn9.setText(caja4.getText());
                                                        caja4.setText("");
                                                    }else{
                                                        if(cadBtn10.isEmpty()){
                                                            btn10.setText(caja4.getText());
                                                            caja4.setText("");
                                                        }else{
                                                            if(cadBtn11.isEmpty()){
                                                                btn11.setText(caja4.getText());
                                                                caja4.setText("");
                                                            }else{
                                                                if(cadBtn12.isEmpty()){
                                                                    btn12.setText(caja4.getText());
                                                                    caja4.setText("");
                                                                }else {
                                                                    if(cadBtn13.isEmpty()){
                                                                        btn13.setText(caja4.getText());
                                                                        caja4.setText("");
                                                                    }else{
                                                                        if(cadBtn14.isEmpty()){
                                                                            btn14.setText(caja4.getText());
                                                                            caja4.setText("");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.caja5:
                    if(cadBtn1.isEmpty()){
                        btn1.setText(caja5.getText());
                        caja5.setText("");
                    }else{
                        if(cadBtn2.isEmpty()){
                            btn2.setText(caja5.getText());
                            caja5.setText("");
                        }else {
                            if(cadBtn3.isEmpty()){
                                btn3.setText(caja5.getText());
                                caja5.setText("");
                            }else{
                                if(cadBtn4.isEmpty()){
                                    btn4.setText(caja5.getText());
                                    caja5.setText("");
                                }else{
                                    if(cadBtn5.isEmpty()){
                                        btn5.setText(caja5.getText());
                                        caja5.setText("");
                                    }else{
                                        if(cadBtn6.isEmpty()){
                                            btn6.setText(caja5.getText());
                                            caja5.setText("");
                                        }else{
                                            if(cadBtn7.isEmpty()){
                                                btn7.setText(caja5.getText());
                                                caja5.setText("");
                                            }else {
                                                if(cadBtn8.isEmpty()){
                                                    btn8.setText(caja5.getText());
                                                    caja5.setText("");
                                                }else{
                                                    if(cadBtn9.isEmpty()){
                                                        btn9.setText(caja5.getText());
                                                        caja5.setText("");
                                                    }else{
                                                        if(cadBtn10.isEmpty()){
                                                            btn10.setText(caja5.getText());
                                                            caja5.setText("");
                                                        }else{
                                                            if(cadBtn11.isEmpty()){
                                                                btn11.setText(caja5.getText());
                                                                caja5.setText("");
                                                            }else{
                                                                if(cadBtn12.isEmpty()){
                                                                    btn12.setText(caja5.getText());
                                                                    caja5.setText("");
                                                                }else {
                                                                    if(cadBtn13.isEmpty()){
                                                                        btn13.setText(caja5.getText());
                                                                        caja5.setText("");
                                                                    }else{
                                                                        if(cadBtn14.isEmpty()){
                                                                            btn14.setText(caja5.getText());
                                                                            caja5.setText("");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.caja6:
                    if(cadBtn1.isEmpty()){
                        btn1.setText(caja6.getText());
                        caja6.setText("");
                    }else{
                        if(cadBtn2.isEmpty()){
                            btn2.setText(caja6.getText());
                            caja6.setText("");
                        }else {
                            if(cadBtn3.isEmpty()){
                                btn3.setText(caja6.getText());
                                caja6.setText("");
                            }else{
                                if(cadBtn4.isEmpty()){
                                    btn4.setText(caja6.getText());
                                    caja6.setText("");
                                }else{
                                    if(cadBtn5.isEmpty()){
                                        btn5.setText(caja6.getText());
                                        caja6.setText("");
                                    }else{
                                        if(cadBtn6.isEmpty()){
                                            btn6.setText(caja6.getText());
                                            caja6.setText("");
                                        }else{
                                            if(cadBtn7.isEmpty()){
                                                btn7.setText(caja6.getText());
                                                caja6.setText("");
                                            }else {
                                                if(cadBtn8.isEmpty()){
                                                    btn8.setText(caja6.getText());
                                                    caja6.setText("");
                                                }else{
                                                    if(cadBtn9.isEmpty()){
                                                        btn9.setText(caja6.getText());
                                                        caja6.setText("");
                                                    }else{
                                                        if(cadBtn10.isEmpty()){
                                                            btn10.setText(caja6.getText());
                                                            caja6.setText("");
                                                        }else{
                                                            if(cadBtn11.isEmpty()){
                                                                btn11.setText(caja6.getText());
                                                                caja6.setText("");
                                                            }else{
                                                                if(cadBtn12.isEmpty()){
                                                                    btn12.setText(caja6.getText());
                                                                    caja6.setText("");
                                                                }else {
                                                                    if(cadBtn13.isEmpty()){
                                                                        btn13.setText(caja6.getText());
                                                                        caja6.setText("");
                                                                    }else{
                                                                        if(cadBtn14.isEmpty()){
                                                                            btn14.setText(caja6.getText());
                                                                            caja6.setText("");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.caja7:
                    if(cadBtn1.isEmpty()){
                        btn1.setText(caja7.getText());
                        caja7.setText("");
                    }else{
                        if(cadBtn2.isEmpty()){
                            btn2.setText(caja7.getText());
                            caja7.setText("");
                        }else {
                            if(cadBtn3.isEmpty()){
                                btn3.setText(caja7.getText());
                                caja7.setText("");
                            }else{
                                if(cadBtn4.isEmpty()){
                                    btn4.setText(caja7.getText());
                                    caja7.setText("");
                                }else{
                                    if(cadBtn5.isEmpty()){
                                        btn5.setText(caja7.getText());
                                        caja7.setText("");
                                    }else{
                                        if(cadBtn6.isEmpty()){
                                            btn6.setText(caja7.getText());
                                            caja7.setText("");
                                        }else{
                                            if(cadBtn7.isEmpty()){
                                                btn7.setText(caja7.getText());
                                                caja7.setText("");
                                            }else {
                                                if(cadBtn8.isEmpty()){
                                                    btn8.setText(caja7.getText());
                                                    caja7.setText("");
                                                }else{
                                                    if(cadBtn9.isEmpty()){
                                                        btn9.setText(caja7.getText());
                                                        caja7.setText("");
                                                    }else{
                                                        if(cadBtn10.isEmpty()){
                                                            btn10.setText(caja7.getText());
                                                            caja7.setText("");
                                                        }else{
                                                            if(cadBtn11.isEmpty()){
                                                                btn11.setText(caja7.getText());
                                                                caja7.setText("");
                                                            }else{
                                                                if(cadBtn12.isEmpty()){
                                                                    btn12.setText(caja7.getText());
                                                                    caja7.setText("");
                                                                }else {
                                                                    if(cadBtn13.isEmpty()){
                                                                        btn13.setText(caja7.getText());
                                                                        caja7.setText("");
                                                                    }else{
                                                                        if(cadBtn14.isEmpty()){
                                                                            btn14.setText(caja7.getText());
                                                                            caja7.setText("");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.caja8:
                    if(cadBtn1.isEmpty()){
                        btn1.setText(caja8.getText());
                        caja8.setText("");
                    }else{
                        if(cadBtn2.isEmpty()){
                            btn2.setText(caja8.getText());
                            caja8.setText("");
                        }else {
                            if(cadBtn3.isEmpty()){
                                btn3.setText(caja8.getText());
                                caja8.setText("");
                            }else{
                                if(cadBtn4.isEmpty()){
                                    btn4.setText(caja8.getText());
                                    caja8.setText("");
                                }else{
                                    if(cadBtn5.isEmpty()){
                                        btn5.setText(caja8.getText());
                                        caja8.setText("");
                                    }else{
                                        if(cadBtn6.isEmpty()){
                                            btn6.setText(caja8.getText());
                                            caja8.setText("");
                                        }else{
                                            if(cadBtn7.isEmpty()){
                                                btn7.setText(caja8.getText());
                                                caja8.setText("");
                                            }else {
                                                if(cadBtn8.isEmpty()){
                                                    btn8.setText(caja8.getText());
                                                    caja8.setText("");
                                                }else{
                                                    if(cadBtn9.isEmpty()){
                                                        btn9.setText(caja8.getText());
                                                        caja8.setText("");
                                                    }else{
                                                        if(cadBtn10.isEmpty()){
                                                            btn10.setText(caja8.getText());
                                                            caja8.setText("");
                                                        }else{
                                                            if(cadBtn11.isEmpty()){
                                                                btn11.setText(caja8.getText());
                                                                caja8.setText("");
                                                            }else{
                                                                if(cadBtn12.isEmpty()){
                                                                    btn12.setText(caja8.getText());
                                                                    caja8.setText("");
                                                                }else {
                                                                    if(cadBtn13.isEmpty()){
                                                                        btn13.setText(caja8.getText());
                                                                        caja8.setText("");
                                                                    }else{
                                                                        if(cadBtn14.isEmpty()){
                                                                            btn14.setText(caja8.getText());
                                                                            caja8.setText("");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.caja9:
                    if(cadBtn1.isEmpty()){
                        btn1.setText(caja9.getText());
                        caja9.setText("");
                    }else{
                        if(cadBtn2.isEmpty()){
                            btn2.setText(caja9.getText());
                            caja9.setText("");
                        }else {
                            if(cadBtn3.isEmpty()){
                                btn3.setText(caja9.getText());
                                caja9.setText("");
                            }else{
                                if(cadBtn4.isEmpty()){
                                    btn4.setText(caja9.getText());
                                    caja9.setText("");
                                }else{
                                    if(cadBtn5.isEmpty()){
                                        btn5.setText(caja9.getText());
                                        caja9.setText("");
                                    }else{
                                        if(cadBtn6.isEmpty()){
                                            btn6.setText(caja9.getText());
                                            caja9.setText("");
                                        }else{
                                            if(cadBtn7.isEmpty()){
                                                btn7.setText(caja9.getText());
                                                caja9.setText("");
                                            }else {
                                                if(cadBtn8.isEmpty()){
                                                    btn8.setText(caja9.getText());
                                                    caja9.setText("");
                                                }else{
                                                    if(cadBtn9.isEmpty()){
                                                        btn9.setText(caja9.getText());
                                                        caja9.setText("");
                                                    }else{
                                                        if(cadBtn10.isEmpty()){
                                                            btn10.setText(caja9.getText());
                                                            caja9.setText("");
                                                        }else{
                                                            if(cadBtn11.isEmpty()){
                                                                btn11.setText(caja9.getText());
                                                                caja9.setText("");
                                                            }else{
                                                                if(cadBtn12.isEmpty()){
                                                                    btn12.setText(caja9.getText());
                                                                    caja9.setText("");
                                                                }else {
                                                                    if(cadBtn13.isEmpty()){
                                                                        btn13.setText(caja9.getText());
                                                                        caja9.setText("");
                                                                    }else{
                                                                        if(cadBtn14.isEmpty()){
                                                                            btn14.setText(caja9.getText());
                                                                            caja9.setText("");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.caja10:
                    if(cadBtn1.isEmpty()){
                        btn1.setText(caja10.getText());
                        caja10.setText("");
                    }else{
                        if(cadBtn2.isEmpty()){
                            btn2.setText(caja10.getText());
                            caja10.setText("");
                        }else {
                            if(cadBtn3.isEmpty()){
                                btn3.setText(caja10.getText());
                                caja10.setText("");
                            }else{
                                if(cadBtn4.isEmpty()){
                                    btn4.setText(caja10.getText());
                                    caja10.setText("");
                                }else{
                                    if(cadBtn5.isEmpty()){
                                        btn5.setText(caja10.getText());
                                        caja10.setText("");
                                    }else{
                                        if(cadBtn6.isEmpty()){
                                            btn6.setText(caja10.getText());
                                            caja10.setText("");
                                        }else{
                                            if(cadBtn7.isEmpty()){
                                                btn7.setText(caja10.getText());
                                                caja10.setText("");
                                            }else {
                                                if(cadBtn8.isEmpty()){
                                                    btn8.setText(caja10.getText());
                                                    caja10.setText("");
                                                }else{
                                                    if(cadBtn9.isEmpty()){
                                                        btn9.setText(caja10.getText());
                                                        caja10.setText("");
                                                    }else{
                                                        if(cadBtn10.isEmpty()){
                                                            btn10.setText(caja10.getText());
                                                            caja10.setText("");
                                                        }else{
                                                            if(cadBtn11.isEmpty()){
                                                                btn11.setText(caja10.getText());
                                                                caja10.setText("");
                                                            }else{
                                                                if(cadBtn12.isEmpty()){
                                                                    btn12.setText(caja10.getText());
                                                                    caja10.setText("");
                                                                }else {
                                                                    if(cadBtn13.isEmpty()){
                                                                        btn13.setText(caja10.getText());
                                                                        caja10.setText("");
                                                                    }else{
                                                                        if(cadBtn14.isEmpty()){
                                                                            btn14.setText(caja10.getText());
                                                                            caja10.setText("");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.caja11:
                    if(cadBtn1.isEmpty()){
                        btn1.setText(caja11.getText());
                        caja11.setText("");
                    }else{
                        if(cadBtn2.isEmpty()){
                            btn2.setText(caja11.getText());
                            caja11.setText("");
                        }else {
                            if(cadBtn3.isEmpty()){
                                btn3.setText(caja11.getText());
                                caja11.setText("");
                            }else{
                                if(cadBtn4.isEmpty()){
                                    btn4.setText(caja11.getText());
                                    caja11.setText("");
                                }else{
                                    if(cadBtn5.isEmpty()){
                                        btn5.setText(caja11.getText());
                                        caja11.setText("");
                                    }else{
                                        if(cadBtn6.isEmpty()){
                                            btn6.setText(caja11.getText());
                                            caja11.setText("");
                                        }else{
                                            if(cadBtn7.isEmpty()){
                                                btn7.setText(caja11.getText());
                                                caja11.setText("");
                                            }else {
                                                if(cadBtn8.isEmpty()){
                                                    btn8.setText(caja11.getText());
                                                    caja11.setText("");
                                                }else{
                                                    if(cadBtn9.isEmpty()){
                                                        btn9.setText(caja11.getText());
                                                        caja11.setText("");
                                                    }else{
                                                        if(cadBtn10.isEmpty()){
                                                            btn10.setText(caja11.getText());
                                                            caja11.setText("");
                                                        }else{
                                                            if(cadBtn11.isEmpty()){
                                                                btn11.setText(caja11.getText());
                                                                caja11.setText("");
                                                            }else{
                                                                if(cadBtn12.isEmpty()){
                                                                    btn12.setText(caja11.getText());
                                                                    caja11.setText("");
                                                                }else {
                                                                    if(cadBtn13.isEmpty()){
                                                                        btn13.setText(caja11.getText());
                                                                        caja11.setText("");
                                                                    }else{
                                                                        if(cadBtn14.isEmpty()){
                                                                            btn14.setText(caja11.getText());
                                                                            caja11.setText("");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case R.id.caja12:
                    if(cadBtn1.isEmpty()){
                        btn1.setText(caja12.getText());
                        caja12.setText("");
                    }else{
                        if(cadBtn2.isEmpty()){
                            btn2.setText(caja12.getText());
                            caja12.setText("");
                        }else {
                            if(cadBtn3.isEmpty()){
                                btn3.setText(caja12.getText());
                                caja12.setText("");
                            }else{
                                if(cadBtn4.isEmpty()){
                                    btn4.setText(caja12.getText());
                                    caja12.setText("");
                                }else{
                                    if(cadBtn5.isEmpty()){
                                        btn5.setText(caja12.getText());
                                        caja12.setText("");
                                    }else{
                                        if(cadBtn6.isEmpty()){
                                            btn6.setText(caja12.getText());
                                            caja12.setText("");
                                        }else{
                                            if(cadBtn7.isEmpty()){
                                                btn7.setText(caja12.getText());
                                                caja12.setText("");
                                            }else {
                                                if(cadBtn8.isEmpty()){
                                                    btn8.setText(caja12.getText());
                                                    caja12.setText("");
                                                }else{
                                                    if(cadBtn9.isEmpty()){
                                                        btn9.setText(caja12.getText());
                                                        caja12.setText("");
                                                    }else{
                                                        if(cadBtn10.isEmpty()){
                                                            btn10.setText(caja12.getText());
                                                            caja12.setText("");
                                                        }else{
                                                            if(cadBtn11.isEmpty()){
                                                                btn11.setText(caja12.getText());
                                                                caja12.setText("");
                                                            }else{
                                                                if(cadBtn12.isEmpty()){
                                                                    btn12.setText(caja12.getText());
                                                                    caja12.setText("");
                                                                }else {
                                                                    if(cadBtn13.isEmpty()){
                                                                        btn13.setText(caja12.getText());
                                                                        caja12.setText("");
                                                                    }else{
                                                                        if(cadBtn14.isEmpty()){
                                                                            btn14.setText(caja12.getText());
                                                                            caja12.setText("");
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
            case R.id.btnEnviar:
                    cont=cont+1;
                    caja1.setText(mostrar);
                    TextView answer = (TextView) findViewById(R.id.txv_answer);
                    String str = answer.getText().toString();

                    TextView result = (TextView) findViewById(R.id.resultado);
                    String res = result.getText().toString();

                    String password = helper.searchResponse(str);
                    if (res.equals(password)) {
                        Toast temp = Toast.makeText(PreguntaEjemplo.this, "Correcto", Toast.LENGTH_SHORT);
                        temp.show();
                        cambio = cambio + 1;
                        mostrarMas(cambio);
                        tamanoCajas(cambio);
                        cambioAnswer(cambio);
                    } else {
                        if (cont <= 3) {
                            if(contCuest==1){
                                contCuest=3;
                            }
                            contCuest=contCuest-1;
                            Toast temp = Toast.makeText(PreguntaEjemplo.this, "Incorrecto te quedan "+contCuest+" intentos", Toast.LENGTH_SHORT);
                            temp.show();

                        } else {
                            Toast temp = Toast.makeText(PreguntaEjemplo.this, "Limite superado", Toast.LENGTH_SHORT);
                            temp.show();
                            cont=1;
                            cambio = cambio + 1;
                            mostrarMas(cambio);
                            tamanoCajas(cambio);
                            cambioAnswer(cambio);
                        }
                    }
        }

    }
    private void tamanoCajas(int a){
        switch (a){
            case 2:
                caja10.getLayoutParams().height = 70;
                caja10.getLayoutParams().width = 40;

                break;
            case 3:
                caja11.getLayoutParams().height = 70;
                caja11.getLayoutParams().width = 40;

                caja12.getLayoutParams().height = 70;
                caja12.getLayoutParams().width = 40;
                break;
            default:
                break;
        }
    }
    private void cambioAnswer(int a){
        switch (a) {
            case 2:
                btn1.setText("N");
                btn2.setText("N");
                btn3.setText("M");
                btn4.setText("F");
                btn5.setText("Y");
                btn6.setText("X");
                btn7.setText("A");
                btn8.setText("O");
                btn9.setText("S");
                btn10.setText("T");
                btn11.setText("E");
                btn12.setText("E");
                btn13.setText("O");
                btn14.setText("M");

                txvAnswer.setText(R.string.str_answer_manytoone);
                limpiar();
                break;
            case 1:
                //12
                txvAnswer.setText(R.string.str_answer_override);
                btn1.setText("M");
                btn2.setText("E");
                btn3.setText("D");
                btn4.setText("G");
                btn5.setText("V");
                btn6.setText("N");
                btn7.setText("I");
                btn8.setText("A");
                btn9.setText("O");
                btn10.setText("X");
                btn11.setText("R");
                btn12.setText("R");
                btn13.setText("I");
                btn14.setText("E");
                limpiar();
                break;
            case 3:
                btn1.setText("L");
                btn2.setText("N");
                btn3.setText("A");
                btn4.setText("B");
                btn5.setText("G");
                btn6.setText("A");
                btn7.setText("E");
                btn8.setText("M");
                btn9.setText("A");
                btn10.setText("N");
                btn11.setText("E");
                btn12.setText("D");
                btn13.setText("O");
                btn14.setText("M");

                txvAnswer.setText(R.string.str_answer_managedbean);
                limpiar();
                Intent i = new Intent(this, TemarioActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
}
    private void limpiar(){

        caja1.setText("");
        caja2.setText("");
        caja3.setText("");
        caja4.setText("");
        caja5.setText("");
        caja6.setText("");
        caja7.setText("");
        caja8.setText("");
        caja9.setText("");
        caja10.setText("");
        caja11.setText("");
        caja12.setText("");
    }
    private void mostrarMas(int a){
        switch (a){
            case 1:
                new AlertDialog.Builder(this)
                        .setTitle("@OneToOne")
                        .setMessage(R.string.str_info_one)
                        .setPositiveButton(R.string.aceptar, null)
                        .show();
                break;
            case 2:
                new AlertDialog.Builder(this)
                        .setTitle("@Override")
                        .setMessage(R.string.str_info_override)
                        .setPositiveButton(R.string.aceptar,null)
                .show();
                break;
            case 3:
                new AlertDialog.Builder(this)
                        .setTitle("@ManyToOne")
                        .setMessage(R.string.str_info_many)
                        .setPositiveButton(R.string.aceptar, null)
                        .show();
                break;
            case 4:
                new AlertDialog.Builder(this)
                        .setTitle("@ManagedBean")
                        .setMessage(R.string.str_info_managedbean)
                        .setPositiveButton(R.string.aceptar,null)
                        .show();
                break;
            default:
                break;
        }
    }
}

