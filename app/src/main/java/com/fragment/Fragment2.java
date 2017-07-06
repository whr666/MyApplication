package com.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ledou.baseframe.R;

/**
 * Created by WangChang on 2016/5/15.
 */
public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        Glide.with(getActivity())
                .load("http://s7.rr.itc.cn/r/wapChange/201512_11_11/a7ee9s9258135884596.gif")
                .into((ImageView) view.findViewById(R.id.imagview));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        TextView tv = (TextView) getActivity().findViewById(R.id.tv);
//        tv.setText(getArguments().getString("ARGS"));
    }

    public static Fragment2 newInstance(String content) {
        Bundle args = new Bundle();
        args.putString("ARGS", content);
        Fragment2 fragment = new Fragment2();
        fragment.setArguments(args);
        return fragment;
    }
}
