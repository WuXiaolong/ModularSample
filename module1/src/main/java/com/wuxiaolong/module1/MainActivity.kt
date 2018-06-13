package com.wuxiaolong.module1

import android.os.Bundle

import com.alibaba.android.arouter.facade.annotation.Route
import com.wuxiaolong.common.activity.BaseActivity
import com.wuxiaolong.common.model.UserModel
import com.wuxiaolong.router.RouterConstants
import com.wuxiaolong.router.RouterUtils
import kotlinx.android.synthetic.main.module1_activity_main.*


@Route(path = RouterConstants.MODULE1_MAIN_ACTIVITY)
class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.module1_activity_main)
        initToolBar(getString(R.string.module1))

        if (this.intent != null) {
            val userModel = this.intent.getSerializableExtra("obj") as? UserModel
            userModel?.let {
                module1_button.text = "带参数：${userModel.name} ，${userModel.message}"
            }
        }
        module1_button.setOnClickListener {
            RouterUtils.navigation(RouterConstants.MODULE2_MAIN_ACTIVITY)
        }
    }
}