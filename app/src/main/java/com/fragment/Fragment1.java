package com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.banner.CycleViewPager;
import com.banner.ViewFactory;
import com.bumptech.glide.Glide;
import com.com.model.ADInfo;
import com.ledou.baseframe.R;
import com.style.toast.ToastUtils;

import java.util.ArrayList;

/**
 * Created by WangChang on 2016/5/15.
 */
public class Fragment1 extends Fragment {

    private ArrayList<ImageView> views = new ArrayList<ImageView>();
    private ArrayList<ADInfo> infos = new ArrayList<ADInfo>();
    CycleViewPager cycleViewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
;

        Glide.with(getActivity())
                .load("http://img5.duitang.com/uploads/item/201411/24/20141124175141_PxLFA.gif")
                .into((ImageView) view.findViewById(R.id.imagview));


//        cycleViewPager =	 (CycleViewPager) getFragmentManager().findFragmentById(R.id.banner);
//        cycleViewPager =	 (CycleViewPager) getChildFragmentManager().findFragmentById(R.id.banner);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ADInfo info = new ADInfo();
        info.setImage("http://img5q.duitang.com/uploads/item/201411/22/20141122124903_tYYds.gif");
        info.setImage("http://img5.duitang.com/uploads/item/201411/24/20141124175141_PxLFA.gif");
        infos.add(info);
//        TextView tv = (TextView) getActivity().findViewById(R.id.tv);
//        tv.setText(getArguments().getString("ARGS"));
//        SetImgview.banner(getActivity(),views,infos,mAdCycleViewListener,cycleViewPager);

    }

    public static Fragment1 newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }

    //banner图点击
    private CycleViewPager.ImageCycleViewListener mAdCycleViewListener = new CycleViewPager.ImageCycleViewListener() {
        @Override
        public void onImageClick(ADInfo info, int position, View imageView) {
            // TODO Auto-generated method stub
            if (cycleViewPager.isCycle()) {
                ToastUtils.Center(getActivity(), position + "");
            }
        }

    };








}
