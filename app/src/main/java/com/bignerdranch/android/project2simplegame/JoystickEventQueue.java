package com.bignerdranch.android.project2simplegame;

import android.view.MotionEvent;

import java.util.LinkedList;

/**
 * Created by shaffer on 4/28/16.
 */
public class JoystickEventQueue {

    private static JoystickEventQueue defaultInstance;

    public static JoystickEventQueue getInstance() {
        if (defaultInstance == null)
            defaultInstance = new JoystickEventQueue();
        return defaultInstance;
    }

    private LinkedList<JoystickEvent> events;

    public JoystickEventQueue() {
        events = new LinkedList<>();
    }

    public synchronized void enqueue(JoystickEvent e) {
        events.addLast(e);
    }

    public synchronized JoystickEvent dequeue() {
        if (events.isEmpty())
            return null;
        else
            return events.removeFirst();
    }
}
