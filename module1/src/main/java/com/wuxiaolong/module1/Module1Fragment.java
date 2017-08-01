package com.wuxiaolong.module1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.wuxiaolong.common.router.RouterConstants;


@Route(path = RouterConstants.MODULE1_MODULE1_FRAGMENT)
public class Module1Fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.module1_fragment_module1, container, false);
    }

}
