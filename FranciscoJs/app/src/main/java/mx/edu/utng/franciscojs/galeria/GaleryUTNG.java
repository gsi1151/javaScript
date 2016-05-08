package mx.edu.utng.franciscojs.galeria;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import mx.edu.utng.franciscojs.R;


/**
 * Created by LUISITO on 24/04/2016.
 */
public class GaleryUTNG extends AppCompatActivity implements View.OnClickListener{



    public Button btnAnterior, btnSiguiente;
    public ImageView imagen;
    int [] fotoId={
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9
    };
    int i=0;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.galery_activity);

        btnAnterior = (Button) findViewById(R.id.btn_anterior);
        btnAnterior.setOnClickListener(this);

        imagen=(ImageView)findViewById(R.id.img_cambiante);
        btnSiguiente = (Button) findViewById(R.id.btn_siguiente);
        btnSiguiente.setOnClickListener(this);

        total=fotoId.length;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.btn_anterior){
            i++;
            if(i==total)i=0;
        }
        if(id==R.id.btn_siguiente){
            i++;
            if(i==total)i=total-1;
        }
        imagen.setImageResource(fotoId[i]);
    }
}

