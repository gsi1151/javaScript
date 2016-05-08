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
public class VideoActivityCuatro extends Activity {
    private VideoView videoView;
    private MediaController mController;
    private Uri uriYouTube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_uno);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri = Uri.parse("rtsp://r3---sn-q4f7sn7d.googlevideo.com/Cj0LENy73wIaNAkKveCQVlpV7RMYDSANFC3eKSpXMOCoAUIASARg7qOYnYPQlJRXigELc2lNVHRPTGs2Zk0M/8BBA6D84AEE8786D71297CDE945592EC6D3422E6.176167150A794F7734351194DBCE31D4E49F4C93/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

    }
}