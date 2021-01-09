package com.codeboy.pager2_transformers;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class Pager2_BackDrawTransformer implements ViewPager2.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {

        int pageWidth = page.getWidth();
        if (position >= -1.0F && position <= 1.0F) {
            float v;
            if (position <= 0.0F) {
                page.setAlpha(1.0F + position);
                page.setTranslationX((float)pageWidth * -position);
                v = 0.75F + 0.25F * (1.0F - Math.abs(position));
                page.setScaleX(v);
                page.setScaleY(v);
            } else if ((double)position > 0.5D && position <= 1.0F) {
                page.setAlpha(0.0F);
                page.setTranslationX((float)pageWidth * -position);
            } else if ((double)position > 0.3D && (double)position <= 0.5D) {
                page.setAlpha(1.0F);
                page.setTranslationX((float)pageWidth * position);
                v = 0.75F;
                page.setScaleX(v);
                page.setScaleY(v);
            } else {
                if ((double)position <= 0.3D) {
                    page.setAlpha(1.0F);
                    page.setTranslationX((float)pageWidth * position);
                    v = (float)(0.3D - (double)position);
                    v = Math.min(v, 0.25F);
                    float scaleFactor = 0.75F + v;
                    page.setScaleX(scaleFactor);
                    page.setScaleY(scaleFactor);
                }

            }
        } else {
            page.setAlpha(0.0F);
        }

    }
}
