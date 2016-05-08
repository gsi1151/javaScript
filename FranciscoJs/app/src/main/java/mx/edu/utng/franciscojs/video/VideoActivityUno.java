package mx.edu.utng.franciscojs.video;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import mx.edu.utng.franciscojs.R;


public class VideoActivityUno extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_uno);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r5---sn-q4f7snss.googlevideo.com/Cj0LENy73wIaNAl8oiEhN0U5vBMYDSANFC2yKSJXMOCoAUIASARg-p-xxtOh7oZXigELdzMyTzRuaDVmeE0M/7ECB47D23FE8572D1BBCF3DD1E6C90454590388E.0A34B3280449A3568A905C328610F1130369222E/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}