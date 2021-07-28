package com.lightyear.librarypremission.premission;

/**
*ManifestRegisterException
*动态申请的权限没有在清单文件中注册会抛出的异常
*author Light Year
*email 674919909@qq.com
* created 2021/7/28
*
*/
final class ManifestRegisterException extends RuntimeException {

    ManifestRegisterException() {
        // 清单文件中没有注册任何权限
        super("No permissions are registered in the manifest file");
    }

    ManifestRegisterException(String permission) {
        // 申请的危险权限没有在清单文件中注册
        super(permission + ": Permissions are not registered in the manifest file");
    }
}