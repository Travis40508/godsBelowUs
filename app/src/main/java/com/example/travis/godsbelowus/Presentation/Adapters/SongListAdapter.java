package com.example.travis.godsbelowus.Presentation.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.travis.godsbelowus.Presentation.OnSongListClickListener;
import com.example.travis.godsbelowus.Presentation.Utils;
import com.example.travis.godsbelowus.R;
import com.example.travis.godsbelowus.Presentation.Models.Songs;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by travis on 2/18/17.
 */

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.SongViewHolder>{
    private ArrayList<Songs> list;
    OnSongListClickListener listener;

    public SongListAdapter(ArrayList<Songs> list, OnSongListClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_song_row, parent, false);

        return new SongViewHolder(itemView);
    }

    
    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.songId.setText(list.get(position).getSongId());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.song_row_title)
        TextView title;
        @BindView(R.id.song_row_id)
        TextView songId;


        public SongViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {
            if(!Utils.songIsPlaying) {
                listener.playSong(title.getText().toString());
                Utils.songIsPlaying = true;
            } else {
                listener.stopSong(title.getText().toString());
//                Utils.songIsPlaying = false;
            }
        }


    }

}
