package com.bignerdranch.android.project2simplegame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

class World {
    private List<Sprite> sprites;
    float touchedX, touchedY;
    boolean touched = false;
    float timeD;
    int hist;
    PlayerSprite player;

    public World()
    {
        sprites = new ArrayList<>();
       player = new PlayerSprite(new Vec2d(0,0));
       sprites.add(player);
    }

    public void tick(double dt) {
        MotionEvent e = null;
        do {
            e = TouchEventQueue.getInstance().dequeue();
            if (e != null)
                handleMotionEvent(e);
        }while(e != null);
        for(Sprite s: sprites)
            s.tick(dt);
    }

    /**
     * When the user touches the screen, this message is sent.  Probably you
     * want to tell the player to do something?
     *
     * @param e the MotionEvent corresponding to the touch
     */
    private void handleMotionEvent(MotionEvent e) {
        touched = true;
        touchedX = e.getRawX();
        touchedY = e.getRawY();
        timeD = e.getDownTime();
        hist = e.getHistorySize();
//        e.AXIS_THROTTLE;
    }

    public void draw(Canvas c) {
//        Bitmap bg = BitmapRepo.getInstance().getImage(R.drawable.background);
       // Rect bG = new Rect(100,100,200,1000);
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        p.setStyle(Paint.Style.FILL);
        c.drawRect(0,0,c.getWidth(),c.getHeight(),p);
       p.setColor(Color.RED);
//        c.rotate(touchedX,550, 550);
//        c.drawRect(500, 500, 600, 600, p);
//        c.rotate(-touchedX, 550, 550);
//        c.drawRect(1000, 500, 1100, 600, p);

        p.setTextSize(100);
//        c.drawText(Float.toString(touchedX) + " " + Float.toString(touchedY), 100, 100, p);
//        c.drawText(Float.toString(timeD), 100, 100, p);
        c.drawText(Integer.toString(hist), 100, 100, p);
        for(Sprite s: sprites)
            s.draw(c);


        //c.drawRect(bG, p);


    }
}
