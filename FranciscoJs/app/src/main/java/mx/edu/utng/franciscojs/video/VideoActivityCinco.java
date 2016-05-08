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
public class VideoActivityCinco extends Activity {
    private VideoView videoView;
    private MediaController mController;
    private Uri uriYouTube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_primarykey);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r12---sn-q4fl6nee.googlevideo.com/Cj0LENy73wIaNAl3KpAK7Qgw9xMYDSANFC1HKipXMOCoAUIASARg7qOYnYPQlJRXigELc2lNVHRPTGs2Zk0M/85AAA28B08E10C8DE165AD2E7DD5C0B0D995C2F5.B3E1114B43B2025EEA09869D2132434F797B5C91/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}