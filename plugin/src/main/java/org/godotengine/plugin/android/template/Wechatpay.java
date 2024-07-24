package org.godotengine.plugin.android.template;


import android.content.Context;
import android.util.Log;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class Wechatpay {
    private IWXAPI msgApi;
    public String prepayid;
    public String timeStamp;
    public String nonceStr;
    public String sign;
    public Wechatpay(Context context, String preid,String nonStr,String time,String Sign) {
        msgApi = WXAPIFactory.createWXAPI(context, null);
        //替换成你自己的微信开放平台AppID
        msgApi.registerApp("YourWechatAppid"); // TODO: 从安全的地方获取 App ID
        Log.e("Wechatpay: ", "微信支付初始化成功");
        nonceStr = nonStr;
        timeStamp = time;
        sign = Sign;
        prepayid = preid;
        Sendpayinfo();
    }

    // 向微信客户端发送请求，拉起微信支付
    public void Sendpayinfo(){

        PayReq request = new PayReq();
        request.appId = "wx992058c9e4cd2021";
        request.partnerId = "1667358221";
        request.prepayId= prepayid;
        request.packageValue = "Sign=WXPay";
        request.nonceStr= nonceStr;
        request.timeStamp= timeStamp;
        request.sign= sign;
        msgApi.sendReq(request);
    }


}
