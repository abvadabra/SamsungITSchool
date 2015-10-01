package com.itschool.redenergy.task1lesson17.elements;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by RedEnergy on 01.10.2015.
 */
public class SceneView extends View {
    public SceneView(Context context) {
        super(context);
    }

    public SceneView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SceneView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        fillScreenWithRects(canvas);
        fillScreenWithPacmans(canvas);
        drawMark(canvas, canvas.getWidth() / 2, canvas.getHeight() / 2, 10);
    }

    private void fillScreenWithPacmans(Canvas canvas){
        for(int x = 0; x < (canvas.getWidth() / 50); x++){
            for(int y = 0; y < (canvas.getHeight() / 50); y++) {
                if(x % 2 == 0 && y % 2 == 0)
                    drawPacman(canvas, 25 + x * 50, 25 + y * 50, 50);
            }
        }
    }

    private void fillScreenWithRects(Canvas canvas){
        Paint paint = new Paint();
        paint.setARGB(255, 255, 0, 0);
        for(int j = 0; j < canvas.getWidth() / 50; j++) {
            for(int i = 0; i < canvas.getHeight() /  60; i++){
                int xPos = j * 55;
                int yPos = 65 * i;
                int width = 30;
                int height = 30;
                canvas.drawRect(xPos, yPos, xPos + width, yPos + height, paint);
            }
        }
    }


    private void drawMark(Canvas canvas, float xPos, float yPos, int amountOfCircles){
        Paint whiteColor = new Paint();
        whiteColor.setARGB(255, 255, 255, 255);
        Paint redColor = new Paint();
        redColor.setARGB(255, 255, 0, 0);
        for(int i = 0; i < amountOfCircles; i++){
            canvas.drawCircle(xPos , yPos, 20 + (20 * (amountOfCircles - i)), i % 2 == 0 ? redColor : whiteColor);
        }
    }

    private void drawPacmanScene(Canvas canvas){
        drawPacman(canvas, canvas.getWidth() / 2, canvas.getHeight() / 2, 300);
        drawPointsForPacman(canvas, canvas.getWidth() / 2 + 100, canvas.getHeight() / 2, 4);
    }
    private void drawPointsForPacman(Canvas canvas, float startXPos, int yPos, int amountOfPoints){
        for(int i = 0; i < amountOfPoints; i++){
            Paint whitePaint = new Paint();
            whitePaint.setARGB(255, 255, 255, 255);
            canvas.drawCircle(startXPos + (i * 150), yPos, 20, whitePaint);
        }
    }
    private void drawPacman(Canvas canvas, float xPos, float yPos, float size){
        RectF rect = new RectF(xPos - size / 2, yPos - size / 2, xPos + size / 2, yPos + size / 2);
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawArc(rect, 45, 270, true, paint);
        canvas.drawCircle(xPos, yPos - size / 5, size / 10, new Paint(Color.BLACK));
    }

    private void drawRGBCircles(Canvas canvas){
        Paint paint = new Paint(Color.BLUE);
        paint.setARGB(150, 255, 0, 0);
        canvas.drawCircle(canvas.getWidth() / 2 - 100, canvas.getHeight() / 2 - 100, 200, paint);
        paint.setARGB(150, 0, 255, 0);
        canvas.drawCircle(canvas.getWidth() / 2 + 100, canvas.getHeight() / 2 - 100, 200, paint);
        paint.setARGB(150, 0, 0, 255);
        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2 + 100, 200, paint);
    }

}


