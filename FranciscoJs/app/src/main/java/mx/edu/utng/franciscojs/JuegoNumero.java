package mx.edu.utng.franciscojs;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class JuegoNumero extends Activity {


    private EditText numero;
    private Button jugar,reiniciar;
    private TextView mensaje;
    private int aleatorio;
    private int intentos=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego_numero);
         numero=(EditText) findViewById(R.id.txt_numero);
        jugar=(Button)findViewById(R.id.btn_jugar);
        reiniciar=(Button)findViewById(R.id.btn_reiniciar);
        mensaje=(TextView)findViewById(R.id.lbl_mensaje);
        reiniciar.setEnabled(false);
        aleatorio=generarAleatorio();
        //mensaje.setText(aleatorio+"");
        jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numeroUsuario;
                numeroUsuario=Integer.parseInt(numero.getText().toString());
                if (aleatorio==numeroUsuario){
                    mensaje.setText("HAS GANADO");
                }
                else
                {
                    intentos=intentos-1;
                }
                if (intentos==0){
                    reiniciar.setEnabled(true);
                    jugar.setEnabled(false);
                    mensaje.setText("HAS PERDIDO");
                }

            }
        });
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentos=3;
                reiniciar.setEnabled(false);
                mensaje.setText("");
                numero.setText("");
                aleatorio=generarAleatorio();
                jugar.setEnabled(true);
            }
        });
    }

    private int generarAleatorio() {
        return (int)(Math.random()*10+1);
    }
}
