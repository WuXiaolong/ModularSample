package com.wuxiaolong.modularsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.wuxiaolong.common.activity.BaseActivity;
import com.wuxiaolong.common.model.UserModel;
import com.wuxiaolong.common.router.Module1Service;
import com.wuxiaolong.common.router.RouterConstants;
import com.wuxiaolong.common.router.RouterUtils;

import butterknife.OnClick;

/**
 * Created by WuXiaolong on 2017/7/24.
 * 个人博客：http：//wuxiaolong.me
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_activity_main);
        initToolBarAsHome(getString(R.string.app));
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                RouterUtils.navigation(RouterConstants.MODULE1_MAIN_ACTIVITY);
                break;
            case R.id.button2:
                UserModel userModel = new UserModel();
                userModel.setName("WuXiaolong");
                userModel.setMessage("个人博客：http：//wuxiaolong.me");
                Bundle bundle = new Bundle();
                bundle.putSerializable("obj", userModel);
                ARouter.getInstance()
                        .build(RouterConstants.MODULE1_MAIN_ACTIVITY)
                        .with(bundle)
                        .navigation();
                break;
            case R.id.button3:
                showFragment();
                break;
            case R.id.button4:
                Module1Service module1Service = (Module1Service) RouterUtils.navigation(RouterConstants.MODULE1_SERVICE_IMPL);
                if (module1Service != null)
                    toastShow("结果：" + module1Service.share());
                break;
        }
    }

    private void showFragment() {
        // 获取Fragment
        Fragment fragment = (Fragment) RouterUtils.navigation(RouterConstants.MODULE1_MODULE1_FRAGMENT);
        if (fragment != null)
            getSupportFragmentManager().beginTransaction().add(R.id.contentLayout, fragment).commit();
    }
}
