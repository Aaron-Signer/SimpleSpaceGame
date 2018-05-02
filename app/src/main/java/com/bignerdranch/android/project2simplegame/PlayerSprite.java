package com.bignerdranch.android.project2simplegame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import static android.icu.lang.UProperty.MATH;

/**
 * Created by Owner on 4/30/2018.
 */

public class PlayerSprite extends Sprite {

    private int angle;

    public PlayerSprite(Vec2d v) {
        super(v);
        loadBitmaps();
    }

    private void loadBitmaps() {
        BitmapRepo r = BitmapRepo.getInstance();
        BitmapSequence s = new BitmapSequence();
        s.addImage(r.getImage(R.drawable.ship), 0.1);
        setBitmaps(s);
    }


    @Override
    public void tick(double dt)
    {
        super.tick(dt);
        JoystickEvent e = null;
        do {
            e = JoystickEventQueue.getInstance().dequeue();
            if (e != null)
                handleJoystickEvent(e);
        }while(e != null);
    }

    private void handleJoystickEvent(JoystickEvent e) {
        angle = e.angle;
    }

    @Override
    public void draw(Canvas c)
    {
        c.rotate(-angle, getPosition().getX() + getBitmaps().getCurrentBitmap().getWidth()/2, getPosition().getX() + getBitmaps().getCurrentBitmap().getHeight()/2);
        c.drawBitmap(getBitmaps().getCurrentBitmap(), getPosition().getX(), getPosition().getY(), null );
        c.rotate(angle);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
