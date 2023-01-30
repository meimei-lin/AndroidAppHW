package com.example.hw7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    int count=0;
    ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9;
    TextView order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int [] cb_id={R.id.cb1,R.id.cb2,R.id.cb3,R.id.cb4,R.id.cb5,R.id.cb6,R.id.cb7,R.id.cb8,R.id.cb9};
        for(int id:cb_id){
            ((CheckBox)findViewById(id)).setOnCheckedChangeListener(this);
        }
        iv1=(ImageView) findViewById(R.id.output1);
        iv2=(ImageView) findViewById(R.id.output2);
        iv3=(ImageView) findViewById(R.id.output3);
        iv4=(ImageView) findViewById(R.id.output4);
        iv5=(ImageView) findViewById(R.id.output5);
        iv6=(ImageView) findViewById(R.id.output6);
        iv7=(ImageView) findViewById(R.id.output7);
        iv8=(ImageView) findViewById(R.id.output8);
        iv9=(ImageView) findViewById(R.id.output9);
        order=(TextView) findViewById(R.id.order);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int v;
        if(b){
            count++;
            v=View.VISIBLE;
        }else{
            count--;
            v=View.GONE;
        }

        if(compoundButton.getId()==R.id.cb1){
            iv1.setVisibility(v);
        }
        if(compoundButton.getId()==R.id.cb2){
            iv2.setVisibility(v);
        }else if(compoundButton.getId()==R.id.cb3){
            iv3.setVisibility(v);
        }else if(compoundButton.getId()==R.id.cb4){
            iv4.setVisibility(v);
        }else if(compoundButton.getId()==R.id.cb5){
            iv5.setVisibility(v);
        }else if(compoundButton.getId()==R.id.cb6){
            iv6.setVisibility(v);
        }else if(compoundButton.getId()==R.id.cb7){
            iv7.setVisibility(v);
        }else if(compoundButton.getId()==R.id.cb8){
            iv8.setVisibility(v);
        }else if(compoundButton.getId()==R.id.cb9){
            iv9.setVisibility(v);
        }

        if(count>0){
            order.setText("以下是您點的餐:");
        }else{
            order.setText("請點餐");
        }

    }
}