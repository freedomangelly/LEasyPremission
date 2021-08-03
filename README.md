# LEasyPremission
一款简单的权限框架

# 我的理念概述
我的理念的是能用一行代码解决的是，绝对不用两行
其实编写依赖库的目的就是将一个功能尽可能的完善
代码调用方便，简洁

# [LEasyPremission简书地址](https://github.com/freedomangelly/LEasyPremission)

# 优点
简洁易用：采用链式调用的方式，使用只需一句代码,其实是建造者模式链式调用

# 集成步骤
在项目根目录下的 build.gradle 文件中加入
```java
buildscript {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
在项目 app 模块下的 build.gradle 文件中加入
```java
android {
    // 支持 JDK 1.8
    compileOptions {
        targetCompatibility JavaVersion.VERSION_1_8
        sourceCompatibility JavaVersion.VERSION_1_8
    }
}

dependencies {
    // 权限请求框架
    implementation 'com.github.freedomangelly:LEasyPremission:0.0.0.1'
}
```
# 使用方法
```java
LEasyPermissions.with(this)
        // 申请安装包权限
        //.permission(Permission.REQUEST_INSTALL_PACKAGES)
        // 申请悬浮窗权限
        //.permission(Permission.SYSTEM_ALERT_WINDOW)
        // 申请通知栏权限
        //.permission(Permission.NOTIFICATION_SERVICE)
        // 申请系统设置权限
        //.permission(Permission.WRITE_SETTINGS)
        // 申请单个权限
        .permission(Permission.RECORD_AUDIO)
        // 申请多个权限
        .permission(Permission.Group.CALENDAR)
        .request(new OnPermissionCallback() {

            @Override
            public void onGranted(List<String> permissions, boolean all) {
                if (all) {
                   LogUtil.i("权限成功");
                } else {
                    LogUtil.i("获取部分权限成功，但部分权限未正常授予");
                }
            }

            @Override
            public void onDenied(List<String> permissions, boolean never) {
                if (never) {
                    LogUtil.i("被永久拒绝授权，请手动授予录音和日历权限");
                    // 如果是被永久拒绝就跳转到应用权限系统设置页面
                    LEasyPermissions.startPermissionActivity(MainActivity.this, permissions);
                } else {
                   LogUtil.i("获取录音和日历权限失败");
                }
            }
        });

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LEasyPermissions.REQUEST_CODE) {
            LogUtil.i("检测到你刚刚从权限设置界面返回回来");
        }
    }

```

