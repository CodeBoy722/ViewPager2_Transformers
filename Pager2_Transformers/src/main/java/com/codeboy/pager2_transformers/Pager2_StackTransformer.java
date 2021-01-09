package com.codeboy.pager2_transformers;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class Pager2_StackTransformer implements ViewPager2.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setTranslationX(position < 0.0F ? 0.0F : (float)(-page.getWidth()) * position);
    }
}
