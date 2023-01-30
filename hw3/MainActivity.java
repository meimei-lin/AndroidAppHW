package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView output;
    int count=0;
    String s="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output = (TextView) findViewById(R.id.btnzero);
    }
    public void settozero(View view){
        count=0;
        s=Integer.toString(count);
        output.setText(s);
    }
    public void btnaddone(View view){
        count++;
        s=Integer.toString(count);
        output.setText(s);
    }
    public void btnaddtwo(View view){
        count=count+2;
        s=Integer.toString(count);
        output.setText(s);
    }
    public void btnsubone(View view){
        count--;
        s=Integer.toString(count);
        if(count<0){
            output.setText(s);
        }
    }
    public void btnsubtwo(View view){
        count=count-2;
        s=Integer.toString(count);
        output.setText(s);
    }

}