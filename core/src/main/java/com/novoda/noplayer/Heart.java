package com.novoda.noplayer;

import android.os.Handler;
import android.os.Looper;

public class Heart {

    private static final long HEART_BEAT_FREQUENCY_IN_MILLIS = 500;

    private final Handler handler;
    private final long heartbeatFrequency;

    private Heartbeat heartbeatAction;

    private boolean beating;

    public static Heart newInstance() {
        Handler handler = new Handler(Looper.getMainLooper());
        return new Heart(handler, HEART_BEAT_FREQUENCY_IN_MILLIS);
    }

    Heart(Handler handler, long heartbeatFrequencyInMillis) {
        this.handler = handler;
        this.heartbeatFrequency = heartbeatFrequencyInMillis;
    }

    public void bind(Heartbeat onHeartbeat) {
        this.heartbeatAction = onHeartbeat;
    }

    public void startBeatingHeart() {
        if (heartbeatAction == null) {
            throw new IllegalStateException("You must call bind() with a valid non-null " + Heartbeat.class.getSimpleName());
        }
        stopBeatingHeart();
        beating = true;
        handler.post(heartbeat);
    }

    private final Runnable heartbeat = new Runnable() {
        @Override
        public void run() {
            handler.post(heartbeatAction);
            scheduleNextBeat();
        }
    };

    private void scheduleNextBeat() {
        handler.postDelayed(heartbeat, heartbeatFrequency);
    }

    public void stopBeatingHeart() {
        beating = false;
        handler.removeCallbacks(heartbeat);
    }

    public void forceBeat() {
        if (heartbeatAction == null) {
            throw new IllegalStateException("You must call bind() with a valid non-null " + Heartbeat.class.getSimpleName());
        }
        handler.post(heartbeatAction);
    }

    public boolean isBeating() {
        return beating;
    }

    public static class Heartbeat<T> implements Runnable {

        private final Callback<T> callback;
        private final T object;

        public Heartbeat(Callback<T> callback, T object) {
            this.callback = callback;
            this.object = object;
        }

        @Override
        public void run() {
            callback.onBeat(object);
        }

        public interface Callback<T> {

            void onBeat(T object);
        }
    }
}
