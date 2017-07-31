package com.style.toast;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ledou.baseframe.R;

/**
 * Created by whr on 2017/7/3.
 */

public class ToastUtils {
    public volatile static ToastUtils toasturils;
    public volatile static Toast toast;
    public volatile static Context context;
    /**
     * 公开的
     */
    private ToastUtils(Context context){
         this.context = context;
    }
    public static ToastUtils getToasturils(){
        if(toasturils==null){
    synchronized (ToastUtils.class){
        if (toasturils == null) {
            toasturils = new ToastUtils(context);
        }

    }


}


return toasturils;

    }


    /**
     *
     * Center
     * @param msg msg
     */
    public static void Center(Context context,String msg){
        Toast toast = Toast.makeText(context.getApplicationContext(),msg,Toast.LENGTH_LONG);
//        toast.setText(msg);
        toast.setGravity(Gravity.CENTER | 0, 0, 0);
//        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

    /**
     *Centerrul
     * @param img 图片
     * @param msg msg
     */
    public static void Centerrul(Context context,int img,String msg){
        Toast toast = new Toast(context.getApplicationContext());
        View layout = LayoutInflater.from(context).inflate(R.layout.toast,null);
        ImageView image = (ImageView) layout.findViewById(R.id.img);
        image.setImageResource(img);
        TextView title = (TextView) layout.findViewById(R.id.text);
        title.setText(msg);
//        toast = new Toast(context.getApplicationContext());
//        toast.setGravity(Gravity.CENTER | Gravity.TOP, 12, 40);
        toast.setGravity(Gravity.CENTER | 0, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    /**
     * showloding
     * @param context
     * @param msg
     * @return
     */
    public static Dialog loding(Context context,String msg){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
        ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
        TextView tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
        // 加载动画
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
                context, R.anim.loading_animation);
        // 使用ImageView显示动画
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
        tipTextView.setText(msg);// 设置加载信息
        final Dialog mProgressDialog = new Dialog(context,R.style.theme_dialog);
        final int MSG_DISMISS_DIALOG = 0;
        Handler mHandler = new Handler(){
            @SuppressWarnings("unused")
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                super.handleMessage(msg);
                if(MSG_DISMISS_DIALOG == msg.what){
                    if(null != mProgressDialog){
                        if(mProgressDialog.isShowing()){
                            mProgressDialog.dismiss();
                        }
                    }
                }
            }
        };
        mProgressDialog.setCancelable(false);// 不可以用“返回键”取消
        mProgressDialog.setContentView(v, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
        mProgressDialog.show();
        mHandler.sendEmptyMessageDelayed(MSG_DISMISS_DIALOG, 3000);

        return mProgressDialog;
    }









}
