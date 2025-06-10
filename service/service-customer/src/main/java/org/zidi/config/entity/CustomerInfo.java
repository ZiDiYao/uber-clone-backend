package org.zidi.config.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerInfo {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String wxOpenId;      // 微信 openid（唯一标识）
    private String nickname;      // 用户昵称
    private String avatarUrl;     // 用户头像地址
    private String phone;         // 手机号（绑定后）

    private LocalDateTime createTime; // 注册时间
    private LocalDateTime updateTime; // 最后更新时间
}