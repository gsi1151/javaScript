package mx.edu.utng.franciscojs;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Notificacion extends AppCompatActivity {

    public static final int NOTIFICACION_ID=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);


    }

    public void onClick(View vie){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com/index.html"));
        PendingIntent pendingIntent =PendingIntent.getActivity(this,0,intent,0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_stat_notification);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
        builder.setContentTitle("Notificaciòn");
        builder.setContentText("Momento para aprender mas sobre android");
        builder.setSubText("Toca para ver la documentaciòn acerca de android");


        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICACION_ID,builder.build());


    }
}
