package com.codeboy.pager2_transformers;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class Pager2_RotateUpTransformer implements ViewPager2.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        float width = (float)page.getWidth();
        float rotation = -15.0F * position;
        page.setPivotX(width * 0.5F);
        page.setPivotY(0.0F);
        page.setTranslationX(0.0F);
        page.setRotation(rotation);
    }
}
