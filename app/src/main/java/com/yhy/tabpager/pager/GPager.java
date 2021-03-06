package com.yhy.tabpager.pager;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yhy.tabnav.pager.TpgFragment;
import com.yhy.tabpager.utils.ToastUtils;

import java.util.Random;

public class GPager extends TpgFragment {

    @Override
    public View getSuccessView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView tv = new TextView(getContext());
        tv.setText("G页面加载成功");
        tv.setTextColor(Color.RED);
        tv.setTextSize(32);
        tv.setGravity(Gravity.CENTER);
        return tv;
    }


    @Override
    public void initData() {
        getDataFromServer();
    }

    @Override
    public void reloadData(Bundle args) {
        String temp = args.getString("args");
        ToastUtils.shortToast(temp + "页面重新加载数据");

        getDataFromServer();
    }

    private void getDataFromServer() {
        final Random random = new Random();
        new Thread() {
            @Override
            public void run() {
                //模拟网络加载延迟
                SystemClock.sleep(2000);

                //数据加载结束后，需要手动刷新页面状态
                int temp = random.nextInt(3);
                switch (temp) {
                    case 0:
//                        mRltHandler.onSuccess();
                        onSuccess();
                        break;
                    case 1:
//                        mRltHandler.onError();
                        onError();
                        break;
                    case 2:
//                        mRltHandler.onEmpty();
                        onEmpty();
                        break;
                    default:
                        break;
                }
            }
        }.start();
    }
}