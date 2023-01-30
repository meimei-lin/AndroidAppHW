package com.example.finalproject;

import static com.example.finalproject.R.*;
import static com.example.finalproject.R.id.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class menu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_menu2);

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout2);
        NavigationView navigationView = (NavigationView)findViewById(R.id.na_view2);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                int id = item.getItemId();

                if(id== home){
                    Intent intent1 = new Intent(menu2.this,firstpage.class);
                    startActivity(intent1);
                    return true;
                }else if(id== vm){
                    Intent intent1 = new Intent(menu2.this,menu.class);
                    startActivity(intent1);
                    return true;
                }else if(id== vo){
                    Intent intent1 = new Intent(menu2.this,order.class);
                    startActivity(intent1);
                    return true;
                } else if (id == vl) {
                    Intent intent1 = new Intent(menu2.this,cart.class);
                    startActivity(intent1);
                    return true;
                }else if(id== vout){
                    Intent intent1 = new Intent(menu2.this,MainActivity.class);
                    startActivity(intent1);
                    return true;
                }
                return false;
            }
        });
    }
    public void onprepage1(View view){
        Intent intent1 = new Intent(menu2.this, menu.class);
        startActivity(intent1);
    }
}