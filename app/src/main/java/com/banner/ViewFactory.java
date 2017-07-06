package com.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.ledou.baseframe.R;

/**
 * ImageView创建工厂
 */
public class ViewFactory {
	/**
	 * 获取ImageView视图的同时加载显示url
	 * 
	 * @return
	 */
	public static ImageView getImageView(Context context, String url) {
		ImageView imageView = (ImageView)LayoutInflater.from(context).inflate(R.layout.view_banner, null);
//		ImageLoader.getInstance().displayImage(url, imageView);
//		Getimg.getimgurl(context, url, imageView);

		Glide.with(context)

				.load(url).into(imageView);

		return imageView;
	}
}
