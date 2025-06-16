package org.zidi.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class LogRecord {
    private Long id;
    private Long customerId;
    private String ipaddr;
    private Integer status;      // 可用于标记成功/失败，0/1
    private String msg;          // 操作描述
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Boolean isDeleted;
}
