# AndroidNative
 Android Native Plugin for Unity
 
项目目前处于开发阶段中，不保证功能可用

# 简介
适用于Unity引擎的安卓端Native插件，后续会开发更多功能，敬请期待

作者：Aaron（AKA. FengYan, 枫炎）

开源协议：[MIT License](https://github.com/Aaron8052/AndroidNative/blob/main/LICENSE)

# 信息

### IDE
[(Windows) Android Studio Dolphin | 2021.3.1 Patch 1](https://redirector.gvt1.com/edgedl/android/studio/install/2021.3.1.17/android-studio-2021.3.1.17-windows.exe)

### SDK版本
Target: 30（Android 11.0）
Min: 16（Android 4.1）
### 编程语言
[Java](https://github.com/Aaron8052/AndroidNative/blob/main/AndroidNative/src/main/java/com/aaronj/androidnative/AndroidNative.java)

# 使用

## Setup

### 选择一

- 前往 [Release](https://github.com/Aaron8052/AndroidNative/releases) 直接下载.aar文件导入到Unity项目的的Asset/Plugins文件夹

### 选择二

- Clone整个工程并使用上述的IDE打开，自行编译插件

## 导入Unity

- 将.aar插件导入到Unity项目的Assets/Plugins/Android中

- 设置插件平台为仅Android

- 创建并编写一个C#脚本用于调用.aar插件中的函数（方法）

- 懒得写脚本的话可以到 [Release](https://github.com/Aaron8052/AndroidNative/releases) 找写好的 AndroidNative.cs和 AndroidNative.aar直接用

# 功能

## 分享

`public void shareTextAndImage(String title, String message, String url, String imagePath)`

`public void shareText(String message)`

`public void shareTextWithTitle(String title, String message)`

`public void shareTextWithURL(String title, String message, String url)`

# ISO

`public String getISOCountry()`

`public String getISOLanguage()`

## 电池 Battery

`public float getBatteryPercentage()`

# 注意事项

- 如果你的项目的Taget SDK 和 Min SDK 与此插件不一致，则需Clone工程修改SDK版本后自行编译aar

# 参考信息

https://developer.android.com/training/sharing/send#java

https://developer.android.com/training/monitoring-device-state/battery-monitoring
