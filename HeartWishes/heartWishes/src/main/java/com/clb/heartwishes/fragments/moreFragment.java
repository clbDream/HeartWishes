package com.clb.heartwishes.fragments;

import android.content.Intent;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.clb.heartwishes.R;
import com.clb.heartwishes.activitys.HomeActivity;
import com.clb.heartwishes.activitys.MyHeartWishesActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017.08.10.0010.
 */
public class moreFragment extends BaseFragment {

    @InjectView(R.id.lbs_btn)
    LinearLayout lbsBtn;
    @InjectView(R.id.review_btn)
    LinearLayout reviewBtn;
    @InjectView(R.id.more_btn)
    LinearLayout moreBtn;
    @InjectView(R.id.idea_btn)
    LinearLayout ideaBtn;
    @InjectView(R.id.photo_btn)
    LinearLayout photoBtn;
    @InjectView(R.id.weibo_btn)
    LinearLayout weiboBtn;
    @InjectView(R.id.panel)
    LinearLayout panel;

    private Animation mButtonInAnimation;
    private Animation mButtonOutAnimation;
    private Animation mButtonScaleLargeAnimation;
    private Animation mButtonScaleSmallAnimation;
    private Animation mCloseRotateAnimation;

    @Override
    protected View initView() {

        View view = LayoutInflater.from(mContext).inflate(R.layout.view_add, null);
        ButterKnife.inject(this, view);
        initAnimation();
        return view;
    }

    @Override
    protected void initData() {
        //开启面板的内容
        openPanelView();
    }

    /**
     * 初始化动画
     */
    private void initAnimation() {
        mButtonInAnimation = AnimationUtils.loadAnimation(mContext, R.anim.button_scale_to_large);
        mButtonOutAnimation = AnimationUtils.loadAnimation(mContext, R.anim.button_out);
        mButtonScaleLargeAnimation = AnimationUtils.loadAnimation(mContext, R.anim.button_scale_to_large);
        mButtonScaleSmallAnimation = AnimationUtils.loadAnimation(mContext, R.anim.button_scale_to_small);
        mCloseRotateAnimation = AnimationUtils.loadAnimation(mContext, R.anim.close_rotate);
    }

    // 打开面板视图
    private void openPanelView() {
        panel.setVisibility(View.VISIBLE);

        ideaBtn.startAnimation(mButtonInAnimation);
        photoBtn.startAnimation(mButtonInAnimation);
        weiboBtn.startAnimation(mButtonInAnimation);
        lbsBtn.startAnimation(mButtonInAnimation);
        reviewBtn.startAnimation(mButtonInAnimation);
        moreBtn.startAnimation(mButtonInAnimation);


    }

    // 关闭面板视图
    private void closePanelView() {
        // 给6个按钮添加退出动画
        ideaBtn.startAnimation(mButtonOutAnimation);
        photoBtn.startAnimation(mButtonOutAnimation);
        weiboBtn.startAnimation(mButtonOutAnimation);
        lbsBtn.startAnimation(mButtonOutAnimation);
        reviewBtn.startAnimation(mButtonOutAnimation);
        moreBtn.startAnimation(mButtonOutAnimation);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.lbs_btn, R.id.review_btn, R.id.more_btn, R.id.idea_btn, R.id.photo_btn, R.id.weibo_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lbs_btn:
                break;
            case R.id.review_btn:
                break;
            case R.id.more_btn:
                break;
            case R.id.idea_btn:

                //当点击后，跳转到写我的心声的界面
                startActivity(new Intent(mContext,MyHeartWishesActivity.class));
                break;
            case R.id.photo_btn:
                break;
            case R.id.weibo_btn:
                break;
        }
    }

}
