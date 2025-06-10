package org.zidi.config;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 *  创建微信工具包的对象
 *
 *
 */
@Component
public class WxConfigOperator {

    @Autowired
    WxConfigProperties wxConfigProperties;
    @Bean
    public WxMaService wxMaService(){

        WxMaDefaultConfigImpl wxMaConfig = new WxMaDefaultConfigImpl();
        // appId
        wxMaConfig.setAppid(wxConfigProperties.getAppId());
        // secrete
        wxMaConfig.setSecret(wxConfigProperties.getSecret());
        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(wxMaConfig);
        return service;
    }
}
