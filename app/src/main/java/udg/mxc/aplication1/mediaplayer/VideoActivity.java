package udg.mxc.aplication1.mediaplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import udg.mxc.aplication1.R;

public class VideoActivity extends AppCompatActivity {

    @BindView( R.id.videoView ) VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(mVideoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
        mVideoView.setMediaController( mediaController );
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();
    }
}
