package ru.samsung.itschool.cells;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.GridLayout;

public class CellMap {

    private final int width;
    private final int height;
    private Button[][] cell;

    public CellMap(MainActivity base, int width, int height){
        this.width = width;
        this.height = height;
        buildMap(base);
    }

    public Button getCell(int x, int y){
        return cell[x][y];
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    private void buildMap(MainActivity base){
        cell = new Button[height][width];
        GridLayout cellsLayout = (GridLayout) base.findViewById(R.id.CellsLayout);
        cellsLayout.removeAllViews();
        cellsLayout.setColumnCount(height);
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                LayoutInflater inflater = (LayoutInflater) base.getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                cell[i][j] = (Button) inflater.inflate(R.layout.cell, cellsLayout, false);
                cell[i][j].setOnClickListener(base);
                cell[i][j].setOnLongClickListener(base);
                cell[i][j].setTag(j + "," + i);
                cell[i][j].setBackgroundColor(Color.WHITE);
                cellsLayout.addView(cell[i][j]);
            }
    }
}
