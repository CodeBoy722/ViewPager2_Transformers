package com.codeboy.viewpager2transformers.Pager2Transformers;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

class Pager2_TossTransformer implements ViewPager2.PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setTranslationX(-position * page.getWidth());
        page.setCameraDistance(20000);

        if (position < 0.5 && position > -0.5) {
            page.setVisibility(View.VISIBLE);

        } else {
            page.setVisibility(View.INVISIBLE);

        }

        if (position < -1) {     // [-Infinity,-1)
            // This page is way off-screen to the left.
            page.setAlpha(0);

        }
        else if (position <= 0) {    // [-1,0]
            page.setAlpha(1);
            page.setScaleX(Math.max(0.4f, (1 - Math.abs(position))));
            page.setScaleY(Math.max(0.4f, (1 - Math.abs(position))));
            page.setRotationX(1080 * (1 - Math.abs(position) + 1));
            page.setTranslationY(-1000*Math.abs(position));

        }
        else if (position <= 1) {    // (0,1]
            page.setAlpha(1);
            page.setScaleX(Math.max(0.4f, (1-Math.abs(position))));
            page.setScaleY(Math.max(0.4f, (1-Math.abs(position))));
            page.setRotationX(-1080 * (1 - Math.abs(position) + 1));
            page.setTranslationY(-1000*Math.abs(position));

        }
        else {    // (1,+Infinity]
            // This page is way off-screen to the right.
            page.setAlpha(0);

        }
    }
}
