package com.example.travis.godsbelowus.Presentation;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import java.util.List;

/**
 * Created by travis on 2/26/17.
 */

public class ScreenSlidePageAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments;

    public ScreenSlidePageAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                FragmentSongs fragmentSongs = new FragmentSongs();
                return fragmentSongs;
            case 1:
                FragmentMembers fragmentMembers = new FragmentMembers();
                return fragmentMembers;
            case 2:
                FragmentCalendar fragmentCalendar = new FragmentCalendar();
                return fragmentCalendar;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
