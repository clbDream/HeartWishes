package com.clb.heartwishes.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.clb.heartwishes.R;
import com.clb.heartwishes.utils.ToastUtils;
import com.mob.jimu.biz.ReadWriteProperty;
import com.mob.ums.OperationCallback;
import com.mob.ums.User;
import com.mob.ums.gui.UMSGUI;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017.08.09.0009.
 */
public class MeFragment extends BaseFragment {
    @InjectView(R.id.sign_in)
    Button signIn;
    @InjectView(R.id.my_info)
    Button myInfo;
    @InjectView(R.id.head)
    ImageView head;
    @InjectView(R.id.name)
    TextView name;
    @InjectView(R.id.fans)
    TextView fans;
    @InjectView(R.id.name_fans)
    LinearLayout nameFans;
    @InjectView(R.id.collection)
    LinearLayout collection;
    @InjectView(R.id.history)
    LinearLayout history;
    @InjectView(R.id.night)
    LinearLayout night;

    @Override
    protected View initView() {

        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_me, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.sign_in, R.id.my_info, R.id.collection, R.id.history, R.id.night})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sign_in:

                //当点击登录按钮时，会跳转到登录界面
                UMSGUI.showLogin(new MyCallBack());
                break;
            case R.id.my_info:

                //打开个人资料
                UMSGUI.showProfilePage();
                break;

            case R.id.collection:
                break;
            case R.id.history:
                break;
            case R.id.night:
                break;
        }
    }

    class MyCallBack extends OperationCallback<User> {

        public MyCallBack() {
            super();
        }

        @Override
        public void onSuccess(User user) {

            ToastUtils.showToast(mContext, "登陆成功");
            //获取用户的信息
            upDataUserInfo(user);
            //获取成功的话，那就让界面更新
            signIn.setVisibility(View.GONE);
            nameFans.setVisibility(View.VISIBLE);

        }

        @Override
        public void onFailed(Throwable throwable) {
            ToastUtils.showToast(mContext, "登录失败，请重新登录");
        }

        @Override
        public void onCancel() {
            super.onCancel();
        }
    }

    /**
     * 获取用户的信息
     * @param user
     */
    private void upDataUserInfo(User user) {

        //获取用户的头像，并转化为Bitmap
        ReadWriteProperty<String[]> avatar = user.avatar;
        ReadWriteProperty<String> nickname = user.nickname;

    }

}
