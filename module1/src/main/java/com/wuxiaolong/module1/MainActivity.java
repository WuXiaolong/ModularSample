package com.wuxiaolong.module1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wuxiaolong.common.ButterKnifeActivity;
import com.wuxiaolong.router.RouterConstants;

import butterknife.BindView;

@Route(path = RouterConstants.MODULE1_MAIN_ACTIVITY)
public class MainActivity extends ButterKnifeActivity {


    @BindView(R2.id.module1_button)
    Button module1Button;
    @BindView(R2.id.module1_textview)
    TextView module1Textview;
    @BindView(R2.id.module1_button2)
    Button module1Button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module1_activity_main);
        findViewById(R.id.module1_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                toastShow("module1_button1");
                ARouter.getInstance().build(RouterConstants.MODULE2_MAIN_ACTIVITY).navigation();
            }
        });
    }

    /**
     * click方法中同样使用R2，但是找id的时候使用R，
     * ibrary中是不能使用 switch- case 找id的，原因：http://www.jianshu.com/p/89687f618837
     */
//    @OnClick({R2.id.module1_button, R2.id.module1_button2})
//    public void onViewClicked(View view) {
//        int id = view.getId();
//        Log.d("wxl", "id=" + id);
//        if (id == R.id.module1_button) {
//            toastShow("module1_button1");
//            ARouter.getInstance().build(IModule2Provider.MODULE2_MAIN_ACTIVITY).navigation();
//        } else if (id == R.id.module1_button2) {
//            toastShow("module1_button2");
//        }
//    }
}
