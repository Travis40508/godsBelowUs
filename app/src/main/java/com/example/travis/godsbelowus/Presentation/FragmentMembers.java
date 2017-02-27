package com.example.travis.godsbelowus.Presentation;

/**
 * Created by travis on 2/26/17.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.travis.godsbelowus.R;

public class FragmentMembers extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.members_fragment, container, false);
    }

    public static FragmentMembers newInstance() {
        
        Bundle args = new Bundle();
        
        FragmentMembers fragment = new FragmentMembers();
        fragment.setArguments(args);
        return fragment;
    }
}
