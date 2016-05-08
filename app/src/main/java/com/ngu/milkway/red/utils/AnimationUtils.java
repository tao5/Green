package com.ngu.milkway.red.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import tyrantgit.explosionfield.ExplosionField;

/**
 * Created by xt on 16/5/8.
 */
public class AnimationUtils {

    /**
     * load explosion animation
     * @param activity where the explosion being attach
     * @param root the view being explsion
     */
    public static void loadExplosionAnim(Activity activity, View root) {
        final ExplosionField explosionField = ExplosionField.attach2Window(activity);
        if (root instanceof ViewGroup) {
            ViewGroup parent = (ViewGroup) root;
            for (int i = 0; i < parent.getChildCount(); i++) {
                loadExplosionAnim(activity, parent.getChildAt(i));
            }
        } else {
            root.setClickable(true);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    explosionField.explode(v);
                    v.setOnClickListener(null);
                }
            });
        }
    }

}
