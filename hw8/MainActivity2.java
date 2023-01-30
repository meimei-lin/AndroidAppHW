package com.example.hw8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        output=(TextView)findViewById(R.id.path2);
        Bundle bundle = this.getIntent().getExtras();
        if(bundle!=null){
            String result = bundle.getString("two");
            output.setText(result+"->2");
        }
    }
    public void on_close1(View view){
        finish();
    }
    public void onstart2_3(View view){
        Intent intent=new Intent(this, MainActivity3.class);
        Bundle bundle=new Bundle();
        bundle.putString("three",output.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void onstart2_1(View view){
        Intent intent1=new Intent(this, MainActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("one",output.getText().toString());
        intent1.putExtras(bundle);
        startActivity(intent1);
    }
}