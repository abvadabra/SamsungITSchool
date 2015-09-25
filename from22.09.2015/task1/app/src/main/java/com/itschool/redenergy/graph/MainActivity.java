package com.itschool.redenergy.graph;

import android.graphics.PointF;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Vector;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void solve(View button){
        int id = button.getId();
        int inputId = -1;
        int resultViewId = -1;
        switch(id){
            case R.id.solveButton:
                inputId = R.id.graphicinput;
                resultViewId = R.id.resultview;
                break;
            case R.id.secondSolveButton:
                inputId = R.id.secondGraphicinput;
                resultViewId = R.id.secondResultview;
                break;
        }
        EditText inputField = (EditText) findViewById(inputId);
        final TextView resultView = (TextView) findViewById(resultViewId);
        String input = inputField.getText().toString();
        String[] splittedInput = input.split(" ");
        if(splittedInput.length <= 1) return;
        try {
            float inputX = Float.parseFloat(splittedInput[0]);
            float inputY = Float.parseFloat(splittedInput[1]);
            resultView.setText(String.valueOf(isPointInDarkArea(new PointF(inputX, inputY), id)));
        } catch(java.lang.NumberFormatException ex){
            return;
        }
    }


    private boolean isPointInDarkArea(PointF point, int id){
        if(id == R.id.solveButton) {
            boolean sphere = isInsideOfSphere(new PointF(-4, 5), 3, point);
            boolean triangle = isInsideOfTriangle(new PointF(0, 0), new PointF(0, 6), new PointF(6, 0), point);
            return sphere || triangle;
        } else if(id == R.id.secondSolveButton) {
            boolean inBigSphere = isInsideOfSphere(new PointF(0, 0), 5, point);
            boolean inSmallSphere = isInsideOfSphere(new PointF(0, 0), 3, point);
            return point.x >= 0 && inBigSphere && !inSmallSphere;
        }
        return false;
    }

    /**
     * @author RedEnergy
     * @param p1 - fist verticle of triangle
     * @param p2 - second verticle of triangle
     * @param p3 - third verticle of triangle
     * @param point - given point
     * @return true if given point is inside of triangle, false otherwise
     */
    private boolean isInsideOfTriangle(PointF p1, PointF p2, PointF p3, PointF point){
        float a = (p1.x - point.x) * (p2.y - p1.y) - (p2.x - p1.x) * (p1.y - point.y);
        float b = (p2.x - point.x) * (p3.y - p2.y) - (p3.x - p2.x) * (p2.y - point.y);
        float c = (p3.x - point.x) * (p1.y - p3.y) - (p1.x - p3.x) * (p3.y - point.y);
        return (a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0);
    }

    /**
     * @author RedEnergy
     * @param sphereCenter
     * @param sphereRadius
     * @param point - given point
     * @return true if the given point inside of given sphere
     */
    private boolean isInsideOfSphere(PointF sphereCenter, float sphereRadius, PointF point){
        return Math.pow(point.x - sphereCenter.x, 2) + Math.pow(point.y - sphereCenter.y, 2) < Math.pow(sphereRadius, 2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
