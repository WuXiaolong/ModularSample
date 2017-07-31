package com.wuxiaolong.module1;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wuxiaolong.common.activity.ButterKnifeActivity;
import com.wuxiaolong.router.RouterConstants;

import butterknife.OnClick;

@Route(path = RouterConstants.MODULE1_MAIN_ACTIVITY)
public class MainActivity extends ButterKnifeActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module1_activity_main);
        initToolBar(getString(R.string.module1));
    }

    /**
     * click方法中同样使用R2，但是找id的时候使用R，
     * ibrary中是不能使用 switch- case 找id的，原因：http://www.jianshu.com/p/89687f618837
     */
    @OnClick({R2.id.module1_button})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.module1_button) {
            ARouter.getInstance().build(RouterConstants.MODULE2_MAIN_ACTIVITY).navigation();
        }
    }
}