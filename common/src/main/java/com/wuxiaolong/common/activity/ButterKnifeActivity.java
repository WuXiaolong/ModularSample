package com.wuxiaolong.common.activity;

import android.support.annotation.LayoutRes;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ButterKnifeActivity extends BaseActivity {

    private Unbinder unbinder;


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }}
