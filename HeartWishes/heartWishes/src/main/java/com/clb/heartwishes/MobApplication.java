package com.clb.heartwishes;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.mob.MobSDK;

/**
 * Created by Administrator on 2017.08.10.0010.
 */

public class MobApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"GfYEVK06jCqEn8fgVkV9w1jg-gzGzoHsz","tr0ID6q1IPCnryWQrpcuDFc6");
        // 放在 SDK 初始化语句 AVOSCloud.initialize() 后面，只需要调用一次即可
        AVOSCloud.setDebugLogEnabled(true);

        //初始化Mob
        MobSDK.init(this);
    }
}
