package com.example.travis.godsbelowus.Presentation;

import android.media.MediaPlayer;
import android.support.annotation.IntegerRes;
import android.support.annotation.RawRes;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travis.godsbelowus.R;
import com.example.travis.godsbelowus.Presentation.Adapters.SongListAdapter;
import com.example.travis.godsbelowus.Presentation.Models.Songs;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by travis on 2/16/17.
 */

public class FragmentSongs extends Fragment implements OnSongListClickListener{
    private ArrayList<Songs> list = new ArrayList<>();
    private MediaPlayer mPlayer;
    @BindView(R.id.recycler_view_songs)
    RecyclerView recyclerView;
    private SongListAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songs, container, false);
        ButterKnife.bind(this, view);
        adapter = new SongListAdapter(list, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        initSongList();
        adapter.notifyDataSetChanged();
        return view;
    }

    public static FragmentSongs newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentSongs fragment = new FragmentSongs();
        fragment.setArguments(args);
        return fragment;
    }

    public void initSongList() {
        Songs exordium = new Songs("Exordium");
        list.add(exordium);
        Songs oneMoreReasonToDie = new Songs("One More Reason To Die");
        list.add(oneMoreReasonToDie);
        Songs siren = new Songs("Siren");
        list.add(siren);
        Songs tempus = new Songs("Tempus");
        list.add(tempus);
        Songs whatNeverWas = new Songs("What Never Was");
        list.add(whatNeverWas);
        Songs hellIsRepetition = new Songs("Hell Is Repetition");
        list.add(hellIsRepetition);
        Songs iStandOpposed = new Songs("I Stand Opposed");
        list.add(iStandOpposed);
        Songs mouthfulOfAshes = new Songs("Mouthful Of Ashes");
        list.add(mouthfulOfAshes);
        Songs mournTheSky = new Songs("Mourn The Sky");
        list.add(mournTheSky);
        Songs themBones = new Songs("Them Bones");
        list.add(themBones);
        Songs whatNeverWasAcoustic = new Songs("What Never Was(Acoustic)");
        list.add(whatNeverWasAcoustic);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        list.clear();
    }

    @Override
    public void playSong(String songId) {
        ((MainActivity)getContext()).playSongs(songId);
    }

    public void stopSong(String songId) {
        ((MainActivity)getContext()).stopSong(songId);
    }
    


}
