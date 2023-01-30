package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout1);
        NavigationView navigationView = (NavigationView) findViewById(R.id.na_view1);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                int id = item.getItemId();

                if(id==R.id.home){
                    Intent intent1 = new Intent(menu.this, firstpage.class);
                    startActivity(intent1);
                    return true;
                }else if(id==R.id.vm){
                    Intent intent1 = new Intent(menu.this,menu.class);
                    startActivity(intent1);
                    return true;
                }else if(id==R.id.vo){
                    Intent intent1 = new Intent(menu.this,order.class);
                    startActivity(intent1);
                    return true;
                } else if (id == R.id.vl) {
                    Intent intent1 = new Intent(menu.this,cart.class);
                    startActivity(intent1);
                    return true;
                }else if(id==R.id.vout){
                    Intent intent1 = new Intent(menu.this,MainActivity.class);
                    startActivity(intent1);
                    return true;
                }
            return false;
            }
    });
    }
    public void onnext(View view){
        Intent intent1 = new Intent(menu.this, menu2.class);
        startActivity(intent1);
    }

}