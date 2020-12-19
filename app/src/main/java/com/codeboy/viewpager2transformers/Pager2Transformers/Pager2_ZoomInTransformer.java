package com.codeboy.viewpager2transformers.Pager2Transformers;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class Pager2_ZoomInTransformer implements ViewPager2.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        float scale = position < 0.0F ? position + 1.0F : Math.abs(1.0F - position);
        page.setScaleX(scale);
        page.setScaleY(scale);
        page.setPivotX((float)page.getWidth() * 0.5F);
        page.setPivotY((float)page.getHeight() * 0.5F);
        page.setAlpha(position >= -1.0F && position <= 1.0F ? 1.0F - (scale - 1.0F) : 0.0F);
    }
}
