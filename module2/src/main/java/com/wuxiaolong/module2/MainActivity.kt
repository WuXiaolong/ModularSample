package com.wuxiaolong.module2

import android.os.Bundle

import com.alibaba.android.arouter.facade.annotation.Route
import com.wuxiaolong.common.activity.BaseActivity
import com.wuxiaolong.common.model.WeatherModel
import com.wuxiaolong.common.retrofit.ApiCallback
import com.wuxiaolong.router.RouterConstants
import kotlinx.android.synthetic.main.module2_activity_main.*

@Route(path = RouterConstants.MODULE2_MAIN_ACTIVITY)
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.module2_activity_main)
        initToolBar(getString(R.string.module2))

        module2_button.setOnClickListener {
            loadWeatherData()
        }
    }

    //全国+国外主要城市代码http://mobile.weather.com.cn/js/citylist.xml
    private fun loadWeatherData() {
        showProgressDialog()
        addSubscription(apiStores().loadWeatherData("101190201"),
                object : ApiCallback<WeatherModel>() {
                    override fun onSuccess(model: WeatherModel) {
                        val weatherinfo = model.weatherinfo
                        val showData = (resources.getString(R.string.city) + weatherinfo.city
                                + resources.getString(R.string.wd) + weatherinfo.wd
                                + resources.getString(R.string.ws) + weatherinfo.ws
                                + resources.getString(R.string.time) + weatherinfo.time)
                        module2_textview!!.text = showData
                    }

                    override fun onFailure(msg: String) {
                        toastShow(msg)

                    }

                    override fun onFinish() {
                        dismissProgressDialog()
                    }
                })
    }
}
