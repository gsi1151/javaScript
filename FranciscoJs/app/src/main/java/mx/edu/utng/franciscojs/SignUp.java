package mx.edu.utng.franciscojs;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity implements View.OnClickListener {

    DatabaseHelper helper = new DatabaseHelper(this);

    private Button btnRegresar;
    private MediaPlayer mp;//poner sonido al boton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mp = MediaPlayer.create(this, R.raw.ratchetscritch);
        btnRegresar =(Button)findViewById(R.id.btn_regresar);
        btnRegresar.setOnClickListener(this);
    }



    public void onSignUpClick(View v){
        if(v.getId() == R.id.btn_guardar){
            EditText name =(EditText)findViewById(R.id.edt_name);
            EditText email =(EditText)findViewById(R.id.edt_correo);
            EditText uname =(EditText)findViewById(R.id.edt_usuario);
            EditText pass1 =(EditText)findViewById(R.id.edt_contrasenia1);
            EditText pass2 =(EditText)findViewById(R.id.edt_contrasenia2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str)){
                //mensage
                Toast pass = Toast.makeText(SignUp.this,"Las Contrasenias No Coinciden", Toast.LENGTH_SHORT);
                pass.show();

            }
            else{
                mp.start();
                //insertar datos en la base de datos
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);
                helper.insertContact(c);
                Toast pass = Toast.makeText(SignUp.this,"Datos Guardados", Toast.LENGTH_SHORT);
                pass.show();
                startActivity(new Intent(this, LoginActivity.class));
                System.exit(0);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_regresar:
                mp.start();
                startActivity(new Intent(this, LoginActivity.class));
                System.exit(0);
        }
    }
}
