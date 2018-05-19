package es.montanus.workout;

import android.os.Handler;

class Clock {
    public static final int ONE_SECOND = 1000;
    private final ClockListener listener;

    public Clock(ClockListener listener) {
        this.listener = listener;
    }

    public void start() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onTick();
                handler.postDelayed(this, ONE_SECOND);
            }
        }, ONE_SECOND);
    }
}
