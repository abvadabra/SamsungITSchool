package ru.samsung.itschool.cells;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.Random;


public class MainActivity extends Activity implements View.OnClickListener,
        View.OnLongClickListener {

    int WIDTH = 10;
    int HEIGHT = 10;

    public CellMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cells);
        map = new CellMap(this, WIDTH, HEIGHT);

    }

   @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public void onClick(View v) {
        Button tappedCell = (Button) v;

        int tappedX = getX(tappedCell);
        int tappedY = getY(tappedCell);

        invertColor(map.getCell(tappedX, tappedY));

        for(int x = 0; x < map.getWidth(); x++){
            if(x == tappedX) continue;
            invertColor(map.getCell(x, tappedY));
        }

        for(int y = 0; y < map.getHeight(); y++){
            if(y == tappedY) continue;
            invertColor(map.getCell(tappedX, y));
        }

    }

    private void invertColor(Button btn){
        int color = ((ColorDrawable)btn.getBackground()).getColor();
        btn.setBackgroundColor(~color);
    }

    int getX(View v){
        return Integer.parseInt(((String)v.getTag()).split(",")[1]);
    }

    int getY(View v){
        return Integer.parseInt(((String)v.getTag()).split(",")[0]);
    }

}