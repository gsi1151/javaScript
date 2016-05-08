package mx.edu.utng.franciscojs;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by luisito on 01/03/2016.
 */
public class MusicaActivity extends Activity implements View.OnClickListener {

    private MediaPlayer mp;
    private Button btnStart;
    private Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musica_layout);
        mp = MediaPlayer.create ( this, R.raw.introjpa );
        intiComponets();
    }

    private void intiComponets(){
        btnStart=(Button)findViewById(R.id.btn_start);
        btnStop=(Button)findViewById(R.id.btn_stop);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            }
        });
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.btn_stop){
            mp.pause();
        }
    }
}
