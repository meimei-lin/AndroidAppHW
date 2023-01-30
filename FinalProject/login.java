package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText useraccount,userpassword;
    Button userregister,signin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        useraccount=(EditText)findViewById(R.id.inputaccount1);
        userpassword=(EditText)findViewById(R.id.inputpassword);
        userregister=(Button)findViewById(R.id.regB);
        signin=(Button)findViewById(R.id.loginB);

    }
    public void onreg(View view){
        Intent intent=new Intent(login.this,register.class);
        startActivity(intent);
    }
    public void onlogin(View view){
        String account=useraccount.getText().toString();
        String password=userpassword.getText().toString();
        SharedPreferences preferences=getSharedPreferences("data",MODE_PRIVATE);
        if (account.equals(preferences.getString("id",""))
                && password.equals(preferences.getString("password",""))&&
                password.equals(preferences.getString("COMpassword",""))){
            SharedPreferences.Editor edit =preferences.edit();
            edit.apply();

            Toast.makeText(login.this,"成功登入",Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(login.this,firstpage.class);
            startActivity(intent);

        } else {
            Toast.makeText(login.this,"登入失敗",Toast.LENGTH_SHORT).show();
        }

    }
}