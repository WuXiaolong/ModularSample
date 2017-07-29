package com.wuxiaolong.module2;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wuxiaolong.common.ButterKnifeActivity;
import com.wuxiaolong.router.RouterConstants;

import butterknife.ButterKnife;

@Route(path = RouterConstants.MODULE2_MAIN_ACTIVITY)
public class MainActivity extends ButterKnifeActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module2_activity_main);
        ButterKnife.bind(this);
        findViewById(R.id.module2_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastShow("ddd");
                ARouter.getInstance().build(RouterConstants.MODULE1_MAIN_ACTIVITY).navigation();
            }
        });
    }

//    @OnClick({R2.id.module2_button2, R2.id.module2_button1})
//    public void onViewClicked(View view) {
//        int i = view.getId();
//        if (i == R.id.module2_button1) {
//            ARouter.getInstance().build(RouterConstants.MODULE1_MAIN_ACTIVITY).navigation();
//        } else if (i == R.id.module2_button2) {
//        }
//    }
}
