package org.zidi.service.Impl;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zidi.service.CustomerInfoService;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {

    @Autowired
    private WxMaService wxMaService;

    /**
     *
     * For WX Login
     * @param code
     * @return
     */

    @Override
    public Long login(String code) throws WxErrorException {

        // 获取 Code 值 然后使用 微信工具包唯一标识 OpenID

        WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(code);

        // 根据 OpenID 去查询 MYSQL 表, 判断是不是第一次登入


        // 如果是 第一次登入, 那么就添加到 MySQL 然后返回 IP 值
        // 记入用户登入日志


        // 如果之前登入过, 允许登入


        return null;
    }
}
