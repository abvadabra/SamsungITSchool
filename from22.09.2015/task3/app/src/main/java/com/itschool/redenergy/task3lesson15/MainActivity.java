package com.itschool.redenergy.task3lesson15;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void solve(View button){
        EditText xInput = ((EditText)findViewById(R.id.xInput));
        EditText yInput = ((EditText)findViewById(R.id.yInput));
        double inputX = Double.parseDouble(xInput.getText().toString());
        double inputY = Double.parseDouble(yInput.getText().toString());
        TextView resultView = (TextView) findViewById(R.id.result);
        String result = "";
        if(inputX > 0 && inputY > 0){
            result = "Result: I";
        } else if(inputX < 0 && inputY > 0){
            result = "Result: II";
        } else if(inputX < 0 && inputY < 0){
            result = "Result: III";
        } else if(inputX > 0 && inputY < 0){
            result = "Result: IV";
        }
        resultView.setText(result);
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
