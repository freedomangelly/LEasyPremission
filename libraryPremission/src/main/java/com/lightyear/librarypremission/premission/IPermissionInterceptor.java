package com.lightyear.librarypremission.premission;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

/**
*IPermissionInterceptor
*权限请求拦截器
*author Light Year
*email 674919909@qq.com
* created 2021/7/28
*
*/
public interface IPermissionInterceptor {

    /**
     * 权限申请拦截，可在此处先弹 Dialog 再申请权限
     */
    default void requestPermissions(FragmentActivity activity, OnPermissionCallback callback, List<String> permissions) {
        PermissionFragment.beginRequest(activity, new ArrayList<>(permissions), callback);
    }

    /**
     * 权限授予回调拦截，参见 {@link OnPermissionCallback#onGranted(List, boolean)}
     */
    default void grantedPermissions(FragmentActivity activity, OnPermissionCallback callback, List<String> permissions, boolean all) {
        callback.onGranted(permissions, all);
    }

    /**
     * 权限拒绝回调拦截，参见 {@link OnPermissionCallback#onDenied(List, boolean)}
     */
    default void deniedPermissions(FragmentActivity activity, OnPermissionCallback callback, List<String> permissions, boolean never) {
        callback.onDenied(permissions, never);
    }
}