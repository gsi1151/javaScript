package mx.edu.utng.franciscojs.video;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import mx.edu.utng.franciscojs.R;


/**
 * Created by LUISITO on 06/04/2016.
 */
public class VideoActivityTres extends Activity {
    private VideoView videoView;
    private MediaController mController;
    private Uri uriYouTube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_relation);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r1---sn-q4fl6ne7.googlevideo.com/Cj0LENy73wIaNAlnizVvwpR2fhMYDSANFC0oKCpXMOCoAUIASARg7qOYnYPQlJRXigELc2lNVHRPTGs2Zk0M/0822AC62952489ED01A010DF4CBD1709148F11D2.489F1612CC0E2AC6807C6DE95236268975556BA8/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}