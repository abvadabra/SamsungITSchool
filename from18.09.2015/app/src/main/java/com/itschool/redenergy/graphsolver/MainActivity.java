package com.itschool.redenergy.graphsolver;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText graphInput = (EditText) findViewById(R.id.graphinput);
        graphInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                graphInputTextChanged(charSequence, i, i1, i2);
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private void graphInputTextChanged(CharSequence charSequence, int i, int i1, int i2){
        String text = charSequence.toString();
        String[] splittedText= text.split(" ");
        if(splittedText.length <= 1) return;
        double inputX;
        double inputY;
        try {
            inputX = Double.parseDouble(splittedText[0]);
            inputY = Double.parseDouble(splittedText[1]);
        } catch (NumberFormatException ex){
            return;
        }
        ((TextView)findViewById(R.id.graphresult)).setText("Result: " + isDotInDarkArea(inputX, inputY));
    }


    private boolean isDotInDarkArea(double x, double y){
        //#1
        if(x * x + y * y < 1 && y > x) return true;
        //#2
        boolean rightArea = (x * x + y * y < 1);
        boolean leftArea = (y > -x || y < x);
        if(rightArea || leftArea) return true;
        //#3
        //TODO
        if(true) return true;
        //#4
        if(x > 0 && y > -1 && y < 1 && y > x - 1) return true;
        return false;
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
