package mx.edu.utng.franciscojs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer sound;

    public Button btnIniciar, btnVista,btnRegistro;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_layout);
        sound = MediaPlayer.create(this,R.raw.ratchetscritch);
        btnIniciar=(Button)findViewById(R.id.btn_iniciar);
        btnIniciar.setOnClickListener(this);

        btnRegistro=(Button)findViewById(R.id.btn_registro);
        btnRegistro.setOnClickListener(this);

        btnVista=(Button)findViewById(R.id.btn_vista);
        btnVista.setOnClickListener(this);
    }

    public void onClick(View view){
        if(view.getId() == R.id.btn_iniciar){
            EditText a = (EditText)findViewById(R.id.edt_usuario);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.edt_clave);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if(pass.equals(password)){
                Intent i = new Intent(LoginActivity.this, TemarioActivity.class);
                i.putExtra("Username",str);
                startActivity(i);

            }else{
                new AlertDialog.Builder(this)
                        .setTitle("Usuario no existe")
                        .setMessage("¿Deseas Registrarte?")
                        .setNegativeButton(R.string.cancel,null)
                        .setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(LoginActivity.this, SignUp.class);
                                startActivity(intent);
                                System.exit(0);
                            }
                        }).show();
                Toast temp = Toast.makeText(LoginActivity.this,"Contrasenia Invalida", Toast.LENGTH_SHORT);
                temp.show();
            }
        }
        if(view.getId() == R.id.btn_registro){
            sound.start();
            Intent i = new Intent(LoginActivity.this, SignUp.class);
            startActivity(i);
        }

        if(view.getId() == R.id.btn_vista){
            sound.start();
            Intent i = new Intent(LoginActivity.this, TemarioActivity.class);
            startActivity(i);
            System.exit(0);
        }
    }
}
