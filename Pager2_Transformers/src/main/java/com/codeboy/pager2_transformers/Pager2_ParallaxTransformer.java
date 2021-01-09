package com.codeboy.pager2_transformers;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class Pager2_ParallaxTransformer implements ViewPager2.PageTransformer {
    private final int viewToParallax;

    public Pager2_ParallaxTransformer(int viewToParallax) {
        this.viewToParallax = viewToParallax;
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
        int pageWidth = page.getWidth();
        if (position < -1.0F) {
            page.setAlpha(1.0F);
        } else if (position <= 1.0F) {
            page.findViewById(this.viewToParallax).setTranslationX(-position * (float)(pageWidth / 2));
        } else {
            page.setAlpha(1.0F);
        }
    }
}
