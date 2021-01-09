package com.codeboy.viewpager2transformers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.codeboy.pager2_transformers.Pager2_AccordionTransformer;
import com.codeboy.pager2_transformers.Pager2_AntiClockSpinTransformer;
import com.codeboy.pager2_transformers.Pager2_BackDrawTransformer;
import com.codeboy.pager2_transformers.Pager2_BackgroundToForegroundTransformer;
import com.codeboy.pager2_transformers.Pager2_ClockSpinTransformer;
import com.codeboy.pager2_transformers.Pager2_CubeInDepthTransformer;
import com.codeboy.pager2_transformers.Pager2_CubeInScalingTransformer;
import com.codeboy.pager2_transformers.Pager2_CubeInTransformer;
import com.codeboy.pager2_transformers.Pager2_CubeOutDepthTransformer;
import com.codeboy.pager2_transformers.Pager2_CubeOutScalingTransformer;
import com.codeboy.pager2_transformers.Pager2_CubeOutTransformer;
import com.codeboy.pager2_transformers.Pager2_DefaultTransformer;
import com.codeboy.pager2_transformers.Pager2_DepthTransformer;
import com.codeboy.pager2_transformers.Pager2_FanTransformer;
import com.codeboy.pager2_transformers.Pager2_FidgetSpinTransformer;
import com.codeboy.pager2_transformers.Pager2_ForegroundToBackgroundTransformer;
import com.codeboy.pager2_transformers.Pager2_GateTransformer;
import com.codeboy.pager2_transformers.Pager2_HingeTransformer;
import com.codeboy.pager2_transformers.Pager2_HorizontalFlipTransformer;
import com.codeboy.pager2_transformers.Pager2_ParallaxTransformer;
import com.codeboy.pager2_transformers.Pager2_PopTransformer;
import com.codeboy.pager2_transformers.Pager2_RotateDownTransformer;
import com.codeboy.pager2_transformers.Pager2_RotateUpTransformer;
import com.codeboy.pager2_transformers.Pager2_SpinnerTransformer;
import com.codeboy.pager2_transformers.Pager2_StackTransformer;
import com.codeboy.pager2_transformers.Pager2_TabletTransformer;
import com.codeboy.pager2_transformers.Pager2_TossTransformer;
import com.codeboy.pager2_transformers.Pager2_VerticalFlipTransformer;
import com.codeboy.pager2_transformers.Pager2_VerticalShutTransformer;
import com.codeboy.pager2_transformers.Pager2_ZoomInTransformer;
import com.codeboy.pager2_transformers.Pager2_ZoomOutSlideTransformer;
import com.codeboy.pager2_transformers.Pager2_ZoomOutTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager2 pager2;
    RadioGroup OrientationManager;
    Spinner transformerSelector;
    ArrayList<ViewPager2.PageTransformer> Transformers;
    ArrayList<String> transformerNameList;
    List<Integer> PageImages;
    Pager2RecyclerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitViews();
    }

    private void InitViews(){
        Transformers = new ArrayList<>();
        transformerNameList = new ArrayList<>();
        PageImages = new ArrayList<>();
        pager2 = findViewById(R.id.pager2);
        pager2.setOffscreenPageLimit(7);
        OrientationManager = findViewById(R.id.orientation_group);
        transformerSelector = findViewById(R.id.transformer_selector);
        AddAllTransformers();
        setUpAdapters();
        setUpPagerOrientation();
    }

    private void setUpAdapters(){
        PageImages.add(R.drawable.moon);
        PageImages.add(R.drawable.mountains);
        PageImages.add(R.drawable.plain);
        PageImages.add(R.drawable.river);
        PageImages.add(R.drawable.setting_sun);
        PageImages.add(R.drawable.snow);
        PageImages.add(R.drawable.volcano);
        pagerAdapter = new Pager2RecyclerAdapter(PageImages,this);
        pager2.setAdapter(pagerAdapter);

        ArrayAdapter<String> selectorAdapter = new ArrayAdapter<String>(this,R.layout.layout_spinner_item, transformerNameList);
        transformerSelector.setAdapter(selectorAdapter);
        transformerSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pager2 = null;//set viewpager2 to null to invalidate previous transformer effects and set new one
                pager2 = findViewById(R.id.pager2);
                pager2.setOffscreenPageLimit(7);
                pager2.setAdapter(pagerAdapter);
                pager2.setPageTransformer(Transformers.get(position));
                OrientationManager.clearCheck();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void AddAllTransformers(){
        Transformers.add(new Pager2_AccordionTransformer()); transformerNameList.add(Pager2_AccordionTransformer.class.getSimpleName());
        Transformers.add(new Pager2_AntiClockSpinTransformer()); transformerNameList.add(Pager2_AntiClockSpinTransformer.class.getSimpleName());
        Transformers.add(new Pager2_BackDrawTransformer()); transformerNameList.add(Pager2_BackDrawTransformer.class.getSimpleName());
        Transformers.add(new Pager2_BackgroundToForegroundTransformer()); transformerNameList.add(Pager2_BackgroundToForegroundTransformer.class.getSimpleName());
        Transformers.add(new Pager2_ClockSpinTransformer()); transformerNameList.add(Pager2_ClockSpinTransformer.class.getSimpleName());
        Transformers.add(new Pager2_CubeInDepthTransformer()); transformerNameList.add(Pager2_CubeInDepthTransformer.class.getSimpleName());
        Transformers.add(new Pager2_CubeInScalingTransformer()); transformerNameList.add(Pager2_CubeInScalingTransformer.class.getSimpleName());
        Transformers.add(new Pager2_CubeInTransformer()); transformerNameList.add(Pager2_CubeInTransformer.class.getSimpleName());
        Transformers.add(new Pager2_CubeOutDepthTransformer()); transformerNameList.add(Pager2_CubeOutDepthTransformer.class.getSimpleName());
        Transformers.add(new Pager2_CubeOutScalingTransformer()); transformerNameList.add(Pager2_CubeOutScalingTransformer.class.getSimpleName());
        Transformers.add(new Pager2_CubeOutTransformer()); transformerNameList.add(Pager2_CubeOutTransformer.class.getSimpleName());
        Transformers.add(new Pager2_DefaultTransformer()); transformerNameList.add(Pager2_DefaultTransformer.class.getSimpleName());
        Transformers.add(new Pager2_DepthTransformer()); transformerNameList.add(Pager2_DepthTransformer.class.getSimpleName());
        Transformers.add(new Pager2_DepthTransformer()); transformerNameList.add(Pager2_DepthTransformer.class.getSimpleName());
        Transformers.add(new Pager2_FanTransformer()); transformerNameList.add(Pager2_FanTransformer.class.getSimpleName());
        Transformers.add(new Pager2_FidgetSpinTransformer()); transformerNameList.add(Pager2_FidgetSpinTransformer.class.getSimpleName());
        Transformers.add(new Pager2_ForegroundToBackgroundTransformer()); transformerNameList.add(Pager2_ForegroundToBackgroundTransformer.class.getSimpleName());
        Transformers.add(new Pager2_GateTransformer()); transformerNameList.add(Pager2_GateTransformer.class.getSimpleName());
        Transformers.add(new Pager2_HingeTransformer()); transformerNameList.add(Pager2_HingeTransformer.class.getSimpleName());
        Transformers.add(new Pager2_HorizontalFlipTransformer()); transformerNameList.add(Pager2_HorizontalFlipTransformer.class.getSimpleName());
        Transformers.add(new Pager2_ParallaxTransformer(R.id.page)); transformerNameList.add(Pager2_ParallaxTransformer.class.getSimpleName());
        Transformers.add(new Pager2_PopTransformer()); transformerNameList.add(Pager2_PopTransformer.class.getSimpleName());
        Transformers.add(new Pager2_RotateDownTransformer()); transformerNameList.add(Pager2_RotateDownTransformer.class.getSimpleName());
        Transformers.add(new Pager2_RotateUpTransformer()); transformerNameList.add(Pager2_RotateUpTransformer.class.getSimpleName());
        Transformers.add(new Pager2_SpinnerTransformer()); transformerNameList.add(Pager2_SpinnerTransformer.class.getSimpleName());
        Transformers.add(new Pager2_StackTransformer()); transformerNameList.add(Pager2_StackTransformer.class.getSimpleName());
        Transformers.add(new Pager2_TabletTransformer()); transformerNameList.add(Pager2_TabletTransformer.class.getSimpleName());
        Transformers.add(new Pager2_TossTransformer()); transformerNameList.add(Pager2_TossTransformer.class.getSimpleName());
        Transformers.add(new Pager2_VerticalFlipTransformer()); transformerNameList.add(Pager2_VerticalFlipTransformer.class.getSimpleName());
        Transformers.add(new Pager2_VerticalShutTransformer()); transformerNameList.add(Pager2_VerticalShutTransformer.class.getSimpleName());
        Transformers.add(new Pager2_ZoomInTransformer()); transformerNameList.add(Pager2_ZoomInTransformer.class.getSimpleName());
        Transformers.add(new Pager2_ZoomOutTransformer()); transformerNameList.add(Pager2_ZoomOutTransformer.class.getSimpleName());
        Transformers.add(new Pager2_ZoomOutSlideTransformer()); transformerNameList.add(Pager2_ZoomOutSlideTransformer.class.getSimpleName());
    }

    private void setUpPagerOrientation(){
        OrientationManager.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.hori){
                    ResetPagerWithOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
                }else if(checkedId == R.id.verti){
                    ResetPagerWithOrientation(ViewPager2.ORIENTATION_VERTICAL);
                }
            }
        });
    }

    private void ResetPagerWithOrientation(int PAGER2_ORIENTATION){
        pager2 = null;//set viewpager2 to null to invalidate previous transformer effects and set new one
        pager2 = findViewById(R.id.pager2);
        pager2.setOffscreenPageLimit(7);
        pager2.setAdapter(pagerAdapter);
        pager2.setPageTransformer(Transformers.get(transformerSelector.getSelectedItemPosition()));
        pager2.setOrientation(PAGER2_ORIENTATION);
    }

}