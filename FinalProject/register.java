package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity implements View.OnClickListener {
    private Button clear,comfirm;
    private EditText userid,userpasswd,userpasswd1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userid=(EditText)findViewById(R.id.inputaccount);
        userpasswd= (EditText) findViewById(R.id.inputpassword1);
        userpasswd1= (EditText) findViewById(R.id.inputpassword2);
        comfirm=(Button)findViewById(R.id.comfB);
        clear=(Button)findViewById(R.id.clearB);

        comfirm.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.comfB) {
            SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("id", userid.getText().toString());
            editor.putString("password", userpasswd.getText().toString());
            editor.putString("COMpassword", userpasswd1.getText().toString());
            editor.apply();

            String str = userid.getText().toString();
            String str1 = userpasswd.getText().toString();
            String str2 = userpasswd1.getText().toString();
            if (TextUtils.isEmpty(str)) {
                Toast.makeText(register.this, "請輸入帳號", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(str1)) {
                Toast.makeText(register.this, "請輸入密碼", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(str2)) {
                Toast.makeText(register.this, "確認密碼不能為空", Toast.LENGTH_SHORT).show();
            } else if(str2.length()<8){
                Toast.makeText(register.this, "密碼太短了喔!", Toast.LENGTH_SHORT).show();
            } else if (str1.equals(str2)) {
                Toast.makeText(register.this, "註冊成功!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(register.this, login.class);
                startActivity(intent1);
            }
            else{
                Toast.makeText(register.this, "密碼不相同，請重新輸入", Toast.LENGTH_SHORT).show();
            }
        }else if (v.getId() == R.id.clearB) {
                userid.setText("");
                userpasswd.setText("");
                userpasswd1.setText("");
            } else {
                Toast.makeText(register.this, "錯誤!", Toast.LENGTH_SHORT).show();
            }

    }
}