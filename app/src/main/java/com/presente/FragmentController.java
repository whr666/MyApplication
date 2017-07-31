package com.presente;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ledou.baseframe.R;
import com.model.TypeFragment;

import java.util.ArrayList;

/**
 * Created by XIAOXIN on 2017/7/7.
 */

public class FragmentController{
    String CURRENT_FRAGMENT = "STATE_FRAGMENT_SHOW";
    Fragment currentFragment = new Fragment();
    ArrayList<Fragment> fragments = new ArrayList<Fragment>();
    FragmentManager fragmentManager;
    public  void fragmentFC(Activity activity,
                            Bundle savedInstanceState,
                            FragmentManager fragmentManager,
                            int currentIndex,
                            ArrayList<Fragment> fragments
                          ){
        if (savedInstanceState != null) { // “内存重启”时调用
            //获取“内存重启”时保存的索引下标
            TypeFragment.currentIndex =
                    savedInstanceState.getInt(CURRENT_FRAGMENT, 0);
            this.fragmentManager = fragmentManager;
            this.fragments = fragments;
            fragments.removeAll(fragments);
            for (int i = 0; i <fragments.size() ; i++) {
                fragments.add(fragmentManager.findFragmentByTag(i + ""));
            }
//            fragments.add(fragmentManager.findFragmentByTag(1 + ""));
//            fragments.add(fragmentManager.findFragmentByTag(2 + ""));
//            fragments.add(fragmentManager.findFragmentByTag(3 + ""));
            //恢复fragment页面
            restoreFragment();
        } else {//正常启动时调用
            TypeFragment.currentIndex = currentIndex;
            this.fragmentManager = fragmentManager;
            this.fragments=fragments;
//            this.fragments.addAll(fragments);
            showFragment();
        }


    }




    /**
     * 使用show() hide()切换页面
     * 显示fragment
     */
    public void showFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //如果之前没有添加过
        if (!fragments.get(TypeFragment.currentIndex).isAdded()) {
            transaction
                    .hide(currentFragment)
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .add(R.id.layFrame, fragments.get(TypeFragment.currentIndex), "" + TypeFragment.currentIndex);  //第三个参数为添加当前的fragment时绑定一个tag

        } else {
            transaction
                    .hide(currentFragment)
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .show(fragments.get(TypeFragment.currentIndex));
        }

        currentFragment = fragments.get(TypeFragment.currentIndex);

        transaction.commit();

    }

    /**
     * 恢复fragment
     */
    public void restoreFragment() {
        FragmentTransaction mBeginTreansaction = fragmentManager.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            if (i == TypeFragment.currentIndex) {
                mBeginTreansaction.show(fragments.get(i));
            } else {
                mBeginTreansaction.hide(fragments.get(i));
            }

        }
        mBeginTreansaction.commit();
        //把当前显示的fragment记录下来
        currentFragment = fragments.get(TypeFragment.currentIndex);
    }









}
