package com.example.hw9;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity{

     Button clear, comfirm;
    EditText userid, password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userid = (EditText) findViewById(R.id.account2);
        password = (EditText) findViewById(R.id.password);
        comfirm = (Button) findViewById(R.id.comfirm);
        clear = (Button) findViewById(R.id.clear);

    }

    public void onclear(View view) {
        userid.setText("");
        password.setText("");
    }

    public void oncomf(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("id", userid.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.apply();

        String str = userid.getText().toString();
        String str1 = password.getText().toString();
        //判斷輸入的值是否為空值
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(Register.this, "帳號不能為空", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(str1)) {
            Toast.makeText(Register.this, "密碼不能為空", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Register.this, "註冊成功!", Toast.LENGTH_SHORT).show();
            //Intent intent1 = new Intent(Register.this, MainActivity.class);
            //startActivity(intent1);
            Intent main1 =new Intent(Register.this,CurrencyConverter.class);
            startActivity(main1);

        }
    }

    public static class CurrencyConverter extends AppCompatActivity implements View.OnClickListener {
        EditText input,inputrate;
        Button convert;
        TextView output;
        RadioGroup rg;
        RadioButton rb1,rb2;
        double rate,money1;
        String s="";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_currency_converter);
            input=(EditText)findViewById(R.id.INPUT);
            inputrate=(EditText)findViewById(R.id.inputrate);
            convert=(Button)findViewById(R.id.convert);
            output=(TextView) findViewById(R.id.output);
            rg=(RadioGroup)findViewById(R.id.rg);
            convert.setOnClickListener(this);
        }
       public void onconvert(View v) {
            double m;
           StringBuffer result = new StringBuffer();
           int money = rg.getCheckedRadioButtonId();
           rg= findViewById(money);
           if (rb1 != null)
           {
               result.append("\n人民幣:\n");
               rate=Double.parseDouble(inputrate.getText().toString());
               money1=Double.parseDouble(input.getText().toString());
               m=money1/rate;
               s=Double.toString(m);
               output.setText(s);
           }


       }
        @Override
        public void onClick(View v) {

        }


    }
}
