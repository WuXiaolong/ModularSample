package com.wuxiaolong.modularsample

import android.os.Bundle
import android.support.v4.app.Fragment

import com.alibaba.android.arouter.launcher.ARouter
import com.wuxiaolong.common.activity.BaseActivity
import com.wuxiaolong.common.model.UserModel
import com.wuxiaolong.router.Module1Service
import com.wuxiaolong.router.RouterConstants
import com.wuxiaolong.router.RouterUtils
import kotlinx.android.synthetic.main.app_activity_main.*


/**
 * Created by WuXiaolong on 2017/7/24.
 * 个人博客：http：//wuxiaolong.me
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_activity_main)
        initToolBarAsHome(getString(R.string.app))
        button1.setOnClickListener {
            RouterUtils.navigation(RouterConstants.MODULE1_MAIN_ACTIVITY)
        }
        button2.setOnClickListener {
            val userModel = UserModel()
            userModel.name = "WuXiaolong"
            userModel.message = "个人博客：http：//wuxiaolong.me"
            val bundle = Bundle()
            bundle.putSerializable("obj", userModel)
            ARouter.getInstance()
                    .build(RouterConstants.MODULE1_MAIN_ACTIVITY)
                    .with(bundle)
                    .navigation()
        }
        button3.setOnClickListener {
            showFragment()
        }
        button4.setOnClickListener {
            val module1Service = RouterUtils.navigation(RouterConstants.MODULE1_SERVICE_IMPL) as? Module1Service
            module1Service?.let {
                toastShow("结果：" + module1Service.share())
            }
        }
    }

    private fun showFragment() {
        // 获取Fragment
        val fragment = RouterUtils.navigation(RouterConstants.MODULE1_MODULE1_FRAGMENT) as? Fragment
        fragment?.let {
            supportFragmentManager.beginTransaction().add(R.id.contentLayout, fragment).commit()
        }
    }
}
