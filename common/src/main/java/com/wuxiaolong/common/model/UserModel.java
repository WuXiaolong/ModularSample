package com.wuxiaolong.common.model;

import java.io.Serializable;

/**
 * Created by WuXiaolong on 2017/7/24.
 * 个人博客：http：//wuxiaolong.me
 */

public class UserModel implements Serializable{
    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
