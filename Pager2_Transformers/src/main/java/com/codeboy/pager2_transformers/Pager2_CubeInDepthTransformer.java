package com.codeboy.pager2_transformers;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class Pager2_CubeInDepthTransformer implements ViewPager2.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setCameraDistance(20000);

        if (position < -1){
            page.setAlpha(0);
        }
        else if (position <= 0){
            page.setAlpha(1);
            page.setPivotX(page.getWidth());
            page.setRotationY(90*Math.abs(position));
        }
        else if (position <= 1){
            page.setAlpha(1);
            page.setPivotX(0);
            page.setRotationY(-90*Math.abs(position));
        }
        else{
            page.setAlpha(0);
        }



        if (Math.abs(position) <= 0.5){
            page.setScaleY(Math.max(.4f,1-Math.abs(position)));
        }
        else if (Math.abs(position) <= 1){
            page.setScaleY(Math.max(.4f,1-Math.abs(position)));

        }

    }
}
