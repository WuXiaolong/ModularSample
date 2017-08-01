package com.wuxiaolong.module1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wuxiaolong.common.activity.BaseActivity;
import com.wuxiaolong.common.model.UserModel;
import com.wuxiaolong.common.router.RouterConstants;
import com.wuxiaolong.common.router.RouterUtils;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RouterConstants.MODULE1_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {


    @BindView(R2.id.module1_text)
    TextView module1Text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module1_activity_main);
        initToolBar(getString(R.string.module1));

        if (this.getIntent() != null) {
            UserModel userModel = (UserModel) this.getIntent().getSerializableExtra("obj");
            if (userModel != null)
                module1Text.setText("带参数："+userModel.getName() + "，" + userModel.getMessage());
        }
    }

    /**
     * click方法中同样使用R2，但是找id的时候使用R，
     * ibrary中是不能使用 switch- case 找id的，原因：http://www.jianshu.com/p/89687f618837
     */
    @OnClick({R2.id.module1_button})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.module1_button) {
            RouterUtils.navigation(RouterConstants.MODULE2_MAIN_ACTIVITY);
        }
    }
}