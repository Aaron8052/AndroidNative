# AndroidNative
 Android Native Plugin for Unity

# 简介
适用于Unity引擎的安卓端Native插件，后续会开发更多功能，敬请期待

作者：Aaron（AKA. FengYan, 枫炎）

开源协议：[MIT License](https://github.com/Aaron8052/AndroidNative/blob/main/LICENSE)

# 信息

### IDE
[(Windows) Android Studio Dolphin | 2021.3.1 Patch 1](https://redirector.gvt1.com/edgedl/android/studio/install/2021.3.1.17/android-studio-2021.3.1.17-windows.exe)

### SDK版本
Target: 23（Android 6.0）
Min: 16（Android 4.1）
### 编程语言
Java

# 使用

## Setup

### 选择一

- 前往 [Release](https://github.com/Aaron8052/AndroidNative/releases) 直接下载.aar文件导入到Unity项目的的Asset/Plugins文件夹

### 选择二

- Clone整个工程并使用上述的IDE打开，自行编译插件

## 导入Unity

- 将.aar插件导入到Unity项目的Assets/Plugins/Android中

- 设置插件平台为仅Android

- 创建并编写一个C#脚本用于调用.aar插件中的函数（方法）:

`public void Share(String title, String message, String url, String imagePath)`

`public void Share(String message)`

`public void Share(String title, String message)`

`public void Share(String title, String message, String url)`

- 懒得写脚本的话可以到 [Release](https://github.com/Aaron8052/AndroidNative/releases) 找写好的 AndroidNative.cs和 AndroidNative.aar直接用

# 注意事项

- 如果你的项目的Taget SDK 和 Min SDK 与此插件不一致，则需Clone工程修改SDK版本后自行编译aar
