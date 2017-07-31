package com.view.operation;

import android.support.v4.app.Fragment;

import com.fragment.Fragment1;
import com.fragment.Fragment2;
import com.fragment.Fragment3;
import com.fragment.Fragment4;

import java.util.ArrayList;

/**
 * Created by XIAOXIN on 2017/7/7.
 */

public class AddFragment {


    public static  ArrayList<Fragment> HomeFragment(){
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        return fragments;
    }


}
