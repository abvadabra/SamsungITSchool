package com.itschool.redenergy.task5lesson15;

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
        EditText inputAmount = (EditText) findViewById(R.id.amountEditText);
        int amount = Integer.parseInt(inputAmount.getText().toString());
        if(amount < 0 || amount > 130) return;
        String result = "";
        if((amount % 10) == 1){
            result = "Вам " + amount + " год";
        } else if((amount % 10) == 2 || (amount % 10) == 3 || (amount % 10) == 4){
            result = "Вам " + amount + " года";
        } else {
            result = "Вам " + amount + " лет";
        }
        TextView resultView = (TextView) findViewById(R.id.result);
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
