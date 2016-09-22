package com.example.pk.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        final Button oneButton = (Button) findViewById(R.id.one_button);
        final Button twoButton = (Button) findViewById(R.id.two_button);
        final Button threeButton = (Button) findViewById(R.id.three_button);
        final Button fourButton = (Button) findViewById(R.id.four_button);
        final Button fiveButton = (Button) findViewById(R.id.fiveButton);
        final Button sixButton = (Button) findViewById(R.id.six_button);
        final Button sevenButton = (Button) findViewById(R.id.seven_button);
        final Button eightButton = (Button) findViewById(R.id.eight_button);
        final Button nineButton = (Button) findViewById(R.id.nine_button);
        final Button zeroButton = (Button) findViewById(R.id.zero_button);

        final Button plusButton = (Button) findViewById(R.id.plus_button);
        final Button minusButton = (Button) findViewById(R.id.minus_button);
        final Button multiplyButton = (Button) findViewById(R.id.multiply_button);
        final Button divideButton = (Button) findViewById(R.id.divide_button);
        final Button equalButton = (Button) findViewById(R.id.equal_button);
        final Button clearButton = (Button) findViewById(R.id.clear_button);
        final Button clearAllButton = (Button) findViewById(R.id.clear_all_button);
        final Button pointButton = (Button) findViewById(R.id.pointButton);

        plusButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
        equalButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
        clearAllButton.setOnClickListener(this);
        pointButton.setOnClickListener(this);

        oneButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);
        fiveButton.setOnClickListener(this);
        sixButton.setOnClickListener(this);
        sevenButton.setOnClickListener(this);
        eightButton.setOnClickListener(this);
        nineButton.setOnClickListener(this);
        zeroButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        StringBuilder expression = new StringBuilder(editText.getText().toString());

        switch (view.getId()) {
            case R.id.one_button:
                expression.append("1");
                editText.setText(expression.toString());
                break;
            case R.id.two_button:
                expression.append("2");
                editText.setText(expression.toString());
                break;
            case R.id.three_button:
                expression.append("3");
                editText.setText(expression.toString());
                break;
            case R.id.four_button:
                expression.append("4");
                editText.setText(expression.toString());
                break;
            case R.id.fiveButton:
                expression.append("5");
                editText.setText(expression.toString());
                break;
            case R.id.six_button:
                expression.append("6");
                editText.setText(expression.toString());
                break;
            case R.id.seven_button:
                expression.append("7");
                editText.setText(expression.toString());
                break;
            case R.id.eight_button:
                expression.append("8");
                editText.setText(expression.toString());
                break;
            case R.id.nine_button:
                expression.append("9");
                editText.setText(expression.toString());
                break;
            case R.id.plus_button:
                expression.append("+");
                editText.setText(expression.toString());
                break;
            case R.id.minus_button:
                expression.append("-");
                editText.setText(expression.toString());
                break;
            case R.id.multiply_button:
                expression.append("*");
                editText.setText(expression.toString());
                break;
            case R.id.divide_button:
                expression.append("/");
                editText.setText(expression.toString());
                break;
            case R.id.equal_button:
                if (checkedCorrectly()) {
                    editText.setText(Calculator.calculateExpression(expression.toString()));
                } else {
                    Toast.makeText(this, "Please, enter correctly expression!"
                            , Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.clear_button:
                clearLastSymbol();
                break;
            case R.id.clear_all_button:
                editText.setText("");
                break;
            case R.id.pointButton:
                expression.append(".");
                editText.setText(expression.toString());
                break;
        }
    }

    /**
     * This method clear last symbol in edit text.
     */
    private void clearLastSymbol() {
        if (editText.toString().equals("")) {
            return;
        }

        char[] etToCharArray = editText.getText().toString().toCharArray();

        String result = "";

        for (int i = 0; i < etToCharArray.length - 1; i++) {
            result += etToCharArray[i];
        }

        editText.setText(result);
    }

    /**
     * This method checked for correctly expression in edit text view.
     *
     * @return - result of checked
     */
    private boolean checkedCorrectly() {
        if (editText.toString().equals("")) {
            return true;
        }

        char[] etToCharArray = editText.getText().toString().toCharArray();

        boolean result = true;

        //checked end ot start of edit text view contains operators.
        if ((etToCharArray[0] == '+' || etToCharArray[0] == '-'
                || etToCharArray[0] == '/' || etToCharArray[0] == '*'
                || etToCharArray[0] == '.')
                || (etToCharArray[etToCharArray.length - 1] == '+'
                || etToCharArray[etToCharArray.length - 1] == '-'
                || etToCharArray[etToCharArray.length - 1] == '/'
                || etToCharArray[etToCharArray.length - 1] == '*'
                || etToCharArray[etToCharArray.length - 1] == '.')) {
            return false;
        }

        ArrayList<Integer> operatorPosition = new ArrayList<>();

        for (int i = 0; i < etToCharArray.length; i++) {
            if (etToCharArray[i] == '+' || etToCharArray[i] == '-'
                    || etToCharArray[i] == '/' || etToCharArray[i] == '*') {
                operatorPosition.add(i);
            }
        }

        for (int i = 0; i < operatorPosition.size(); i++) {
            if (etToCharArray[operatorPosition.get(i) - 1] == '.'
                    || etToCharArray[operatorPosition.get(i) + 1] == '.') {
                result = false;
            }
        }

        ArrayList<Integer> pointPosition = new ArrayList<>();

        for (int i = 0; i < etToCharArray.length; i++) {
            if (etToCharArray[i] == '.') {
                pointPosition.add(i);
            }
        }

        for (int i = 0; i < pointPosition.size(); i++) {
            if (etToCharArray[pointPosition.get(i) - 1] == '.'
                    || etToCharArray[pointPosition.get(i) + 1] == '.') {
                result = false;
            }
        }

        return result;
    }
}
