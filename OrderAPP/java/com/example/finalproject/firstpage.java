package com.example.finalproject;

import static com.example.finalproject.R.id.home;
import static com.example.finalproject.R.id.vm;
import static com.example.finalproject.R.id.vout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.finalproject.database.SqlOrder;
import com.google.android.material.navigation.NavigationView;

public class firstpage extends AppCompatActivity {
    private  int[]  arrayPicture=new int[]{
            R.drawable.first1,R.drawable.first2};
    private ImageSwitcher imageSwitcher;
    private int  index;
    private  float touchDownX;
    private  float touchUpX;
    private SqlOrder sqlOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        setContentView(R.layout.activity_firstpage);
        sqlOrder = new SqlOrder(this);
        //设置全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageSwitcher=findViewById(R.id.img_switch);
        //设置视图工厂
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView=new ImageView(firstpage.this);
                imageView.setImageResource(arrayPicture[index]);//设置显示图片（利用下标）
                return imageView;//返回图像视图
            }
        });
        //设置触摸监听器
        imageSwitcher.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //判断动作是不是按下  获得按下时的X坐标
                if(event.getAction()==MotionEvent.ACTION_DOWN) {
                    touchDownX=event.getX();
                    return true;
                } else if(event.getAction()==MotionEvent.ACTION_UP) {
                    touchUpX=event.getX();
                    //判断是左滑动还是右滑动
                    if(touchUpX-touchDownX>100){
                        //判断是不是第一张图片 是就将索引变成最后一张图片索引，
                        // 不是则当前索引减一
                        index=index==0?arrayPicture.length-1:index-1;
                        //使用自带的淡入淡出
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(firstpage.this,android.R.anim.fade_in));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(firstpage.this,android.R.anim.fade_out));
                        imageSwitcher.setImageResource(arrayPicture[index]);
                    }else if(touchDownX-touchUpX>100){
                        index=index==arrayPicture.length-1?0:index+1;//注意这里下标是从0开始的，所以应该是长度减1
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(firstpage.this,android.R.anim.fade_in));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(firstpage.this,android.R.anim.fade_out));
                        imageSwitcher.setImageResource(arrayPicture[index]);

                    }
                    return true;
                }
                return false;
            }
        });

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
                }else if(id== vm) {
                    Intent intent1 = new Intent(firstpage.this, menu.class);
                    startActivity(intent1);
                    return true;
                }else if (id == R.id.vr) {
                        Intent intent1 = new Intent(firstpage.this, order_record.class);
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