package com.clb.heartwishes.fragments;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017.08.09.0009.
 */
public class MeFragment extends BaseFragment {
    @Override
    protected View initView() {

        TextView textView = new TextView(mContext);
        textView.setText("我");
        textView.setTextColor(Color.BLACK);
        return textView;
    }

    @Override
    protected void initData() {

    }
}
