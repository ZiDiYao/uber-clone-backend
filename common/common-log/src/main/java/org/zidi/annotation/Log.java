package org.zidi.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String module();       // 模块名，如 "用户管理"
    String operation();    // 操作名，如 "新增用户"
}
