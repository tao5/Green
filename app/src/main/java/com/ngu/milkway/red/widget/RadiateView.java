package com.ngu.milkway.red.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.ngu.milkway.red.utils.BitmapUtils;

import java.util.ArrayList;

/**
 * Created by xt on 16/5/7.
 */
public class RadiateView extends View {

    private ArrayList<RadiateAnimator> animators;

    public RadiateView(Context context) {
        super(context);
        init();
    }

    public RadiateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadiateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        animators = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (RadiateAnimator animator: animators) {
            animator.draw(canvas);
        }
    }

    private void explode(final View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        rect.offset(0, BitmapUtils.dp2px(25));
        final RadiateAnimator animator = new RadiateAnimator(view, BitmapUtils.createBitmapByView(view), rect);
        animators.add(animator);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.animate().alpha(0).setDuration(150).start();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                view.animate().alpha(1).setDuration(150).start();
                animators.remove(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
        animator.start();
    }

    public static RadiateView attach2Activity(Activity activity) {
        ViewGroup rootView = (ViewGroup) activity.findViewById(Window.ID_ANDROID_CONTENT);
        RadiateView radiateView = new RadiateView(activity);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rootView.addView(radiateView, lp);
        return radiateView;
    }

    public void addListener(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                addListener(viewGroup.getChildAt(i));
            }
        } else {
            view.setClickable(true);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    explode(v);
                }
            });
        }
    }

    public void reset() {
        animators.clear();
        invalidate();
    }

}
