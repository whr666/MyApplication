package com.ledou.baseframe;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.fragment.Fragment2;
import com.fragment.Fragment1;
import com.fragment.Fragment3;
import com.fragment.Fragment4;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.status.Status;
import com.style.toast.ToastUtils;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    public FragmentManager fragmentManager;
    private static final String CURRENT_FRAGMENT = "STATE_FRAGMENT_SHOW";
    private Fragment currentFragment = new Fragment();
    private ArrayList<Fragment> fragments = new ArrayList<Fragment>();
    public int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Status.setstatus(this);//沉侵状态栏
        setinitview();
        fragmentManager = getSupportFragmentManager(); //兼容3.0以下
//        fragmentManager = getFragmentManager(); //3.0以上可以这么写
        if (savedInstanceState != null) { // “内存重启”时调用
            //获取“内存重启”时保存的索引下标
            currentIndex = savedInstanceState.getInt(CURRENT_FRAGMENT, 0);
            fragments.removeAll(fragments);
            fragments.add(fragmentManager.findFragmentByTag(0 + ""));
            fragments.add(fragmentManager.findFragmentByTag(1 + ""));
            fragments.add(fragmentManager.findFragmentByTag(2 + ""));
            fragments.add(fragmentManager.findFragmentByTag(3 + ""));
            //恢复fragment页面
            restoreFragment();
        } else {//正常启动时调用
            fragments.add(new Fragment1());
            fragments.add(new Fragment2());
            fragments.add(new Fragment3());
            fragments.add(new Fragment4());
            showFragment();
        }

        if(currentIndex==0){
            title.setText("首页");
        }else if (currentIndex==1){
            title.setText("消息");
        }else if (currentIndex==2){
            title.setText("时间");
        }else if (currentIndex==3){
            title.setText("答案");
        }


    }

    /**
     * 初始化
     */
    TextView title;
    private void setinitview() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        title = (TextView) findViewById(R.id.title);
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        TextBadgeItem numberBadgeItem = new TextBadgeItem()
                .setBorderWidth(1)
                .setBackgroundColor(Color.RED)
                .setText("5")
                .setHideOnSelect(true);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "首页")
                .setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "消息")
                        .setActiveColorResource(R.color.colorAccent)
                        .setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "事件")
                        .setActiveColorResource(R.color.colorPrimary)
                        .setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "答案")
                        .setActiveColorResource(R.color.colorPrimaryDark)
                        .setBadgeItem(numberBadgeItem))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);

    }

    /**
     * 点击tab具体操作
     * @param position
     */
    @Override
    public void onTabSelected(int position) {//选中
        if (fragments != null) {
            switch (position) {
                case 0:
                   currentIndex = 0;
                    title.setText("首页");
                    break;
                case 1:
                    currentIndex = 1;
                    title.setText("消息");
                    break;
                case 2:
                    currentIndex = 2;
                    title.setText("时间");
                    break;
                case 3:
                    currentIndex = 3;
                    title.setText("答案");
                    break;
            }
            showFragment();
        }

    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {

        }
    }

    @Override
    public void onTabReselected(int position) {

    }
    /**
     * 使用show() hide()切换页面
     * 显示fragment
     */
    private void showFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //如果之前没有添加过
        if (!fragments.get(currentIndex).isAdded()) {
            transaction
                    .hide(currentFragment)
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .add(R.id.layFrame, fragments.get(currentIndex), "" + currentIndex);  //第三个参数为添加当前的fragment时绑定一个tag

        } else {
            transaction
                    .hide(currentFragment)
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .show(fragments.get(currentIndex));
        }

        currentFragment = fragments.get(currentIndex);

        transaction.commit();

    }

    /**
     * 恢复fragment
     */
    private void restoreFragment() {
        FragmentTransaction mBeginTreansaction = fragmentManager.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            if (i == currentIndex) {
                mBeginTreansaction.show(fragments.get(i));
            } else {
                mBeginTreansaction.hide(fragments.get(i));
            }

        }
        mBeginTreansaction.commit();
        //把当前显示的fragment记录下来
        currentFragment = fragments.get(currentIndex);
    }












}
