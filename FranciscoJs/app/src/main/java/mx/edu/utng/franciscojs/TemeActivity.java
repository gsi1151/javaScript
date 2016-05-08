package mx.edu.utng.franciscojs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TemeActivity extends Activity implements View.OnClickListener{

    DatabaseHelperPoints helperPoints = new DatabaseHelperPoints(this);
    Button tema1;
    Button tema2;
    Button tema3;
    Button tema4;
    Button tema5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema);

        tema1=(Button)findViewById(R.id.btn_font_one);
        tema1.setOnClickListener(this);

        tema2=(Button)findViewById(R.id.btn_font_two);
        tema2.setOnClickListener(this);

        tema3=(Button)findViewById(R.id.btn_font_three);
        tema3.setOnClickListener(this);

        tema4=(Button)findViewById(R.id.btn_font_four);
        tema4.setOnClickListener(this);

        tema5=(Button)findViewById(R.id.btn_font_five);
        tema5.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_font_one:
                helperPoints.actualizarTema(1);
                startActivity(new Intent(this, TemarioActivity.class));
                System.exit(0);
                break;
            case R.id.btn_font_two:
                helperPoints.actualizarTema(2);
                startActivity(new Intent(this, TemarioActivity.class));
                System.exit(0);
                break;
            case R.id.btn_font_three:
                helperPoints.actualizarTema(3);
                startActivity(new Intent(this, TemarioActivity.class));
                System.exit(0);
                break;
            case R.id.btn_font_four:
                helperPoints.actualizarTema(4);
                startActivity(new Intent(this, TemarioActivity.class));
                System.exit(0);
                break;

            case R.id.btn_font_five:
                helperPoints.actualizarTema(5);
                startActivity(new Intent(this, TemarioActivity.class));
                System.exit(0);
                break;
        }
    }
}
