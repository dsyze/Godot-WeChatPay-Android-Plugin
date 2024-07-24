package org.godotengine.plugin.android.template;

import android.util.Log;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

public class WXEntryActivity implements IWXAPIEventHandler {
    @Override
    public void onReq(BaseReq baseReq) {
        // 这个方法将在微信向你的应用发送请求时被调用。
        // 你可以在这里处理微信的请求，比如登录授权或分享操作的开始。
    }

    @Override
    public void onResp(BaseResp baseResp) {
        // 这个方法将在你应用向微信发送请求后，微信返回结果时被调用。
        // 你可以在这里根据响应结果做相应的处理，比如检查登录是否成功或者分享是否完成。
    }
    // ...
}
