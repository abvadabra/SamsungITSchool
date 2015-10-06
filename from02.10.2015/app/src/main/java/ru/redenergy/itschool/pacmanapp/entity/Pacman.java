package ru.redenergy.itschool.pacmanapp.entity;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;

public class Pacman {
    private PointF pos;
    private int rotation = 0;
    private int size;

    public Pacman(PointF pos, int size){
        this.pos = pos;
        this.size = size;
    }

    public void draw(Canvas canvas){
        drawPacman(canvas);
    }

    private void drawPacman(Canvas canvas){
        drawPacman(canvas, getPos().x, getPos().y, getSize(), getRotation());
    }

    public PointF getPos(){
        return pos;
    }

    public void setPos(PointF pos){
        this.pos = pos;
    }

    public void setPos(float x, float y){
        this.pos.set(x, y);
    }

    public int getRotation(){
        return rotation;
    }

    public void setRotation(int rotation){
        this.rotation = rotation;
    }

    private void drawPacman(Canvas canvas, float xPos, float yPos, float size, int degrees){
        RectF rect = new RectF(xPos - size / 2, yPos - size / 2, xPos + size / 2, yPos + size / 2);
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        canvas.rotate(degrees, xPos, yPos);
        canvas.drawArc(rect, 45, 270, true, paint);
        canvas.drawCircle(xPos, yPos - size / 5, size / 10, new Paint(Color.BLACK));
        canvas.rotate(-degrees, xPos, yPos);
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public void move(float distance){
        getPos().x += Math.cos(Math.toRadians(rotation)) * distance;
        getPos().y += Math.sin(Math.toRadians(rotation)) * distance;
    }

}
