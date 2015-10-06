package ru.redenergy.itschool.lessonnine;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    public List<Float> inputData = new ArrayList();
    public List<Float> resultData = new ArrayList();

    public List<Pair> getPairs(){
        List<Pair> result = new ArrayList();
        int pairs = inputData.size() / 2;
        for(int i = 0; i < pairs; i++){
            result.add(new Pair(inputData.get(i * 2), inputData.get(i * 2 + 1)));
        }
        return result;
    }
    public void sum(View button){
        resultData.clear();
        for(Pair pair : getPairs()){
            resultData.add((float)pair.first + (float)pair.second);
        }
        getResultView().setText(Arrays.toString(resultData.toArray()));
    }

    public void deduct(View button){
        resultData.clear();
        for(Pair pair : getPairs()){
            resultData.add((float)pair.first - (float)pair.second);
        }
        getResultView().setText(Arrays.toString(resultData.toArray()));
    }

    public void multiply(View button){
        resultData.clear();
        for(Pair pair : getPairs()){
            resultData.add((float)pair.first * (float)pair.second);
        }
        getResultView().setText(Arrays.toString(resultData.toArray()));
    }

    public void divide(View button){
        resultData.clear();
        for(Pair pair : getPairs()){
            resultData.add((float)pair.first / (float)pair.second);
        }
        getResultView().setText(Arrays.toString(resultData.toArray()));
    }

    private TextView getResultView(){
        return (TextView) findViewById(R.id.result);
    }

    private EditText getInputField(){
        return (EditText) findViewById(R.id.input);
    }

    private void parseDataFromText(String text){
        if(text.length() <= 1) return;
        String[] splitted = text.split(",");
        List<Float> numbers = new ArrayList();
        for(String s : splitted){
            try {
                numbers.add(Float.parseFloat(s.trim()));
            } catch (NumberFormatException ex){
                continue;
            }
        }
        this.inputData = numbers;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getInputField().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                parseDataFromText(s.toString());
            }
        });
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
