package mx.edu.utng.franciscojs.answers.quizCinco;

/**
 * Created by H on 7/12/2015.
 */


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import mx.edu.utng.franciscojs.DatabaseHelperPoints;
import mx.edu.utng.franciscojs.R;
import mx.edu.utng.franciscojs.TemarioActivity;
import mx.edu.utng.franciscojs.answers.Question;


public class QuestionJsCin extends Activity {
    DatabaseHelperPoints helper = new DatabaseHelperPoints(this);
    List<Question> quesList;
    int score = 0;
    int qid = 0;


    Question currentQ;
    TextView txtQuestion, times, scored;
    Button button1, button2, button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answers);

        QuizJsCin db = new QuizJsCin(this);  // Mi clase de banco de preguntas
        quesList = db.getAllQuestions(); // Esto obtendrá todas las preguntas
        currentQ = quesList.get(qid); // La pregunta actual

        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        // El TextView en la que se mostrará la pregunta

        // Los tres botones,
        // La idea es establecer el texto de tres botones con las opciones de banco de preguntas
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        // Se mostrará la Vista de Texto en el que la puntuación
        scored = (TextView) findViewById(R.id.score);

        // El temporizador
        times = (TextView) findViewById(R.id.timers);


        // Método que fijará las cosas a nuestro juego
        setQuestionView();
        times.setText("00:02:00");

        // Un temporizador de 60 segundos para jugar, con un intervalo de 1 segundo
        CounterClass timer = new CounterClass(60000, 1000);
        timer.start();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pasa el texto del botón a otro método
                // Comprobar si el anser es correcta o no
                // Misma para los tres botones
                getAnswer(button1.getText().toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button2.getText().toString());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button3.getText().toString());
            }
        });
    }

    public void getAnswer(String AnswerString) {
        if (currentQ.getANSWER().equals(AnswerString)) {
            // Si las condiciones partidos aumentan la int (puntuación) por 1
            // Y establecer el texto de la visualización de partitura
            score = score+2;
            helper.actualizarQuiz(score,5);
            helper.actualizarBloqueo(6);
        } else {

            // Si la actividad desafortunado comienzo y terminar el juego
            Intent intent = new Intent(QuestionJsCin.this,
                    TemarioActivity.class);

            // pasando el valor entero
            helper.actualizarQuiz(score, 5);
            helper.actualizarBloqueo(6);
            startActivity(intent);
            System.exit(0);
        }
        if (qid < 3) {
            // Si las preguntas no han terminado luego hacer esto
            currentQ = quesList.get(qid);
            setQuestionView();
        } else {
            // Si es más de hacer esto
            Intent intent = new Intent(QuestionJsCin.this,
                    TemarioActivity.class);
            helper.actualizarQuiz(score,5);
            helper.actualizarBloqueo(6);
            startActivity(intent);
            System.exit(0);
        }


    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }


        @Override
        public void onFinish() {
            times.setText("Tu tiempo termino!!!!");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

            long millis = millisUntilFinished;
            String hms = String.format(
                    "%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));
            System.out.println(hms);
            times.setText(hms);
        }


    }

    private void setQuestionView() {
        // El método que pondrá todas las cosas juntas
        txtQuestion.setText(currentQ.getQUESTION());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());
        qid++;
    }


}
