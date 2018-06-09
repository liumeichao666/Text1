package com.bwei.text1_lianxi1;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
       private MyTitleView myTitleView;
       private FlowLayout flowLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化页面
        initview();
    }

    private void initview() {
        myTitleView=findViewById(R.id.mytitleview);
        flowLayout=findViewById(R.id.flowlayout);

        //设置监听
        myTitleView.setButtonOnClickListener(new MyTitleView.ButtonOnClickListener() {
            @Override
            public void titleOnClick() {
                //点击标题清空内容
                flowLayout.removeAllViews();
            }

            @Override
            public void buttonleftOnClick() {
                //点击左按钮减少view
                flowLayout.removeViewAt(0);
            }

            @Override
            public void buttonRightOnClick() {
               //点击右按钮增加view
                Button button=new Button(getApplicationContext());
                button.setWidth(100);
                button.setHeight(60);
                flowLayout.addView(button);






/*                button.setText("Fuck off");
                //FlowLayout 继承的是ViewGroup,所以这里用viewgroup
                ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);


                //设置宽度为屏幕的一半
                params.width=getWindowManager().getDefaultDisplay().getWidth()/2;
                //设置高度为屏幕的1/5
                params.height=getWindowManager().getDefaultDisplay().getHeight()/5;
                //添加布局
                flowLayout.addView(button,params);*/


            }
        });
    }


}
