package com.example.finalproject;

import static com.example.finalproject.R.id.home;
import static com.example.finalproject.R.id.vl;
import static com.example.finalproject.R.id.vm;
import static com.example.finalproject.R.id.vo;
import static com.example.finalproject.R.id.vout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.navigation.NavigationView;

public class order extends AppCompatActivity  {
    Button btn_add[]=new Button[11];
    Button btn_sub[]=new Button[11];
    Button btn_send;
    TextView num[]=new TextView[11];
    TextView tv[]=new TextView[11];
    int add[]={R.id.f1addB,R.id.f2addB,R.id.f3addB,R.id.f4addB,R.id.f5addB,R.id.f6addB,R.id.d1addB,R.id.d2addB
    ,R.id.d3addB,R.id.d4addB,R.id.d5addB};
    int sub[]={R.id.f1subB,R.id.f2subB,R.id.f3subB,R.id.f4subB,R.id.f5subB,R.id.f6subB,R.id.d1subB,R.id.d2subB
            ,R.id.d3subB,R.id.d4subB,R.id.d5subB};
    int number[]={R.id.f1amount,R.id.f2amount,R.id.f3amount,R.id.f4amount,R.id.f5amount,R.id.f6amount,
            R.id.d1amount,R.id.d2amount,R.id.d3amount,R.id.d4amount,R.id.d5amount};
    TextView tv_f1,tv_f2,tv_f3,tv_f4,tv_f5,tv_f6,tv_d1,tv_d2,tv_d3,tv_d4,tv_d5;
    int e[] = {0,0,0,0,0,0,0,0,0,0,0};
    String s="";
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        btn_send=(Button)findViewById(R.id.sendB);

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout3);
        NavigationView navigationView = (NavigationView)findViewById(R.id.na_view3);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                int id = item.getItemId();

                if(id== home){
                    Intent intent1 = new Intent(order.this,firstpage.class);
                    startActivity(intent1);
                    return true;
                }else if(id== vm){
                    Intent intent1 = new Intent(order.this,menu.class);
                    startActivity(intent1);
                    return true;
                }else if(id== vo){
                    Intent intent1 = new Intent(order.this,order.class);
                    startActivity(intent1);
                    return true;
                } else if (id == vl) {
                    Intent intent1 = new Intent(order.this,cart.class);
                    startActivity(intent1);
                    return true;
                }else if(id== vout){
                    Intent intent1 = new Intent(order.this,MainActivity.class);
                    startActivity(intent1);
                    return true;
                }
                return false;
            }
        });
        for (int i = 0; i < btn_add.length; i++) {
            btn_add[i]= (Button) this.findViewById(add[i]);
            btn_sub[i]= (Button) this.findViewById(sub[i]);
            num[i] = (TextView) this.findViewById(number[i]);
            tv_f1=(TextView)findViewById(R.id.f1);
            tv_f2=(TextView)findViewById(R.id.f2);
            tv_f3=(TextView)findViewById(R.id.f3);
            tv_f4=(TextView)findViewById(R.id.f4);
            tv_f5=(TextView)findViewById(R.id.f5);
            tv_f6=(TextView)findViewById(R.id.f6);
            tv_d1=(TextView)findViewById(R.id.d1);
            tv_d2=(TextView)findViewById(R.id.d2);
            tv_d3=(TextView)findViewById(R.id.d3);
            tv_d4=(TextView)findViewById(R.id.d4);
            tv_d5=(TextView)findViewById(R.id.d5);
        }
    }
    public void onadd(View view){
        for(int i=0 ;i<btn_add.length ; i++){
            if(view==btn_add[i]){
                e[i]++;
                s = Integer.toString(e[i]);
                num[i].setText(s);
            }
        }
    }
    public void onsub(View view){
        for(int i=0 ;i<btn_sub.length ; i++){
            if(view==btn_sub[i]){
                if(e[i]>0){
                    e[i]--;
                    s = Integer.toString(e[i]);
                    num[i].setText(s);
                }
            }
        }
    }
   public void onsend(View view){
        Bundle bundle1=new Bundle();Bundle bundle2=new Bundle();Bundle bundle3=new Bundle();Bundle bundle4=new Bundle();
        Bundle bundle5=new Bundle();Bundle bundle6=new Bundle();Bundle bundle7=new Bundle();Bundle bundle8=new Bundle();
        Bundle bundle9=new Bundle();Bundle bundle10=new Bundle();Bundle bundle11=new Bundle();
        bundle1.putString("f1",tv_f1.getText().toString());bundle1.putString("f1a",num[0].getText().toString());
        bundle2.putString("f2",tv_f2.getText().toString());bundle2.putString("f2a",num[1].getText().toString());
        bundle3.putString("f3",tv_f3.getText().toString());bundle3.putString("f3a",num[2].getText().toString());
        bundle4.putString("f4",tv_f4.getText().toString());bundle4.putString("f4a",num[3].getText().toString());
        bundle5.putString("f5",tv_f5.getText().toString());bundle5.putString("f5a",num[4].getText().toString());
        bundle6.putString("f6",tv_f6.getText().toString());bundle6.putString("f6a",num[5].getText().toString());
        bundle7.putString("d1",tv_d1.getText().toString());bundle7.putString("d1a",num[6].getText().toString());
        bundle8.putString("d2",tv_d2.getText().toString());bundle8.putString("d2a",num[7].getText().toString());
        bundle9.putString("d3",tv_d3.getText().toString());bundle9.putString("d3a",num[8].getText().toString());
        bundle10.putString("d4",tv_d4.getText().toString());bundle10.putString("d4a",num[9].getText().toString());
        bundle11.putString("d5",tv_d5.getText().toString());bundle11.putString("d5a",num[10].getText().toString());
        Intent intent1=new Intent(this,cart.class);
        intent1.putExtras(bundle1);intent1.putExtras(bundle2);intent1.putExtras(bundle3);intent1.putExtras(bundle4);
        intent1.putExtras(bundle5);intent1.putExtras(bundle6);intent1.putExtras(bundle7);intent1.putExtras(bundle8);
        intent1.putExtras(bundle9);intent1.putExtras(bundle10);intent1.putExtras(bundle11);
        startActivity(intent1);

    }
    public void onprepage2(View view){
        Intent intent1 = new Intent(this, menu2.class);
        startActivity(intent1);
    }


    }