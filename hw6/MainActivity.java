package com.example.hw6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener,
        View.OnTouchListener, RadioGroup.OnCheckedChangeListener,TextWatcher{
        EditText input1;
        RadioGroup rg1;
        String s="";
        View myrelative;
        int num=0;
        float x1=0,x2=0;

    @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1=(RadioGroup) findViewById(R.id.rg1);
        rg1.setOnCheckedChangeListener(this);
        input1=(EditText)findViewById(R.id.inputT);
        input1.addTextChangedListener(this);
        myrelative=(View)findViewById(R.id.myrelative);
        myrelative.setOnTouchListener(this);
        myrelative.setOnLongClickListener(this);
    }
    @Override
    public boolean onLongClick(View v) {
        myrelative.setBackgroundColor(Color.rgb(255, 255, 255));
        return true;
    }
    private void temper(){
        TextView output1 = findViewById(R.id.textC);
        TextView output2 = findViewById(R.id.textF);
        double t,t1;
        if(rg1.getCheckedRadioButtonId()==R.id.rbT1) {
            if (input1.getText().toString().length() == 0) {
                return;
            } else {
                t1 = Double.parseDouble(input1.getText().toString());
                t = (t1 - 32) * 5 / 9;
                NumberFormat ddf1=NumberFormat.getNumberInstance();
                ddf1.setMaximumFractionDigits(2);
                s= ddf1.format(t);
                output1.setText(s + "°C");
                output2.setText(input1.getText()+"°F");
            }
        }else if(rg1.getCheckedRadioButtonId()==R.id.rbT2){
            if (input1.getText().toString().length() ==0){
                return;
            }else{
                t1=Double.parseDouble(input1.getText().toString());
                t=t1*9/5+32;
                NumberFormat ddf1=NumberFormat.getNumberInstance();
                ddf1.setMaximumFractionDigits(2);
                s= ddf1.format(t);
                output2.setText(s+"°F");
                output1.setText(input1.getText()+"°C");
            }
        }
    }

    public void onCheckedChanged(RadioGroup radioGroup,int i){
        temper();
        }
    @Override
    public void afterTextChanged(Editable editable) {
        temper();
    }
    @Override
    public void onClick(View view) {

    }



    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Random x=new Random();
        int colorR=0,colorG=0,colorB=0;
        colorR=x.nextInt(256);
        colorG=x.nextInt(256);
        colorB=x.nextInt(256);
        if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
            x1=Float.valueOf(motionEvent.getX());//motionEvent.getX();
        }else if(motionEvent.getAction()==MotionEvent.ACTION_UP)//當手指離開時
        {
            x2=Float.valueOf(motionEvent.getX());//motionEvent.getX();

            if(x1-x2>0){
                num=num+2;
                myrelative.setBackgroundColor(Color.rgb(colorR,colorG,colorB));
            }
            else if(x1-x2<0){
                num=num-2;
                myrelative.setBackgroundColor(Color.rgb(colorR,colorG,colorB));
            }

        }
        return false;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }



}

