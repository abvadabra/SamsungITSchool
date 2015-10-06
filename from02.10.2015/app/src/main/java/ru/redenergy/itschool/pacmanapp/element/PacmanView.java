package ru.redenergy.itschool.pacmanapp.element;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import ru.redenergy.itschool.pacmanapp.entity.Pacman;

public class PacmanView extends View {

    private boolean initialized = false;
    private Pacman[] pacmans = new Pacman[10];

    private float height;
    private float width;

    public PacmanView(Context context) {
        super(context);
        new PacmanTimer().start();
    }

    public PacmanView(Context context, AttributeSet attrs) {
        super(context, attrs);
        new PacmanTimer().start();
    }

    public PacmanView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        new PacmanTimer().start();
    }

    private void initPacmans(){
        for(int i = 0; i < pacmans.length; i++) {
            pacmans[i] = new Pacman(new PointF(width / pacmans.length * i, height / pacmans.length * i), 60);
        }
        Log.i("PACMAN", "Initialized");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.height = canvas.getHeight();
        this.width = canvas.getWidth();
        if(!initialized){
            initPacmans();
            initialized = true;
        }
        for(int i = 0; i < pacmans.length; i++) pacmans[i].draw(canvas);
    }

    public void nextFrame(){
        if(!initialized){
            initPacmans();
            initialized = true;
        }
        for(int i = 0; i < pacmans.length; i++) pacmans[i].setRotation(pacmans[i].getRotation() + (int)(Math.random() * 2));
        for(int i = 0; i < pacmans.length; i++) pacmans[i].move(10);
        invalidate();
    }


    public class PacmanTimer extends CountDownTimer {

        public static final int WORK_TIME = 30000;
        public static final int INTERVAL = 100;

        public PacmanTimer() {
            super(WORK_TIME, INTERVAL);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            nextFrame();
        }

        @Override
        public void onFinish() {

        }


    }

}
