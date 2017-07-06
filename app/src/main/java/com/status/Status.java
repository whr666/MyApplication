package com.status;

import android.app.Activity;
import android.os.Build;
import android.view.WindowManager;

import com.ledou.baseframe.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by XIAOXIN on 2017/7/6.
 */

public class Status {

public static void setstatus(Activity mactivity){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        //透明状态栏
        mactivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        mactivity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        SystemBarTintManager tintManager = new SystemBarTintManager(mactivity);
        // 激活状态栏
        tintManager.setStatusBarTintEnabled(true);
        // enable navigation bar tint 激活导航栏
        tintManager.setNavigationBarTintEnabled(true);
        //设置系统栏设置颜色
        //tintManager.setTintColor(R.color.red);
        //给状态栏设置颜色
        tintManager.setStatusBarTintResource(R.color.colorAccent);
        //Apply the specified drawable or color resource to the system navigation bar.
        //给导航栏设置资源
        tintManager.setNavigationBarTintResource(R.color.colorAccent);
    }
}




}
