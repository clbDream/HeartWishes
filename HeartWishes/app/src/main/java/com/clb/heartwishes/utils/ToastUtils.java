package com.clb.heartwishes.utils;

/**
 * Created by Administrator on 2017.08.09.0009.
 */

import android.content.Context;
import android.widget.Toast;

/**
 * 用于显示Toast的工具类，避免用户疯狂点击后吐司会一直显示
 */
public class ToastUtils {

    private static Toast toast;

    public static void showToast(Context context,String text){

        if (toast==null){
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }else {
            toast.setText(text);
        }
        toast.show();
    }
}
