package com.example.travis.godsbelowus.Presentation;

import android.media.MediaPlayer;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.travis.godsbelowus.Presentation.Presenters.MainActivityPresenter;
import com.example.travis.godsbelowus.Presentation.Views.MainActivityView;
import com.example.travis.godsbelowus.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    private MediaPlayer mPlayer;
    private MainActivityPresenter presenter = new MainActivityPresenter(this);
    @BindView(R.id.button_play)
    ImageView playButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter.activityCreated();
    }

    public void buildFragment() {
        Utils.fragmentBuilder(new FragmentSongs(), R.id.frame_layout, getSupportFragmentManager() );
    }

    public void playSongs(String songId) {
        int sound_id = Utils.getId(songId);
        mPlayer = MediaPlayer.create(this, sound_id);
        mPlayer.start();
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Utils.songIsPlaying = false;
            }
        });
    }

    public void stopSong(String songId) {
        mPlayer.stop();
        playSongs(songId);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Utils.songIsPlaying = false;
            }
        });
    }

    @OnClick(R.id.button_play)
    public void onlyStopSong() {
        mPlayer.stop();
        Utils.songIsPlaying = false;
    }

}
