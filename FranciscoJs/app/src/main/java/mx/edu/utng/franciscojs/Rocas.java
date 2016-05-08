package mx.edu.utng.franciscojs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Rocas extends AppCompatActivity {
    Button btn_papel, btn_roca,btn_tuj;
    ImageView iv_cpu,iv_me;

    String miChoise, cpuChoise,result;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_cpu=(ImageView)findViewById(R.id.iv_cpu);
        iv_me=(ImageView)findViewById(R.id.iv_me);




        btn_roca=(Button)findViewById(R.id.btn_unoR);
        btn_papel=(Button)findViewById(R.id.btn_dosP);
        btn_tuj=(Button)findViewById(R.id.btn_TresT);


        r= new Random();



        btn_roca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miChoise="rock";
                iv_me.setImageResource(R.drawable.rock);
                calculate();

            }
        });
        btn_papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                miChoise="papel";
                iv_me.setImageResource(R.drawable.papel);
                calculate();
            }
        });

        btn_tuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                miChoise="Tijeras";
                iv_me.setImageResource(R.drawable.tijera);
                calculate();
            }
        });
    }
    public void calculate(){
        int cpu=r.nextInt(3);
        if (cpu==0){
            cpuChoise="rock";
            iv_cpu.setImageResource(R.drawable.rock);

        }else if (cpu==1){
            cpuChoise="papel";
            iv_cpu.setImageResource(R.drawable.papel);
        }else if (cpu==2){
            cpuChoise="Tijeras";
            iv_cpu.setImageResource(R.drawable.tijera);
        }
        if (miChoise.equals("rock") && cpuChoise.equals("papel")){

            result="you lose";
        }else
        if (miChoise.equals("rock") && cpuChoise.equals("Tijeras")){

            result="you win";
        }else

        if (miChoise.equals("papel") && cpuChoise.equals("rock")){

            result="you win";
        }else
        if (miChoise.equals("papel") && cpuChoise.equals("Tijeras")){

            result="you lose";
        }else



        if (miChoise.equals("Tijeras") && cpuChoise.equals("papel")){

            result="you win";
        }else
        if (miChoise.equals("Tijeras") && cpuChoise.equals("rock")){

            result="you lose";
        }else

        if (miChoise.equals("Tijeras") && cpuChoise.equals("Tijeras")){

            result="draw";
        }else


        if (miChoise.equals("rock") && cpuChoise.equals("rock")){

            result="you lose";
        }else

        if (miChoise.equals("papel") && cpuChoise.equals("papel")){

            result="you lose";
        }

        Toast.makeText(Rocas.this,result,Toast.LENGTH_SHORT).show();

    }
}
