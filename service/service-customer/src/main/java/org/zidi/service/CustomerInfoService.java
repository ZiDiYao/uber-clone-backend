package org.zidi.service;

import me.chanjar.weixin.common.error.WxErrorException;

public interface CustomerInfoService {

    public Long login(String code) throws WxErrorException;
}
