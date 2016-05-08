package mx.edu.utng.franciscojs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StartActivity extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);

        //Vamos a declarar un nuevo thread
        Thread timer = new Thread(){
            //El nuevo Thread exige el metodo run
            public void run(){
                try{
                    sleep(5000);
                }catch(InterruptedException e){
                    //Si no puedo ejecutar el sleep muestro el error
                    e.printStackTrace();
                }finally{
                    String name= helper.traerNombre();
                    if (name == "") {
                        Intent actividaPrincipal = new Intent(StartActivity.this, LoginActivity.class);
                        startActivity(actividaPrincipal);
                        System.exit(0);
                    }else {
                        Intent actividaPrincipal = new Intent(StartActivity.this, TemarioActivity.class);
                        startActivity(actividaPrincipal);
                        System.exit(0);
                    }
                }
            }
        };
        timer.start();
    }
}
