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

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class cart extends AppCompatActivity {
    String sf1,sf1a,sf2,sf2a,sf3,sf3a,sf4,sf4a,sf5,sf5a,sf6,sf6a,sd1,sd1a,sd2,sd2a,sd3,sd3a,sd4,sd4a,sd5,sd5a;
    TextView tv_money;
    TextView tv_item[]=new TextView[11];
    TextView tv_amount[]=new TextView[11];
    int item[]={R.id.item,R.id.item1,R.id.item2,R.id.item3,R.id.item4,R.id.item5,R.id.item6,R.id.item7,R.id.item8,
            R.id.item9,R.id.item10};
    int number[]={R.id.amount,R.id.amount1,R.id.amount2,R.id.amount3,R.id.amount4,R.id.amount5,R.id.amount6,
            R.id.amount7,R.id.amount8,R.id.amount9,R.id.amount10};
    int moneyTotal,mon1,mon2,mon3,mon4,mon5,mon6,mon7,mon8,mon9,mon10,mon11;
    @SuppressLint({"MissingInflatedId", "Range"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        tv_money=(TextView)findViewById(R.id.tv_money);



        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout4);
        NavigationView navigationView = (NavigationView)findViewById(R.id.na_view4);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                int id = item.getItemId();

                if(id== home){
                    Intent intent1 = new Intent(cart.this,firstpage.class);
                    startActivity(intent1);
                    return true;
                }else if(id== vm){
                    Intent intent1 = new Intent(cart.this,menu.class);
                    startActivity(intent1);
                    return true;
                }else if(id== vo){
                    Intent intent1 = new Intent(cart.this,order.class);
                    startActivity(intent1);
                    return true;
                } else if (id == vl) {
                    Intent intent1 = new Intent(cart.this,cart.class);
                    startActivity(intent1);
                    return true;
                }else if(id== vout){
                    Intent intent1 = new Intent(cart.this,MainActivity.class);
                    startActivity(intent1);
                    return true;
                }
                return false;
            }
        });
        for(int i=0;i<tv_item.length;i++){
            tv_item[i]=(TextView)this.findViewById(item[i]);
            tv_amount[i]=(TextView) this.findViewById(number[i]);
        }
        Bundle bundle=this.getIntent().getExtras();
        if(bundle!=null){

            sf1=bundle.getString("f1");sf1a= bundle.getString("f1a");
            sf2=bundle.getString("f2");sf2a=bundle.getString("f2a");
            sf3=bundle.getString("f3");sf3a=bundle.getString("f3a");
            sf4=bundle.getString("f4");sf4a=bundle.getString("f4a");
            sf5=bundle.getString("f5");sf5a=bundle.getString("f5a");
            sf6=bundle.getString("f6");sf6a=bundle.getString("f6a");
            sd1=bundle.getString("d1");sd1a=bundle.getString("d1a");
            sd2=bundle.getString("d2");sd2a=bundle.getString("d2a");
            sd3=bundle.getString("d3");sd3a=bundle.getString("d3a");
            sd4=bundle.getString("d4");sd4a=bundle.getString("d4a");
            sd5=bundle.getString("d5");sd5a=bundle.getString("d5a");
            if(Integer.parseInt(bundle.getString("f1a"))!=0){
                tv_item[0].setText(sf1);tv_amount[0].setText("*"+sf1a);
            }
            if(Integer.parseInt(bundle.getString("f2a"))!=0){
                tv_item[1].setText(sf2);tv_amount[1].setText("*"+sf2a);
            }
            if(Integer.parseInt(bundle.getString("f3a"))!=0){
                tv_item[2].setText(sf3);tv_amount[2].setText("*"+sf3a);
            }
            if(Integer.parseInt(bundle.getString("f4a"))!=0) {
                tv_item[3].setText(sf4);tv_amount[3].setText("*"+sf4a);
            }
            if(Integer.parseInt(bundle.getString("f5a"))!=0){
                tv_item[4].setText(sf5);tv_amount[4].setText("*"+sf5a);
            }
            if(Integer.parseInt(bundle.getString("f6a"))!=0){
                tv_item[5].setText(sf6);tv_amount[5].setText("*"+sf6a);
            }
            if(Integer.parseInt(bundle.getString("d1a"))!=0){
                tv_item[6].setText(sd1);tv_amount[6].setText("*"+sd1a);
            }
            if(Integer.parseInt(bundle.getString("d2a"))!=0){
                tv_item[7].setText(sd2);tv_amount[7].setText("*"+sd2a);
            }
            if(Integer.parseInt(bundle.getString("d3a"))!=0){
                tv_item[8].setText(sd3);tv_amount[8].setText("*"+sd3a);
            }
            if(Integer.parseInt(bundle.getString("d4a"))!=0){
                tv_item[9].setText(sd4);tv_amount[9].setText("*"+sd4a);
            }
            if(Integer.parseInt(bundle.getString("d5a"))!=0){
                tv_item[10].setText(sd5);tv_amount[10].setText("*"+sd5a);
            }

            mon1=Integer.parseInt(bundle.getString("f1a"));
            mon1*=90;
            mon2=Integer.parseInt(bundle.getString("f2a"));
            mon2*=90;
            mon3=Integer.parseInt(bundle.getString("f3a"));
            mon3*=100;
            mon4=Integer.parseInt(bundle.getString("f4a"));
            mon4*=120;
            mon5=Integer.parseInt(bundle.getString("f5a"));
            mon5*=90;
            mon6=Integer.parseInt(bundle.getString("f6a"));
            mon6*=100;
            mon7=Integer.parseInt(bundle.getString("d1a"));
            mon7*=120;
            mon8=Integer.parseInt(bundle.getString("d2a"));
            mon8*=100;
            mon9=Integer.parseInt(bundle.getString("d3a"));
            mon9*=100;
            mon10=Integer.parseInt(bundle.getString("d4a"));
            mon10*=120;
            mon11=Integer.parseInt(bundle.getString("d5a"));
            mon11*=120;

            moneyTotal=mon1+mon2+mon3+mon4+mon5+mon6+mon7+mon8+mon9+mon10+mon11;
            tv_money.setText("$"+ Integer.toString(moneyTotal));

        }
    }
    public void onprepage3(View view){
        Intent intent1 = new Intent(this, order.class);
        startActivity(intent1);
    }
}