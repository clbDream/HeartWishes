package com.clb.heartwishes.activitys;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.clb.heartwishes.R;
import com.clb.heartwishes.fragments.BaseFragment;
import com.clb.heartwishes.fragments.HomeFragment;
import com.clb.heartwishes.fragments.MeFragment;
import com.clb.heartwishes.fragments.moreFragment;
import com.clb.heartwishes.utils.ToastUtils;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.fl_main)
    FrameLayout flMain;
    @InjectView(R.id.bottomBar)
    BottomBar bottomBar;
    @InjectView(R.id.activity_main)
    RelativeLayout activityMain;
    @InjectView(R.id.title)
    TextView title;

    private FragmentTransaction transaction;
    private List<BaseFragment> fragmentList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        /*// 测试 SDK 是否正常工作的代码
        AVObject testObject = new AVObject("TestObject");
        testObject.put("words","Hello World!");
        testObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                if(e == null){
                    Log.d("saved","success!");
                }
            }
        });*/


        initFragment();
        initClickListener();
    }


    /**
     * 初始化Fragment
     */
    private void initFragment() {

        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new moreFragment());
        fragmentList.add(new MeFragment());

    }

    /**
     * 初始化点击事件
     */
    private void initClickListener() {


        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                //获取Fragment管理器
                FragmentManager manager = getSupportFragmentManager();
                //开启事务
                transaction = manager.beginTransaction();

                switch (tabId) {
                    case R.id.home:
                        ToastUtils.showToast(getApplicationContext(), "首页");
                        title.setText("首页");

                        //动态替换Fragment
                        transaction.replace(R.id.fl_main, fragmentList.get(0)).commit();
                        break;
                    case R.id.more:
                        ToastUtils.showToast(getApplicationContext(), "心声");
                        title.setText("心声");

                        transaction.replace(R.id.fl_main, fragmentList.get(1)).commit();
                        break;
                    case R.id.me:
                        ToastUtils.showToast(getApplicationContext(), "我");
                        title.setText("我");

                        transaction.replace(R.id.fl_main, fragmentList.get(2)).commit();
                        break;
                }

            }
        });
    }


}
