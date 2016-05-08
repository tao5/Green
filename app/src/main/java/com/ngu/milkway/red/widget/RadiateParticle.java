package com.ngu.milkway.red.widget;

import android.graphics.Point;
import android.graphics.Rect;

import java.util.Random;

/**
 * Created by xt on 16/5/7.
 */
public class RadiateParticle {

    private float cx;
    private float cy;
    private int color;
    private float alpha;
    private float radius;
    private Rect bound;

    public final static int WIDTH = 8;
    private Random random;

    public RadiateParticle(int color, Rect bound, Point point) {
        random = new Random();
        int row = point.x;
        int column = point.y;
        this.bound = bound;
        this.color = color;
        this.alpha = 1f;
        this.radius = WIDTH;
        this.cx = bound.left + WIDTH * column;
        this.cy = bound.top + WIDTH * row;
    }

    public void move(float factor) {
        cx = cx + factor * random.nextInt(bound.width()) * (random.nextFloat() - 0.5f);
        cy = cy + factor * random.nextInt(bound.height() / 2);
        radius = radius - factor * random.nextInt(2);
        alpha = (1f - factor) * (1 + random.nextFloat());
    }

    public float getCx() {
        return cx;
    }

    public float getCy() {
        return cy;
    }

    public int getColor() {
        return color;
    }

    public float getAlpha() {
        return alpha;
    }

    public float getRadius() {
        return radius;
    }

    public Rect getBound() {
        return bound;
    }
}
