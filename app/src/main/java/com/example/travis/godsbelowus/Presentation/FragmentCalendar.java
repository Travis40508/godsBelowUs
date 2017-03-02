package com.example.travis.godsbelowus.Presentation;

/**
 * Created by travis on 2/26/17.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travis.godsbelowus.Presentation.Adapters.CalendarListAdapter;
import com.example.travis.godsbelowus.Presentation.Models.Dates;
import com.example.travis.godsbelowus.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FragmentCalendar extends Fragment{

    private ArrayList<Dates> list = new ArrayList<>();
    private CalendarListAdapter adapter;
    private DatabaseReference databaseReference;
    @BindView(R.id.recycler_view_calendar)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calendar_fragment, container, false);
        ButterKnife.bind(this, view);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        adapter = new CalendarListAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        initCalendarData();

        return view;
    }

    private void initCalendarData() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    list.add(snapshot.getValue(Dates.class));
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public static FragmentCalendar newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentCalendar fragment = new FragmentCalendar();
        fragment.setArguments(args);
        return fragment;
    }
}
