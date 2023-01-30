package com.example.hw5;

import static com.example.hw5.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnLongClickListener {
    EditText input1,input2;
    TextView output1;
    String s="",s1="",s2="";
    Button b;
    //View view;
    RelativeLayout l;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        input1 = (EditText)findViewById(id.heightIn);
        input2=(EditText)findViewById(id.weightIn);
        output1=(TextView)findViewById(id.bmiOutput);
        b=(Button) findViewById(id.btn1);
        b.setOnLongClickListener(this);
        //view=(View) findViewById(id.view);
        //view.setOnLongClickListener(this);
        l=(RelativeLayout) findViewById(id.relative);
        l.setOnLongClickListener(this);

    }
    public void bmi(View view){
       double height =Double.parseDouble(input1.getText().toString());
       double weight =Double.parseDouble(input2.getText().toString());
       height *= 0.01;
       double bmi1=weight/(height*height);
       s=Double.toString(bmi1);
       output1.setText(s);
    }
    public void clear(View view){
        input1.setText(null);
        input2.setText(null);
        output1.setText(null);
    }

    @Override
    public boolean onLongClick(View view) {
        b.setBackgroundColor(Color.rgb(255,255,255));
        //view.setBackgroundColor(Color.rgb(255,255,255));
        l.setBackgroundColor(Color.rgb(255,255,255));
        return true;
    }
}