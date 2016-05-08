package mx.edu.utng.franciscojs;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


/**
 * Created by luisito on 17/04/2016.
 */
public class Mail extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail_activity);
    }

    public void onClick(View v) {

        DatabaseHelper login= new DatabaseHelper(this);
        String email=login.traerEmail();

        // Reemplazamos el email
        String[] to = { email, email };
        String[] cc = { email };

        DatabaseHelperPoints helper= new DatabaseHelperPoints(this);
        int po=helper.porsentajeCurso();
        int res= helper.traerResult(1);
        int resII= helper.traerResult(2);
        int resIII= helper.traerResult(3);
        int resIV= helper.traerResult(4);
        int resV= helper.traerResult(5);


        enviar(to, cc, "Resultados de JavaScript ",
                "Esto es un email enviado desde una app de JavaScript.\n\n" +
                        "Calif Quiz I: " + res +
                        "\nCalif Quiz II: " + resII +
                        "\nCalif Quiz III: " + resIII +
                        "\nCalif Quiz IV: " + resIV +
                        "\nCalif Quiz V: " + resV +
                        "\nTu promedio final es de " + po + "."+
                        "\nFelicidades"
        );
    }

    private void enviar(String[] to, String[] cc,
                        String asunto, String mensaje) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        // String[] to = direccionesEmail;
        //String[] cc = copias;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
        System.exit(0);
    }
}