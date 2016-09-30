package com.example.cak37.simplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import java.text.NumberFormat;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

public class SimpleCalc extends AppCompatActivity {

    private EditText num1TB;
    private EditText num2TB;
    private TextView calcView;
    private Button calcB;
    private Spinner opSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calc);
        addOperatorsToSpinner();
    }

    public void addOperatorsToSpinner(){
        opSpin = (Spinner) findViewById(R.id.opSpin);
        List<String> list = new ArrayList<String>();
        list.add("Select Operator");
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opSpin.setAdapter(dataAdapter);
    }

    public void calcOp(View v) {
        num1TB = (EditText) findViewById(R.id.num1TB);
        num2TB = (EditText) findViewById(R.id.num2TB);
        calcView = (TextView) findViewById(R.id.calcView);
        opSpin = (Spinner) findViewById(R.id.opSpin);

        int value1 = Integer.parseInt(num1TB.getText().toString());
        int value2 = Integer.parseInt(num2TB.getText().toString());

        if (opSpin.getSelectedItem().toString() == "+") {
            calcView.setText(Integer.toString(value1 + value2));
        } else if (opSpin.getSelectedItem().toString() == "-") {
            calcView.setText(Integer.toString(value1 - value2));
        } else if (opSpin.getSelectedItem().toString() == "*") {
            calcView.setText(Integer.toString(value1 * value2));
        } else if (opSpin.getSelectedItem().toString() == "/") {
            calcView.setText(Integer.toString(value1 / value2));
        }

    }
}
