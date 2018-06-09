package com.bwei.text1_lianxi1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MyTitleView extends LinearLayout implements View.OnClickListener {

    private View title_viewGroup;
    private TextView texttitle;
    private Button butleft,butright;
    private ButtonOnClickListener ButtonOnClickListener;

    public MyTitleView(Context context) {
        super(context);
    }

    public MyTitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //1.加载布局
        title_viewGroup = inflate(context, R.layout.title_main, this);


        //2.获取子view
        texttitle = title_viewGroup.findViewById(R.id.tv_title);//标题id
        butleft = findViewById(R.id.but_left);
        butright=findViewById(R.id.but_right);

        //3.区获取属性
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MyTitleView, 0, 0);

        //4.根据声明的属性在typeArray里取值
        String title = typedArray.getString(R.styleable.MyTitleView_tv_title);
        int title_color = typedArray.getColor(R.styleable.MyTitleView_tv_color, Color.GREEN);

        String but_left = typedArray.getString(R.styleable.MyTitleView_but_left);
        String but_right = typedArray.getString(R.styleable.MyTitleView_but_right);


        //5.赋值
        texttitle.setText(title);
        texttitle.setTextColor(title_color);

        butleft.setText(but_left);
        butright.setText(but_right);


       //6.设置点击事件
        texttitle.setOnClickListener(this);
        butleft.setOnClickListener(this);
        butright.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but_left:
                ButtonOnClickListener.buttonleftOnClick();
                break;
            case R.id.but_right:
                ButtonOnClickListener.buttonRightOnClick();
                break;
            case R.id.tv_title:
                ButtonOnClickListener.titleOnClick();
                break;

        }
    }


    //7.接口回调
    public interface ButtonOnClickListener{
        void titleOnClick();
        void buttonleftOnClick();
        void buttonRightOnClick();
    }

    //外部访问的方法
    public void setButtonOnClickListener(MyTitleView.ButtonOnClickListener buttonOnClickListener) {
        ButtonOnClickListener = buttonOnClickListener;
    }
}
