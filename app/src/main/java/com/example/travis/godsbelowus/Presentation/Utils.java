package com.example.travis.godsbelowus.Presentation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.travis.godsbelowus.R;

import java.util.HashMap;

/**
 * Created by travis on 2/19/17.
 */

public class Utils {

    public static void fragmentBuilder(Fragment passedFragment, int frameLayoutId, FragmentManager fragmentManager) {
        FragmentTransaction fragmentTransaction;
        Fragment fragment = passedFragment;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameLayoutId, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

    public static int getId(String string) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Mourn The Sky", R.raw.mourn_the_sky);
        hashMap.put("Hell Is Repetition", R.raw.hell_is_repetition);
        hashMap.put("Mouthful Of Ashes", R.raw.mouthful_of_ashes);
        hashMap.put("Exordium", R.raw.exordium);
        hashMap.put("Siren", R.raw.siren);
        hashMap.put("Tempus", R.raw.tempus);
        hashMap.put("One More Reason To Die", R.raw.one_more_reason_to_die);
        hashMap.put("What Never Was", R.raw.what_never_was);
        hashMap.put("I Stand Opposed", R.raw.i_stand_opposed);
        hashMap.put("Them Bones", R.raw.them_bones);
        hashMap.put("What Never Was(Acoustic)", R.raw.what_never_was_acoustic);
        return hashMap.get(string);
    }

    public static boolean songIsPlaying = false;



}
