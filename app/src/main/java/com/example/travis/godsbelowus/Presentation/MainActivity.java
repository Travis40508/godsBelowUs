package com.example.travis.godsbelowus.Presentation;

import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.travis.godsbelowus.Presentation.Presenters.MainActivityPresenter;
import com.example.travis.godsbelowus.Presentation.Views.MainActivityView;
import com.example.travis.godsbelowus.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    private MediaPlayer mPlayer;
    private MainActivityPresenter presenter = new MainActivityPresenter(this);
    List<Fragment> fragmentList = new ArrayList<>();
    ScreenSlidePageAdapter adapter;
    @BindView(R.id.button_songs)
    ImageView buttonSongs;
    @BindView(R.id.button_members)
    ImageView buttonMembers;
    @BindView(R.id.button_calendar)
    ImageView buttonCalendar;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.button_play)
    ImageView playButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        populateList();
        pageChange();
        buttonSongs.setImageResource(R.drawable.ic_songs_selected);
        adapter = new ScreenSlidePageAdapter(getSupportFragmentManager(), fragmentList);
        mViewPager.setAdapter(adapter);
    }

    private void pageChange() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetIcons();
                switch(position) {
                    case 0:
                        buttonSongs.setImageResource(R.drawable.ic_songs_selected);
                        break;
                    case 1:
                        buttonMembers.setImageResource(R.drawable.ic_members_selected);
                        break;
                    case 2:
                        buttonCalendar.setImageResource(R.drawable.ic_calendar_selected);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void populateList() {
        fragmentList.add(FragmentSongs.newInstance());
        fragmentList.add(FragmentMembers.newInstance());
        fragmentList.add(FragmentCalendar.newInstance());
    }

//    public void buildFragment() {
//        Utils.fragmentBuilder(new FragmentSongs(), R.id.view_pager, getSupportFragmentManager() );
//    }

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
    public void resetIcons() {
        buttonSongs.setImageResource(R.drawable.ic_songs);
        buttonMembers.setImageResource(R.drawable.ic_members);
        buttonCalendar.setImageResource(R.drawable.ic_calendar);
    }

}
