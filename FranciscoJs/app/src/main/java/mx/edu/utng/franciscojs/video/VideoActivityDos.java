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
public class VideoActivityDos extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_dos);

        VideoView videoView = (VideoView) findViewById(R.id.videoViewdos);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r9---sn-q4f7sne6.googlevideo.com/Cj0LENy73wIaNAnJ-m8f9DshmBMYDSANFC2FJipXMOCoAUIASARg7qOYnYPQlJRXigELc2lNVHRPTGs2Zk0M/4C5EC4E93DB3AD6412EA57D57BA100A0A714A345.C0CFF00F697C8EF19FDFC979B78959B7F26A5E89/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}
