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

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class firstpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout0);
        NavigationView navigationView = (NavigationView)findViewById(R.id.na_view0);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                int id = item.getItemId();

                if(id== home){
                    Intent intent1 = new Intent(firstpage.this,firstpage.class);
                    startActivity(intent1);
                    return true;
                }else if(id== vm){
                    Intent intent1 = new Intent(firstpage.this,menu.class);
                    startActivity(intent1);
                    return true;
                }else if(id== vo){
                    Intent intent1 = new Intent(firstpage.this,order.class);
                    startActivity(intent1);
                    return true;
                } else if (id == vl) {
                    Intent intent1 = new Intent(firstpage.this,cart.class);
                    startActivity(intent1);
                    return true;
                }else if(id== vout){
                    Intent intent1 = new Intent(firstpage.this,MainActivity.class);
                    startActivity(intent1);
                    return true;
                }
                return false;
            }
        });
    }
}