package udg.mxc.aplication1.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import udg.mxc.aplication1.R;
import udg.mxc.aplication1.util.Util;

public class MusicActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ButterKnife.bind(this);
    }

    @OnClick( R.id.button_play ) public void play(){
        if( mediaPlayer == null ){
            mediaPlayer = MediaPlayer.create(this, R.raw.song);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        mediaPlayer.start();
    }

    @OnClick( R.id.button_pause ) public void pause(){
        if(mediaPlayer != null){
            mediaPlayer.pause();
        }
    }

    @OnClick( R.id.button_stop ) public void stop(){
        stopPlayer();
    }

    public void stopPlayer(){
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
            Util.showToast(this, "MediaPlayer released");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}
