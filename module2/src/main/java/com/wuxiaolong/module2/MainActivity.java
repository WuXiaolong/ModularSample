package com.wuxiaolong.module2;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wuxiaolong.common.activity.ButterKnifeActivity;
import com.wuxiaolong.common.model.WeatherModel;
import com.wuxiaolong.common.retrofit.ApiCallback;
import com.wuxiaolong.common.router.RouterConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = RouterConstants.MODULE2_MAIN_ACTIVITY)
public class MainActivity extends ButterKnifeActivity {


    @BindView(R2.id.module2_textview)
    TextView module2Textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module2_activity_main);
        ButterKnife.bind(this);
        initToolBar(getString(R.string.module2));
    }

    //全国+国外主要城市代码http://mobile.weather.com.cn/js/citylist.xml
    private void loadWeatherData() {
        showProgressDialog();
        addSubscription(apiStores().loadWeatherData("101190201"),
                new ApiCallback<WeatherModel>() {
                    @Override
                    public void onSuccess(WeatherModel model) {
                        WeatherModel.WeatherinfoBean weatherinfo = model.getWeatherinfo();
                        String showData = getResources().getString(R.string.city) + weatherinfo.getCity()
                                + getResources().getString(R.string.wd) + weatherinfo.getWD()
                                + getResources().getString(R.string.ws) + weatherinfo.getWS()
                                + getResources().getString(R.string.time) + weatherinfo.getTime();
                        module2Textview.setText(showData);
                    }

                    @Override
                    public void onFailure(String msg) {
                        toastShow(msg);

                    }

                    @Override
                    public void onFinish() {
                        dismissProgressDialog();
                    }
                });
    }

    @OnClick(R2.id.module2_button)
    public void onViewClicked() {
        loadWeatherData();
    }
}
