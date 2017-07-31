package com.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.getimg.ImgUtils;
import com.ledou.baseframe.R;
import com.ledou.baseframe.TestActivity;
import com.presente.AppPermessi;
import com.view.operation.BindView;
import com.view.operation.BindOnclik;
import com.view.operation.NoteView;

import java.util.ArrayList;

/**
 *
 */
public class Fragment1 extends Fragment implements View.OnClickListener {
    @BindView(R.id.imagview)
    ImageView imageView;
    @BindView(R.id.dianhua)
    TextView dianhua;
    private ArrayList<ImageView> views = new ArrayList<ImageView>();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        NoteView.inject(this, view);
        ImgUtils.getimgutils().GetGif(getActivity(),
                "http://img5.duitang.com/uploads/item/201411/24/20141124175141_PxLFA.gif",
                imageView);
        return view;
    }
    /*绑定点击事件*/
    @BindOnclik({R.id.dianhua,R.id.imagview})


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dianhua:
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1) {//Android 6.0以上版本需要获取权限
                    requestPermissions(AppPermessi.perms,AppPermessi.PERMS_REQUEST_CODE);//请求权限
                } else {
                    //具体操作
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+"10086"));
                    startActivity(intent);
                }
                break;
            case R.id.imagview:
Intent intent = new Intent(getActivity(), TestActivity.class);
startActivity(intent);
                break;

            default:

                break;
        }
    }
}
