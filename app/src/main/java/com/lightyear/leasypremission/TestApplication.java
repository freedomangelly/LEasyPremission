package com.lightyear.leasypremission;

import android.app.Application;

import com.lightyear.leasytoast.ToastUtils;
import com.lightyear.librarypremission.premission.LEasyPermissions;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/XXPermissions
 *    time   : 2021/01/04
 *    desc   : 应用入口
 */
public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化吐司工具类
        ToastUtils.init(this);

        // 设置权限申请拦截器
        LEasyPermissions.setPermissionInterceptor(new PermissionInterceptor());
    }
}