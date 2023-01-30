package com.example.hw9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText useraccount,userpassword;
    Button userregister,signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        useraccount=(EditText)findViewById(R.id.useraccount);
        userpassword=(EditText)findViewById(R.id.userpassword);
        userregister=(Button)findViewById(R.id.userregister);
        signin=(Button)findViewById(R.id.signin);

    }
    public void onreg(View view){
        Intent main =new Intent(MainActivity.this,Register.class);
        startActivity(main);
    }
    public void onsign(View view){
        String account=useraccount.getText().toString();
        String password=userpassword.getText().toString();
        SharedPreferences preferences=getSharedPreferences("data",MODE_PRIVATE);
        if (account.equals(preferences.getString("id",""))
                && password.equals(preferences.getString("password",""))){
            SharedPreferences.Editor edit =preferences.edit();
            edit.apply();

            //是的話顯示成功登入
            Toast.makeText(MainActivity.this,"成功登入",Toast.LENGTH_SHORT).show();
            Intent main1 =new Intent(MainActivity.this, Register.CurrencyConverter.class);
            startActivity(main1);

        } else {
            //不是則顯示登入失敗
            Toast.makeText(MainActivity.this,"登入失敗",Toast.LENGTH_SHORT).show();
        }

    }}
