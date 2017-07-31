package com.wuxiaolong.modularsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wuxiaolong.common.activity.BaseActivity;
import com.wuxiaolong.common.model.UserModel;
import com.wuxiaolong.router.Module1Service;
import com.wuxiaolong.router.RouterConstants;

import butterknife.OnClick;

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
        initToolBar(getString(R.string.app));
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                ARouter.getInstance().build(RouterConstants.MODULE1_MAIN_ACTIVITY).navigation();
                break;
            case R.id.button2:
                UserModel userInfo = new UserModel();
                userInfo.setName("WuXiaolong");
                userInfo.setMessage("个人博客：http：//wuxiaolong.me");
                ARouter.getInstance().build("/module1/MainActivity")
                        .withLong("key1", 666L)
                        .withObject("key2", userInfo)
                        .navigation();
                break;
            case R.id.button3:
                showFragment();
                break;
            case R.id.button4:
                Module1Service module1Service = ARouter.getInstance().navigation(Module1Service.class);
                toastShow("结果：" + module1Service.share());
                break;
        }
    }
    private void showFragment(){
        // 获取Fragment
        Fragment fragment = (Fragment) ARouter.getInstance().build(RouterConstants.MODULE1_MODULE1_FRAGMENT).navigation();
        getSupportFragmentManager().beginTransaction().add(R.id.contentLayout,fragment).commit();
    }
}
