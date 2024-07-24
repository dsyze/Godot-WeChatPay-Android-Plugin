// TODO: Update to match your plugin's package name.
package org.godotengine.plugin.android.template

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
import com.qq.e.comm.managers.GDTAdSdk
import com.qq.e.comm.managers.GDTAdSdk.OnStartListener
import com.qq.e.comm.util.AdError
import org.godotengine.godot.Godot
import org.godotengine.godot.plugin.GodotPlugin
import org.godotengine.godot.plugin.SignalInfo
import org.godotengine.godot.plugin.UsedByGodot

class GodotAndroidPlugin(godot: Godot): GodotPlugin(godot) {

    override fun getPluginName() = BuildConfig.GODOT_PLUGIN_NAME

    var InitAD: SignalInfo = SignalInfo("InitAD")
    var InterFail: SignalInfo = SignalInfo("InterFail")
    var InterSuccess: SignalInfo = SignalInfo("InterSuccess")
    var InterExposure: SignalInfo = SignalInfo("InterExposure")
    var InterLoaded: SignalInfo = SignalInfo("InterLoaded")
    var layout: FrameLayout? = null
    var Thisactivity: Activity? = null



    override fun getPluginSignals(): Set<SignalInfo> {
        val signals = hashSetOf(
            InterFail,
            InterSuccess,
            InterExposure,
            InterLoaded,
            InitAD
        )
        return signals
    }



    override fun onMainCreate(activity: Activity): View {
//        优量汇广告sdK初始化
        layout = FrameLayout(activity)
        val path = "ylh"
        //填写你的AppID
        val appID = "YourAPPID"

        GDTAdSdk.initWithoutStart(activity, appID)
        GDTAdSdk.start(object : OnStartListener {
            override fun onStartSuccess() {
                // 推荐开发者在onStartSuccess回调后开始拉广告
            }

            override fun onStartFailed(e: Exception) {
                Log.e("gdt onStartFailed:", e.toString())
            }
        })
        // PocketSdk.initSDK(activity, path, appID) // Uncomment if needed
        Log.e("SDK初始化成功:PATH", path)
        Log.e("SDK初始化成功:ID", appID)
        return layout as FrameLayout
    }

    var ad: UnifiedInterstitialAD? = null

    //展示插屏广告
    @UsedByGodot
    fun interAd(id: String) {
        val listener = object : UnifiedInterstitialADListener {
            override fun onADReceive() {
                Log.e("广告加载成功", "广告加载成功")
                // Implement onADReceive
            }

            override fun onVideoCached() {
                // Implement onVideoCached
            }

            override fun onNoAD(adError: AdError) {
                Log.e("adError:", adError.toString())
            }

            override fun onADOpened() {
                // Implement onADOpened
            }

            override fun onADExposure() {
                // Implement onADExposure
            }

            override fun onADClicked() {
                // Implement onADClicked
            }

            override fun onADLeftApplication() {
                // Implement onADLeftApplication
            }

            override fun onADClosed() {
                // Implement onADClosed
            }

            override fun onRenderSuccess() {
                Log.e("广告渲染成功", "广告渲染成功")
                ad?.show()
            }

            override fun onRenderFail() {
                Log.e("广告渲染失败", "广告渲染失败")
            }
        }
        ad = UnifiedInterstitialAD(activity, id, listener)
        ad?.loadAD()
        Log.e("广告开始加载", "广告开始加载")
    }



    //复制到剪切板
    @UsedByGodot
    private  fun copy(text: String){
        val textToCopy = text
        val clipboardManager = activity?.getSystemService(Context.CLIPBOARD_SERVICE)as ClipboardManager
        val clipData = ClipData.newPlainText("label", textToCopy)
        clipboardManager.setPrimaryClip(clipData)
        runOnUiThread {
            Toast.makeText(activity, "Copyed", Toast.LENGTH_LONG).show()
        }
    }

    //从剪切板粘贴
    @UsedByGodot
    private  fun paste(): String {
        val text:String
        val clipboardManager = activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = clipboardManager.primaryClip
        if (clipData != null && clipData.itemCount > 0) {
            // 获取第一个 ClipData.Item
            val item = clipData.getItemAt(0)
            text = item?.coerceToText(activity).toString()

        } else {
            text = ""
            // 剪切板为空或没有文本
            // 处理这种情况，例如显示一个提示
            // Toast.makeText(this, "剪切板中没有文本", Toast.LENGTH_SHORT).show()
        }
        return text
    }


    //微信支付调用
    var pay: Wechatpay? = null
    @UsedByGodot
    private fun WechatPaying(preid:String,nonStr:String,time:String,Sign:String) {
        pay = Wechatpay(activity,preid,nonStr,time,Sign)
    }

}
