package com.wuxiaolong.modularsample;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wuxiaolong.common.BaseActivity;
import com.wuxiaolong.common.model.UserInfo;
import com.wuxiaolong.router.Module1Service;
import com.wuxiaolong.router.RouterConstants;

/**
 * Created by WuXiaolong on 2017/7/24.
 * 个人博客：http：//wuxiaolong.me
 */
@Route(path = RouterConstants.MODULE1_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(RouterConstants.MODULE1_MAIN_ACTIVITY).navigation();
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfo userInfo=new UserInfo();
                userInfo.setName("WuXiaolong");
                userInfo.setMessage("个人博客：http：//wuxiaolong.me");
                ARouter.getInstance().build("/module1/MainActivity")
                        .withLong("key1", 666L)
                        .withObject("key2", userInfo)
                        .navigation();
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Module1Service module1Service = ARouter.getInstance().navigation(Module1Service.class);
                toastShow("结果：" + module1Service.share());
            }
        });
    }
}
