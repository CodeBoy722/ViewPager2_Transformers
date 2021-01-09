package com.codeboy.pager2_transformers;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;

public class Pager2_TabletTransformer implements ViewPager2.PageTransformer {
    private static final Matrix OFFSET_MATRIX = new Matrix();
    private static final Camera OFFSET_CAMERA = new Camera();
    private static final float[] OFFSET_TEMP_FLOAT = new float[2];

    @Override
    public void transformPage(@NonNull View page, float position) {
        float rotation = (position < 0.0F ? 30.0F : -30.0F) * Math.abs(position);
        page.setTranslationX(getOffsetXForRotation(rotation, page.getWidth(), page.getHeight()));
        page.setPivotX((float)page.getWidth() * 0.5F);
        page.setPivotY(0.0F);
        page.setRotationY(rotation);
    }

    protected static final float getOffsetXForRotation(float degrees, int width, int height) {
        OFFSET_MATRIX.reset();
        OFFSET_CAMERA.save();
        OFFSET_CAMERA.rotateY(Math.abs(degrees));
        OFFSET_CAMERA.getMatrix(OFFSET_MATRIX);
        OFFSET_CAMERA.restore();
        OFFSET_MATRIX.preTranslate((float)(-width) * 0.5F, (float)(-height) * 0.5F);
        OFFSET_MATRIX.postTranslate((float)width * 0.5F, (float)height * 0.5F);
        OFFSET_TEMP_FLOAT[0] = (float)width;
        OFFSET_TEMP_FLOAT[1] = (float)height;
        OFFSET_MATRIX.mapPoints(OFFSET_TEMP_FLOAT);
        return ((float)width - OFFSET_TEMP_FLOAT[0]) * (degrees > 0.0F ? 1.0F : -1.0F);
    }

}
