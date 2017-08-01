package com.wuxiaolong.module1;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wuxiaolong.common.router.Module1Service;
import com.wuxiaolong.common.router.RouterConstants;

/**
 * Created by WuXiaolong on 2017/7/24.
 * 个人博客：http：//wuxiaolong.me
 */
@Route(path = RouterConstants.MODULE1_SERVICE_IMPL)
public class Module1ServiceImpl implements Module1Service {
    @Override
    public boolean share() {
        Log.d("wxl","share");
        return true;
    }

    @Override
    public void init(Context context) {
        Log.d("wxl","init="+context);
    }
}
