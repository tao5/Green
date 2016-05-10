package com.ngu.milkway.red.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import static com.ngu.milkway.red.utils.Red.checkNotNull;

/**
 * Created by xt on 16/4/29.
 */
public class ActivityUtils {

    public static void loadFragment(FragmentManager fragmentManager,
                                    Fragment fragment, int containerViewId) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        fragmentManager.beginTransaction().replace(containerViewId, fragment).commit();
    }

}
