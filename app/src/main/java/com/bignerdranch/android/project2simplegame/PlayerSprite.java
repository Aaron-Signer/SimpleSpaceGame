package com.bignerdranch.android.project2simplegame;

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
        Paint p = new Paint();
        p.setColor(Color.BLUE);
        c.drawLine((float)getPosition().getX(),
                (float)getPosition().getY(),
                (float)(getPosition().getX()+100*Math.cos(Math.toRadians(angle))),
                (float)( getPosition().getY()-100*Math.sin(Math.toRadians(angle))),
                p);
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
