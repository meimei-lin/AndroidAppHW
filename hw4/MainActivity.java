package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random x=new Random();
    TextView output,output1,output2,output3;
    String s="";
    int colorR=0,colorG=0,colorB=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output=(TextView)findViewById(R.id.text);
        output1=(TextView)findViewById(R.id.textR);
        output2=(TextView)findViewById(R.id.textG);
        output3=(TextView)findViewById(R.id.textB);
    }
    public void setR(View view){
        colorR=x.nextInt(256);
        s=Integer.toString(colorR);
        output.setText("");
        output1.setText(s);
        output1.setTextColor(Color.rgb(colorR,colorG,colorB));

    }
    public void setG(View view){
        colorG=x.nextInt(256);
        s=Integer.toString(colorG);
        output.setText("");
        output2.setText(s);
        output2.setTextColor(Color.rgb(colorR,colorG,colorB));
    }
    public void setB(View view){
        colorB=x.nextInt(256);
        s=Integer.toString(colorB);
        output.setText("");
        output3.setText(s);
        output3.setTextColor(Color.rgb(colorR,colorG,colorB));
    }
    public void setS(View view){
        output1.setTextColor(Color.rgb(colorR,colorG,colorB));
        output2.setTextColor(Color.rgb(colorR,colorG,colorB));
        output3.setTextColor(Color.rgb(colorR,colorG,colorB));
    }
}