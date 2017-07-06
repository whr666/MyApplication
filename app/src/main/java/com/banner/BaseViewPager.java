package com.banner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 自定义高度的viewpapger
 */
public class BaseViewPager extends ViewPager {
	private boolean scrollable = true;

	public BaseViewPager(Context context) {
		super(context);
	}

	public BaseViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
//		DisplayMetrics dm = getResources().getDisplayMetrics();
////		int width = dm.widthPixels;
////		int height = dm.heightPixels;
//		LayoutParams params= (LayoutParams) this.getLayoutParams();
////		获取当前控件的布局对象
//		params.width = LayoutParams.MATCH_PARENT;
//		params.height = 75/42;//设置当前控件布局的高度
//		imageView.setLayoutParams(params);//将设置好的布局参数应用到控件中
//       this.setLayoutParams(params);
	}

	/**
	 * 设置viewpager是否可以滚动
	 * 
	 * @param enable
	 */
	public void setScrollable(boolean enable) {
		scrollable = enable;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		if (scrollable) {
			return super.onInterceptTouchEvent(event);
		} else {
			return false;
		}
	}
}