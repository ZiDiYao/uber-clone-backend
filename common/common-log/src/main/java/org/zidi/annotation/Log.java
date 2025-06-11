package org.zidi.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String module();       // Modules name，如 "用户管理"
    String operation();    // Operation name，如 "新增用户"
}
