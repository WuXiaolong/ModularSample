package com.wuxiaolong.common.router;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by WuXiaolong on 2017/7/31.
 * 个人博客：http：//wuxiaolong.me
 */

public class RouterUtils {
    public static Object navigation(String path) {
        // 构建标准的路由请求
        return  ARouter.getInstance().build(path).navigation();
    }
    public void startActivityForResult() {
        // 构建标准的路由请求，startActivityForResult
        // navigation的第一个参数必须是Activity，第二个参数则是RequestCode
        //        ARouter.getInstance().build("/home/main").navigation(this, 5);

    }

    public void startActivityForCallback() {
    }
}
