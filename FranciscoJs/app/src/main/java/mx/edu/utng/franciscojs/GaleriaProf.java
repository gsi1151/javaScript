package mx.edu.utng.franciscojs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GaleriaProf extends AppCompatActivity implements View.OnClickListener {


    DatabaseHelperPoints helperPoints= new DatabaseHelperPoints(this);

    ImageView foto;
    TextView tv;

    int[]fotoId = {R.drawable.estuno,R.drawable.estdos,R.drawable.esttres,R.drawable.estcuatro,R.drawable.estcinco,R.drawable.estseis,
    R.drawable.estsiete,R.drawable.estocho,R.drawable.estnueve,R.drawable.estdies};
    String[]texto={"texto foto1","texto foto2","texto foto3","texto foto4","texto foto5","texto foto6","texto foto7","texto foto8",
            "texto foto9","texto foto10"};

    int i=0;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria_prof);


        Button Siguiente=(Button) findViewById(R.id.button1);
        Button Anterior=(Button)findViewById(R.id.button2);
        Siguiente.setOnClickListener(this);
        Anterior.setOnClickListener(this);

        foto =(ImageView)findViewById(R.id.imageView1);
        tv=(TextView)findViewById(R.id.textView1);
        total=fotoId.length;


        RelativeLayout temario=(RelativeLayout)findViewById(R.id.ScrollView01);
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
        int id=v.getId();

        if (id ==R.id.button1){
            i--;
            if (i== -1){
                i= total -1;
            }
        }
        if (id==R.id.button2){
            i++;
            if (i==total){
                i=0;
            }
        }
        foto.setImageResource(fotoId[i]);
        tv.setText(texto[i]);
    }
}
