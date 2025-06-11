package org.zidi.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerInfo {

    @TableId(type = IdType.ASSIGN_ID) //  使用雪花算法生成 ID
    private Long id;

    private String wxOpenId;      // 微信 openid（唯一标识）
    private String nickname;      // 用户昵称
    private String gender;        // 性别
    private String avatarUrl;     // 用户头像地址
    private String phone;         // 手机号（绑定后）
    private Integer status;       // 状态（1有效，2禁用）

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime; // 注册时间

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime; // 最后更新时间

    @TableLogic
    private Integer isDeleted;        // 逻辑删除：0 正常，1 删除
}
