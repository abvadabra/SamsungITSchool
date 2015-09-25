package com.itschool.redenergy.task4lesson15;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void solve(View button){
        EditText typeText = (EditText)findViewById(R.id.type);
        int type = Integer.parseInt(typeText.getText().toString());
        double result = 0;
        EditText lenghtText = (EditText)findViewById(R.id.length);
        double lenght = Double.parseDouble(lenghtText.getText().toString());
        switch(type){
            case 1:
                result = lenght / 10;
                break;
            case 2:
                result = lenght * 1000;
                break;
            case 3:
                result = lenght;
                break;
            case 4:
                result = lenght / 1000;
                break;
            case 5:
                result = lenght / 100;
                break;
            case 6:
                result = lenght / 0.0254;
                break;
            case 7:
                result = lenght / 0.304;
                break;
            case 8:
                result = lenght * 1609;
                break;
        }
        TextView resultView  = (TextView) findViewById(R.id.result);
        resultView.setText("Result: " + result);
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
