package com.yifeng.pagingdemo;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class ScreenUtils {

    /**
     * dp转px
     *
     * @return px
     */
    public static int dip2px(float dipValue) {
        float m = Application.getContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * m + 0.5f);
    }

    /**
     * @param context 上下文
     * @return DisplayMetrics对象
     */
    private static DisplayMetrics getDisplayMetrics(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param pxValue 值
     * @return 转换结果
     */
    public static int px2dip(float pxValue) {
        final float scale = Application.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转px
     *
     * @param spValue 值
     * @return 转换结果
     */
    public static int sp2px(float spValue) {
        final float fontScale = Application.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px转sp
     *
     * @param pxValue 值
     * @return 转换结果
     */
    public static int px2sp(float pxValue) {
        final float fontScale = Application.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }


    /**
     * 判断横竖屏
     */
    public static int ScreenOrientation() {
        Configuration configuration = Application.getContext().getResources().getConfiguration();
        return configuration.orientation;
    }


}