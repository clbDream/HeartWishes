package com.clb.heartwishes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017.08.09.0009.
 */

public abstract class BaseFragment extends Fragment {

    protected Context mContext = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mContext = getActivity();

        return initView();
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initData();
    }
    protected abstract View initView();

    protected abstract void initData();
}
