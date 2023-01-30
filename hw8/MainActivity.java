package com.example.hw8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView output;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output=(TextView)findViewById(R.id.path);
        Bundle bundle = this.getIntent().getExtras();
        if(bundle!=null){
            String result = bundle.getString("one");
            output.setText(result+"->1");
        }
    }
    public void onstart1_2(View view){
        Intent intent=new Intent(this, MainActivity2.class);
        Bundle bundle=new Bundle();
        bundle.putString("two",output.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void onstart1_3(View view){
        Intent intent=new Intent(this, MainActivity3.class);
        Bundle bundle=new Bundle();
        bundle.putString("three",output.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void on_close(View view){
        finish();
    }
}