package com.ngu.milkway.red.widget;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;


/**
 * Created by xt on 16/5/7.
 */
public class RadiateAnimator extends ValueAnimator {

    private static final Interpolator DEFAULT_INTERPOLATOR = new AccelerateInterpolator(0.6f);
    private static final long DEFAULT_DURATION = 1000;
    private static final float END_VALUE = 1.4f;

    private RadiateParticle[][] mParticles;
    private Paint mPaint;
    private View view;

    public RadiateAnimator(View view, Bitmap bitmap, Rect bound) {
        this.view = view;
        setFloatValues(0f, END_VALUE);
        setInterpolator(DEFAULT_INTERPOLATOR);
        setDuration(DEFAULT_DURATION);
        mParticles = generateParticles(bitmap, bound);
        mPaint = new Paint();
    }

    private RadiateParticle[][] generateParticles(Bitmap bitmap, Rect bound) {
        int width = bound.width();
        int height = bound.height();

//        int partLen = 15;
//        int rowCount = width / (partLen + 2);
//        int columnCount = height / (partLen + 2);

        int rowCount = width / RadiateParticle.WIDTH;
        int columnCount = height / RadiateParticle.WIDTH;

        int partWidth = bitmap.getWidth() / rowCount;
        int partHeight = bitmap.getHeight() / columnCount;

        RadiateParticle[][] particles = new RadiateParticle[rowCount][columnCount];
        Point point;
        for (int i = 0; i < rowCount; i++) { // row
            for (int j = 0; j < columnCount; j++) { // column
                int color = bitmap.getPixel(j * partWidth, i * partHeight);
                point = new Point(j, i);
                particles[i][j] = new RadiateParticle(color, bound, point);
            }
        }
        return particles;
    }

    public void draw(Canvas canvas) {
        if (isStarted()) {
            return;
        }
        for (RadiateParticle[] particle : mParticles) {
            for (RadiateParticle p : particle) {
                p.move((Float) getAnimatedValue());
                mPaint.setColor(p.getColor());
                mPaint.setAlpha((int) (Color.alpha(p.getColor()) * p.getAlpha()));
                canvas.drawCircle(p.getCx(), p.getCy(), p.getRadius(), mPaint);
            }
        }
        view.invalidate();
    }

    @Override
    public void start() {
        super.start();
        view.invalidate();
    }
}
