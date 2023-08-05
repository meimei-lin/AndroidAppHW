package com.example.hw9_1;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public  class currency_converter<CREATE> extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,AdapterView.OnItemClickListener{
        static final String DATABASE_NAME="DBmoney";
        static final String TABLE_NAME="TBmoney";
        static final String[] FROM={"class1","rate"};
        SQLiteDatabase db;
        SimpleCursorAdapter adapter;
        Cursor cursor;
        ListView li;
        EditText inputMon,inputUSrate,inputCHArate;
        TextView output;
        RadioGroup rg;
        RadioButton rb1,rb2;
        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_currency_converter);
            inputMon=(EditText)findViewById(R.id.inputmoney);
            inputUSrate=(EditText)findViewById(R.id.inputUSrate);
            inputCHArate=(EditText)findViewById(R.id.inputCHArate);
            rb1=(RadioButton)findViewById(R.id.rb1);
            rb2=(RadioButton)findViewById(R.id.rb2);
            rg=(RadioGroup)findViewById(R.id.rg);
            rg.setOnCheckedChangeListener(this);
            output=(TextView) findViewById(R.id.output);
            db = openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                    "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "class1 VARCHAR(32), " +
                    "rate VARCHAR(16))");
            cursor=db.rawQuery(" SELECT * FROM "+TABLE_NAME,null);
           if(cursor.getCount() == 0){
                insertData("美金","30.80");
                insertData("人民幣","4.42");
                cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
            }
            adapter = new SimpleCursorAdapter(this,
                    R.layout.activity_ratedata, cursor, FROM, new int[] {R.id.class1,R.id.rate}, 0);
            li= (ListView)findViewById(R.id.list1);
            li.setAdapter(adapter);
            li.setOnItemClickListener((AdapterView.OnItemClickListener) this);
            SQLQuery();

        }
    public void onStop() {
        super.onStop();
        db.close();
    }
    public void insertData(String class1,String rate){
        ContentValues cv=new ContentValues();
        cv.put(FROM[0],class1);
        cv.put(FROM[1],rate);
        db.insert(TABLE_NAME,null,cv);
    }
    public void SQLQuery(){
        cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        adapter.changeCursor(cursor);
    }
    public void updateData(String class1,String rate,int id){
            ContentValues cv=new ContentValues();
            cv.put(FROM[0],class1);
            cv.put(FROM[1],rate);
            if(class1.equals("美金")){
                db.update(TABLE_NAME,cv,"_id="+id,null);
                Toast.makeText(currency_converter.this, "修改匯率成功",Toast.LENGTH_SHORT).show();
            }
            else{
                db.update(TABLE_NAME,cv,"_id="+id,null);
                Toast.makeText(currency_converter.this, "修改匯率成功",Toast.LENGTH_SHORT).show();
            }
    }
    @SuppressLint("Range")
    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

        if(cursor.getString(cursor.getColumnIndex(FROM[0])).equals("美金")) {
            inputUSrate.setText(cursor.getString(cursor.getColumnIndex(FROM[1])));
        }
        else{
            inputCHArate.setText(cursor.getString(cursor.getColumnIndex(FROM[1])));
        }

    }
    public void onUScomf(View view){
            if (!inputUSrate.getText().toString().trim().equals("")) {
                cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
                cursor.moveToFirst();
                updateData("美金",inputUSrate.getText().toString().trim() , cursor.getInt(0));
                SQLQuery();

            }
           else{
               output.setText("輸入請勿空白");
            }
    }
    public void onUSclear(View view){
        inputUSrate.setText("");
    }
    public void onCHAcomf(View view){
       if (!inputCHArate.getText().toString().trim().equals("")) {
           cursor=db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
           cursor.moveToFirst();
           cursor.moveToNext();
           updateData("人民幣",inputCHArate.getText().toString().trim() , cursor.getInt(0));
           SQLQuery();
       }
       else{
           output.setText("輸入請勿空白");
       }
    }
   public void onCHAclear(View view){
       inputCHArate.setText("");
    }
   public void onconvert(View view) {
        cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        double money = Double.parseDouble(inputMon.getText().toString().trim());
        double newmon = 0;
        if (rb1.isChecked()) {
            if (cursor.moveToFirst()) {
                @SuppressLint("Range") String USrate = cursor.getString(cursor.getColumnIndex(FROM[1])).trim();
                double ans = Double.parseDouble(USrate);
                newmon = money * ans;
                DecimalFormat df = new DecimalFormat();
                String s = df.format(newmon);
                output.setText("可兌換新台幣" + s);

            }
        }else {
            if (cursor.moveToFirst()) {
                cursor.moveToNext();
                @SuppressLint("Range") String CHArate = cursor.getString(cursor.getColumnIndex(FROM[1])).trim();
                double ans = Double.parseDouble(CHArate);
                newmon = money * ans;
                DecimalFormat df = new DecimalFormat();
                String s = df.format(newmon);
                output.setText("可兌換新台幣" + s);
            }
        }
    }
    public void onOut(View view){
        Intent intent=new Intent(currency_converter.this,MainActivity.class);
        startActivity(intent);
    }

        @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        }

    }
