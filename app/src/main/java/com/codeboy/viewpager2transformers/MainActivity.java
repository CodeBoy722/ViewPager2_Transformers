package com.codeboy.viewpager2transformers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_AccordionTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_AntiClockSpinTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_BackDrawTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_BackgroundToForegroundTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_ClockSpinTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_CubeInDepthTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_CubeInScalingTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_CubeInTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_CubeOutDepthTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_CubeOutScalingTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_CubeOutTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_DefaultTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_DepthTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_FadeOutTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_FanTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_FidgetSpinTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_ForegroundToBackgroundTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_GateTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_HingeTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_HorizontalFlipTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_ParallaxTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_PopTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_RotateDownTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_RotateUpTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_SpinnerTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_StackTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_TabletTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_TossTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_VerticalFlipTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_VerticalShutTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_ZoomInTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_ZoomOutSlideTransformer;
import com.codeboy.viewpager2transformers.Pager2Transformers.Pager2_ZoomOutTransformer;
import com.eftimoff.viewpagertransformers.AccordionTransformer;
import com.eftimoff.viewpagertransformers.BackgroundToForegroundTransformer;
import com.eftimoff.viewpagertransformers.DefaultTransformer;
import com.eftimoff.viewpagertransformers.DepthPageTransformer;
import com.eftimoff.viewpagertransformers.DrawFromBackTransformer;
import com.eftimoff.viewpagertransformers.ForegroundToBackgroundTransformer;
import com.eftimoff.viewpagertransformers.ParallaxPageTransformer;
import com.eftimoff.viewpagertransformers.RotateDownTransformer;
import com.eftimoff.viewpagertransformers.RotateUpTransformer;
import com.eftimoff.viewpagertransformers.StackTransformer;
import com.eftimoff.viewpagertransformers.TabletTransformer;
import com.eftimoff.viewpagertransformers.ZoomInTransformer;
import com.eftimoff.viewpagertransformers.ZoomOutSlideTransformer;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 pager2;
    RadioButton verticalPager;
    RadioButton horizontalPager;
    Spinner transformerSelector;
    ArrayList<ViewPager2.PageTransformer> Transformers;
    ArrayList<String> transformerNameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitViews();
    }

    private void InitViews(){
        Transformers = new ArrayList<>();
        transformerNameList = new ArrayList<>();
        pager2 = findViewById(R.id.pager2);
        transformerSelector = findViewById(R.id.transformer_selector);
        verticalPager = findViewById(R.id.verti);
        horizontalPager = findViewById(R.id.hori);
        AddAllTransformers();
    }


    private void AddAllTransformers(){
        Transformers.add(new Pager2_AccordionTransformer()); transformerNameList.add(Pager2_AccordionTransformer.class.getName());
        Transformers.add(new Pager2_AntiClockSpinTransformer()); transformerNameList.add(Pager2_AntiClockSpinTransformer.class.getName());
        Transformers.add(new Pager2_BackDrawTransformer()); transformerNameList.add(Pager2_BackDrawTransformer.class.getName());
        Transformers.add(new Pager2_BackgroundToForegroundTransformer()); transformerNameList.add(Pager2_BackgroundToForegroundTransformer.class.getName());
        Transformers.add(new Pager2_ClockSpinTransformer()); transformerNameList.add(Pager2_ClockSpinTransformer.class.getName());
        Transformers.add(new Pager2_CubeInDepthTransformer()); transformerNameList.add(Pager2_CubeInDepthTransformer.class.getName());
        Transformers.add(new Pager2_CubeInScalingTransformer()); transformerNameList.add(Pager2_CubeInScalingTransformer.class.getName());
        Transformers.add(new Pager2_CubeInTransformer()); transformerNameList.add(Pager2_CubeInTransformer.class.getName());
        Transformers.add(new Pager2_CubeOutDepthTransformer()); transformerNameList.add(Pager2_CubeOutDepthTransformer.class.getName());
        Transformers.add(new Pager2_CubeOutScalingTransformer()); transformerNameList.add(Pager2_CubeOutScalingTransformer.class.getName());
        Transformers.add(new Pager2_CubeOutTransformer()); transformerNameList.add(Pager2_CubeOutTransformer.class.getName());
        Transformers.add(new Pager2_DefaultTransformer()); transformerNameList.add(Pager2_DefaultTransformer.class.getName());
        Transformers.add(new Pager2_DepthTransformer()); transformerNameList.add(Pager2_DepthTransformer.class.getName());
        Transformers.add(new Pager2_DepthTransformer()); transformerNameList.add(Pager2_DepthTransformer.class.getName());
        Transformers.add(new Pager2_FanTransformer()); transformerNameList.add(Pager2_FanTransformer.class.getName());
        Transformers.add(new Pager2_FidgetSpinTransformer()); transformerNameList.add(Pager2_FidgetSpinTransformer.class.getName());
        Transformers.add(new Pager2_ForegroundToBackgroundTransformer()); transformerNameList.add(Pager2_ForegroundToBackgroundTransformer.class.getName());
        Transformers.add(new Pager2_GateTransformer()); transformerNameList.add(Pager2_GateTransformer.class.getName());
        Transformers.add(new Pager2_HingeTransformer()); transformerNameList.add(Pager2_HingeTransformer.class.getName());
        Transformers.add(new Pager2_HorizontalFlipTransformer()); transformerNameList.add(Pager2_HorizontalFlipTransformer.class.getName());
        Transformers.add(new Pager2_ParallaxTransformer(R.id.page)); transformerNameList.add(Pager2_ParallaxTransformer.class.getName());
        Transformers.add(new Pager2_PopTransformer()); transformerNameList.add(Pager2_PopTransformer.class.getName());
        Transformers.add(new Pager2_RotateDownTransformer()); transformerNameList.add(Pager2_RotateDownTransformer.class.getName());
        Transformers.add(new Pager2_RotateUpTransformer()); transformerNameList.add(Pager2_RotateUpTransformer.class.getName());
        Transformers.add(new Pager2_SpinnerTransformer()); transformerNameList.add(Pager2_SpinnerTransformer.class.getName());
        Transformers.add(new Pager2_StackTransformer()); transformerNameList.add(Pager2_StackTransformer.class.getName());
        Transformers.add(new Pager2_TabletTransformer()); transformerNameList.add(Pager2_TabletTransformer.class.getName());
        Transformers.add(new Pager2_TossTransformer()); transformerNameList.add(Pager2_TossTransformer.class.getName());
        Transformers.add(new Pager2_VerticalFlipTransformer()); transformerNameList.add(Pager2_VerticalFlipTransformer.class.getName());
        Transformers.add(new Pager2_VerticalShutTransformer()); transformerNameList.add(Pager2_VerticalShutTransformer.class.getName());
        Transformers.add(new Pager2_ZoomInTransformer()); transformerNameList.add(Pager2_ZoomInTransformer.class.getName());
        Transformers.add(new Pager2_ZoomOutTransformer()); transformerNameList.add(Pager2_ZoomOutTransformer.class.getName());
        Transformers.add(new Pager2_ZoomOutSlideTransformer()); transformerNameList.add(Pager2_ZoomOutSlideTransformer.class.getName());
    }

}