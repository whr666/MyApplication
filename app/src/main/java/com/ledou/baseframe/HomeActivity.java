package com.ledou.baseframe;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.style.toast.ToastUtils;
import com.view.operation.AddFragment;
import com.presente.FragmentController;
import com.model.TypeFragment;
import com.view.operation.BindView;
import com.view.operation.NoteView;
import com.view.widget.Titlebar;

public class HomeActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    public static HomeActivity activity;
    public FragmentManager fragmentManager;
    private static final String CURRENT_FRAGMENT = "STATE_FRAGMENT_SHOW";
    private Fragment currentFragment = new Fragment();
    FragmentController fc = new FragmentController();
    int index  = 0;
    SlidingMenu menu;
    View drawerview;
    @BindView(R.id.title)
    Titlebar hometitle;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    TextView drtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        activity = this;
        NoteView.inject(this);//绑定注解
//        NoteView.inject(drawerview);//绑定注解
        setmenu();//初始化侧滑栏
        settabbar();//tabbar初始化
        fragmentManager = getSupportFragmentManager(); //兼容3.0以下
//      fragmentManager = getFragmentManager(); //3.0以上可以这么写
        fc.fragmentFC(//fragment添加
                this,
                savedInstanceState,
                fragmentManager,0,
                AddFragment.HomeFragment()
                );
        if(TypeFragment.currentIndex==0){
            hometitle.setText("首页");
        }else if (TypeFragment.currentIndex==1){
            hometitle.setText("消息");
        }else if (TypeFragment.currentIndex==2){
            hometitle.setText("时间");
        }else if (TypeFragment.currentIndex==3){
            hometitle.setText("答案");
        }

        hometitle.showBack();
        hometitle.showright1();
        hometitle.setHeight(45);//标题高度
        hometitle.setRightText("去吧");//右侧字体
        hometitle.setRightTextColor(R.color.tabbarbg5);//右侧字体颜色
        hometitle.setBack(R.mipmap.loading);//返回键图
        hometitle.setRight1(R.mipmap.loading);//右键图
        hometitle.setRight2(R.mipmap.loading);//右键图
        hometitle.setRight3(R.mipmap.loading);//右键图
        hometitle.setBackMarginLeft(5);//返回键图左边距
        hometitle.setTextColor(R.color.tabbarbg1);//标题字体颜色
        hometitle.setTextGravity(Gravity.CENTER);//标题位置
        hometitle.setBackColor(R.color.colorPrimary);//返回键色
        hometitle.setRight1Color(R.color.colorPrimary);//右键颜色
        hometitle.setBackground(R.color.colorAccent);//标题背景色
        hometitle.setOnBackClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index==0){
                    menu.showMenu();
                    index=1;
                }else{
                    menu.showContent();
                    index=0;
                }

            }
        });



    }


    /**
     * 初始化侧滑栏
     */
    public void setmenu(){


        // configure the SlidingMenu
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.color.colorAccent);
        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);

        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局
        menu.setMenu(R.layout.drawerview);


        /**
         * 代码有问题
         */
        drawerview = getLayoutInflater().inflate(R.layout.drawerview,null);
        drtext = (TextView) drawerview.findViewById(R.id.drtext);
        drtext.setText("Holle world");
        drtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.Center(activity,drtext.getText().toString());
            }
        });




    }


    /**
     * 初始化
     */

    /**
     * 点击tab具体操作
     * @param position
     */
    @Override
    public void onTabSelected(int position) {//选中
        if (AddFragment.HomeFragment() != null) {
            switch (position) {
                case 0:
                    TypeFragment.currentIndex = 0;
                    hometitle.setText("首页");
                    break;
                case 1:
                    TypeFragment.currentIndex = 1;
                    hometitle.setText("消息");
                    break;
                case 2:
                    TypeFragment.currentIndex = 2;
                    hometitle.setText("时间");
                    break;
                case 3:
                    TypeFragment.currentIndex = 3;
                    hometitle.setText("答案");
                    break;
            }
            fc.showFragment();
        }

    }

    @Override
    public void onTabUnselected(int position) {
        if (AddFragment.HomeFragment() != null) {

        }
    }

    @Override
    public void onTabReselected(int position) {

    }
    /**
    tabbar初始化
    */
    public  void  settabbar(){
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        TextBadgeItem numberBadgeItem = new TextBadgeItem()
                .setBorderWidth(1)//消息圆圈边框
                .setBackgroundColor(Color.RED)
                .setText("5")//消息数量
                .setHideOnSelect(true);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "首页")
                .setActiveColorResource(R.color.tabbarbg1))//背景色

                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "消息几条")
                        .setActiveColorResource(R.color.tabbarbg2)
                        .setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "山庄事件")
                        .setActiveColorResource(R.color.tabbarbg3)
                        .setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "没答案")
                        .setActiveColorResource(R.color.tabbarbg4)
                        .setBadgeItem(numberBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "首页")
                        .setActiveColorResource(R.color.tabbarbg5))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "首页")
                        .setActiveColorResource(R.color.tabbarbg6))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher, "首页")
                        .setActiveColorResource(R.color.tabbarbg7))


                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);




    }









}
