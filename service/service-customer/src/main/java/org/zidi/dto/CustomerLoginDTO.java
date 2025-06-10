package org.zidi.dto;

import lombok.Data;

@Data
public class CustomerLoginDTO {
    private Long userId;
    private String openId;
    private String message; // 可选，比如“欢迎首次登录！”、“欢迎回来！”
}