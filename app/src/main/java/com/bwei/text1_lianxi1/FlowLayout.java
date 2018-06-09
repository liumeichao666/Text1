package com.bwei.text1_lianxi1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class FlowLayout extends ViewGroup {
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //测量宽高的方法
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //1.测量所有孩子的宽高
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        //2。
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heigghtMode = MeasureSpec.getMode(heightMeasureSpec);


        //3.
        int width = 0;
        int height = 0;
        int lineWidth = 0;
        int lineHeight = 0;
        int totalHeight = 0;
        View childView;
        int childWidth = 0;
        int childHeight = 0;

        //4.遍历
        for (int i = 0; i <getChildCount() ; i++) {
            childView=getChildAt(i);//获得孩子组件
            childWidth = childView.getMeasuredWidth();//获得孩子宽
            width=2*childWidth;
            childHeight=childView.getMeasuredHeight();//获得孩子高
            //判断在左还是在右
            if(i%2==0){
                totalHeight+=lineHeight;
                //模为0的都是第一个,所以行宽赋0
                lineHeight=childHeight;
                lineWidth=childWidth;

            }else{
                totalHeight+=lineHeight;
                //模为1的都是第二个 所以行宽为累加
                lineWidth+=childWidth;
                lineHeight=childHeight;

            }

            if(i==getChildCount()-1){
                 totalHeight+=lineHeight;
                 height=totalHeight;
            }
        }

        //模式的判断
        width = widthMode == MeasureSpec.EXACTLY ? widthSize : width;
        height = heigghtMode == MeasureSpec.EXACTLY ? heightSize : height;
        //设置测量的宽高
        setMeasuredDimension(width,height);


    }



    @Override
    protected void onLayout(boolean bo, int left, int top, int right, int bottom) {

        int lineWidth = 0;
        int lineHeight = 0;
        int totalHeight = 0;
        View childView;
        int childWidth = 0;
        int childHeight = 0;

        //4.遍历
        for (int i = 0; i <getChildCount() ; i++) {
            childView=getChildAt(i);//获得孩子组件

            childWidth = childView.getMeasuredWidth();//获得孩子宽
            childHeight=childView.getMeasuredHeight();//获得孩子高
            //判断在左还是在右
            if(i%2==0){
                totalHeight+=lineHeight;
                //模为0的都是第一个,所以行宽赋0
                lineWidth=0;
                childViewLayout(childView,lineWidth,totalHeight,lineWidth+childWidth,totalHeight+childHeight);
                lineHeight=childHeight;
                lineWidth=childWidth;

            }else{
                totalHeight+=lineHeight;
                //模为1的都是第二个 所以行宽为累加
                childViewLayout(childView,lineWidth,totalHeight,lineWidth+childWidth,totalHeight+childHeight);
                lineWidth+=childWidth;
                lineHeight=childHeight;

            }
        }


    }


    private void childViewLayout(View childView, int l, int t, int r, int b) {
      childView.layout(l,t,r,b);


    }

}
