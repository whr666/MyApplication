package com.ledou.baseframe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.style.toast.ToastUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static MainActivity mainActivity;
    TextView text1, text2, text3, text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        Intent intent = new Intent();
        intent.setClass(mainActivity, WelcomeActivity.class);
        startActivity(intent);
        finish();


        text1 = (TextView) this.findViewById(R.id.text1);
        text1.setOnClickListener(this);
        text2 = (TextView) this.findViewById(R.id.text2);
        text2.setOnClickListener(this);
        text3 = (TextView) this.findViewById(R.id.text3);
        text3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text1:
                ToastUtils.Center(mainActivity, "text1被点击了");
                break;
            case R.id.text2:
                ToastUtils.loding(mainActivity, "text2被点击了");
                break;
            case R.id.text3:
                ToastUtils.Centerrul(mainActivity, 0, "text1被点击了");
                break;

            default:

                break;
        }
    }
}
