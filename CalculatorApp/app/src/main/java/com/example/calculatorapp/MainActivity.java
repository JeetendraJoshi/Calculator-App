package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.calculatorapp.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private double valueOne = Double.NaN;
    private double valueTwo;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char SQUAREROOT = '√';
    private static final char SQUARE = '^';
    private char CURRENT_ACTION;
    private boolean LastButtonEquals = false;
    private DecimalFormat decimalFormat;
    private double MemoryValue = 0;
    private double FinalAnswer = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decimalFormat = new DecimalFormat("#.##########");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.buttonDot.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                    binding.editText.setText(binding.editText.getText() + ".");
                    LastButtonEquals = false;
            }
        });
        binding.buttonZero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "0");
                LastButtonEquals = false;
            }
        });
        binding.buttonOne.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "1");
                LastButtonEquals = false;
            }
        });
        binding.buttonTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "2");
                LastButtonEquals = false;
            }
        });
        binding.buttonThree.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "3");
                LastButtonEquals = false;
            }
        });
        binding.buttonFour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "4");
                LastButtonEquals = false;
            }
        });
        binding.buttonFive.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "5");
                LastButtonEquals = false;
            }
        });
        binding.buttonSix.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "6");
                LastButtonEquals = false;
            }
        });
        binding.buttonSeven.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "7");
                LastButtonEquals = false;
            }
        });
        binding.buttonEight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "8");
                LastButtonEquals = false;
            }
        });
        binding.buttonNine.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(binding.editText.getText() + "9");
                LastButtonEquals = false;
            }
        });
        binding.buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                binding.infoTextView.setText(decimalFormat.format(valueOne)+ " + ");
                binding.editText.setText(null);
                LastButtonEquals = false;
            }
        });
        binding.buttonSubtract.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                binding.infoTextView.setText(decimalFormat.format(valueOne)+ " - ");
                binding.editText.setText(null);
                LastButtonEquals = false;
            }
        });
        binding.buttonMultiply.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                binding.infoTextView.setText(decimalFormat.format(valueOne)+ " * ");
                binding.editText.setText(null);
                LastButtonEquals = false;
            }
        });
        binding.buttonAns.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                binding.editText.setText(decimalFormat.format(FinalAnswer));
                LastButtonEquals = false;
            }
        });
        binding.buttonDivide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                binding.infoTextView.setText(decimalFormat.format(valueOne)+ " / ");
                binding.editText.setText(null);
                LastButtonEquals = false;
            }
        });
        binding.buttonEqual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (!LastButtonEquals) {
                    computeCalculation();
                    if (CURRENT_ACTION == SQUAREROOT) {
                        binding.infoTextView.setText(String.format(binding.infoTextView.getText().toString() + " = " + decimalFormat.format(valueOne)));
                    }
                    else {
                        binding.infoTextView.setText(String.format(binding.infoTextView.getText().toString() + decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne)));
                    }
                    FinalAnswer = valueOne;
                    binding.editText.setText(null);
                    CURRENT_ACTION = '0';
                    LastButtonEquals = true;
                }
                else{


                }
            }
        });
        binding.buttonSQRT.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                computeCalculation();
                CURRENT_ACTION = SQUAREROOT;
                binding.infoTextView.setText("√" + decimalFormat.format(valueOne) );
                binding.editText.setText(null);
                LastButtonEquals = false;
            }
        });
        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LastButtonEquals = false;

                if(binding.editText.getText().length() > 0) {
                    CharSequence currentText = binding.editText.getText();
                    binding.editText.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    binding.editText.setText("");
                    binding.infoTextView.setText("");
                }

            }

        });
        binding.buttonMPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LastButtonEquals = false;




            }

        });
    }
    private void computeCalculation(){
        if(!Double.isNaN(valueOne)){
            if (CURRENT_ACTION!= SQUAREROOT)
                valueTwo = Double.parseDouble(binding.editText.getText().toString());
            binding.editText.setText(null);
            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUBTRACTION)
                valueOne= this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne*valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne/valueTwo;
            else if (CURRENT_ACTION == SQUAREROOT)
                valueOne = java.lang.Math.sqrt(this.valueOne);
        }
        else{
            try {
                valueOne = Double.parseDouble(binding.editText.getText().toString());
            }
            catch (Exception e){}
        }
    }
}