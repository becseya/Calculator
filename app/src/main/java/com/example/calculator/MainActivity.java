package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtOperand1;
    private EditText txtOperand2;
    private TextView labelResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtOperand1 = (EditText) findViewById(R.id.txtOperand1);
        txtOperand2 = (EditText) findViewById(R.id.txtOperand2);
        labelResult = (TextView) findViewById(R.id.labelResult);
    }

    public void onButtonClick(View view) {
        String operator = ((Button) view).getText().toString();
        String operand1 = txtOperand1.getText().toString();
        String operand2 = txtOperand2.getText().toString();

        try {
            float result = getResult(operator, operand1, operand2);

            labelResult.setText(operand1 + " " + operator + " " + operand2 + " = " + result);
        }
        catch (Exception e) {
            Toast.makeText(this, "User input error", Toast.LENGTH_SHORT).show();
        }
    }

    private float getResult(String txt_operator, String txt_op1, String txt_op2) {
        float op1 = Float.parseFloat(txt_op1);
        float op2 = Float.parseFloat(txt_op2);

        switch (txt_operator) {
            case "-":
                return  op1 - op2;
            case "+":
                return  op1 + op2;
            case "*":
                return  op1 * op2;
            case "/":
                return  op1 / op2;
            default:
                return 0;
        }
    }
}