package org.zidi.uber.common.thirdparty.WeiXin;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Component;


@Component
public class WxAuthUtil {

    private final WxMaService wxMaService;

    public WxAuthUtil(WxMaService wxMaService) {
        this.wxMaService = wxMaService;
    }

    public String getOpenId(String code) {
        if ("mock".equals(code)) {
            return "mock-openid-123456";
        }
        try {
            WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(code);
            return session.getOpenid();
        } catch (WxErrorException e) {
            throw new RuntimeException("Can not access to openId", e);
        }
    }
}
