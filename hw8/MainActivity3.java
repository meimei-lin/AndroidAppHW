package com.example.hw8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        output=(TextView)findViewById(R.id.path3);
        Bundle bundle = this.getIntent().getExtras();
        if(bundle!=null){
            String result = bundle.getString("three");
            output.setText(result+"->3");
        }
    }
    public void onstart3_1(View view){
        Intent intent=new Intent(this, MainActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("one",output.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void onstart3_2(View view){
        Intent intent=new Intent(this, MainActivity2.class);
        Bundle bundle=new Bundle();
        bundle.putString("two",output.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void on_close2(View view){
       finish();
    }
}