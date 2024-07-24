# Godot Wechatpay Android Plugin
This is an Android plugin for Godot Engine 4.2, providing Godot client support for WeChat Pay's in-app payment. It also supports Tencent's AdView platform for interstitial ads. Additionally, it includes the ability to copy text to the Android clipboard and paste from the clipboard.

## Contents
It inherits from the Godot Android plugin template, for basic usage and configuration, please refer to this repository:
https://github.com/m4gr3d/Godot-Android-Plugin-Template

## Usage
**Note:** [Android Studio](https://developer.android.com/studio) is the recommended IDE for
developing Godot Android plugins. 
You can install the latest version from https://developer.android.com/studio.

* Wechatpay:
  * Open [plugin/src/main/java/org/godotengine/plugin/android/template/Wechatpay.java] and replace your AppID in line20.
  * Now your can use function "WechatPaying" in Godot. When using it, you need to pass in four parameters(prepayid,nonStr,timestamp,sign), all of which are received from your backend server through the network. You can refer to the WeChat payment developer documentation for more information. https://pay.weixin.qq.com/docs/merchant/products/in-app-payment/development.html

* TecentAd:
  * Open [plugin/src/main/java/org/godotengine/plugin/android/template/GodotAndroidPlugin.kt] and replace your AppID in line54.
  * Now your can use function "interAd" in Godot. When using it, you need to pass in one parameters(AdId),you can get this on Ad platform:https://adnet.qq.com/

* Copy & Paste:
  * You can use function "copy" by  pass in one String you wanna copy. And function "paste" will return text from the clipboard.
