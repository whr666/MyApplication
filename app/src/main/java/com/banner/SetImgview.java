package com.banner;

import android.content.Context;
import android.widget.ImageView;

import com.com.model.ADInfo;
import com.httpurl.HttpUrl;

import java.util.ArrayList;


/**
 * Created by XIAOXIN on 2017/7/5.
 */

public class SetImgview {

    public static void banner(Context mactivity,
                              ArrayList<ImageView> views,
                              ArrayList<ADInfo> infos,
                              CycleViewPager.ImageCycleViewListener mAdCycleViewListener,
                              CycleViewPager cycleViewPager
                              ){
        // 将最后一个ImageView添加进来
        if(infos.get(infos.size() - 1).getImage().subSequence(0, 1).equals("h")){
            views.add(ViewFactory.getImageView(mactivity.getApplicationContext(), infos.get(infos.size() - 1).getImage()));
        }else{
            views.add(ViewFactory.getImageView(mactivity.getApplicationContext(), HttpUrl.Host+infos.get(infos.size() - 1).getImage()));
        }

        for (int i = 0; i < infos.size(); i++) {
            if(infos.get(i).getImage().subSequence(0, 1).equals("h")){
                views.add(ViewFactory.getImageView(mactivity.getApplicationContext(), infos.get(i).getImage()));
            }else{
                views.add(ViewFactory.getImageView(mactivity.getApplicationContext(), HttpUrl.Host+infos.get(i).getImage()));
            }
        }
        // 将第一个ImageView添加进来
        if(infos.get(0).getImage().subSequence(0, 1).equals("h")){
            views.add(ViewFactory.getImageView(mactivity.getApplicationContext(), infos.get(0).getImage()));
        }else{
            views.add(ViewFactory.getImageView(mactivity.getApplicationContext(), HttpUrl.Host+infos.get(0).getImage()));
        }
        // 设置循环，在调用setData方法前调用
        cycleViewPager.setCycle(true);

        // 在加载数据前设置是否循环
        cycleViewPager.setData(views, infos, mAdCycleViewListener);
        //设置轮播
        cycleViewPager.setWheel(true);

        // 设置轮播时间，默认5000ms
        cycleViewPager.setTime(3000);
        //设置圆点指示图标组居中显示，默认靠右
        cycleViewPager.setIndicatorCenter();
        cycleViewPager.refreshData();
    }









}
