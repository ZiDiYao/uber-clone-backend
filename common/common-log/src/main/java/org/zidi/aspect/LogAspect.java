package org.zidi.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Component;
import org.zidi.annotation.Log;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class LogAspect {
    private final ObjectMapper objectMapper = new ObjectMapper();

//    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(org.zidi.annotation.Log)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();

        // 获取方法签名和注解
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Log logAnno = method.getAnnotation(Log.class);

        // 获取请求参数
        String params = objectMapper.writeValueAsString(point.getArgs());

        // 模拟获取当前用户（实际项目中可从 token 中拿）
        String username = getCurrentUser();

        String module = logAnno.module();
        String operation = logAnno.operation();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

        Object result = null;
        boolean isError = false;
        String errorMsg = "";

        try {
            result = point.proceed();
            return result;
        } catch (Throwable ex) {
            isError = true;
            errorMsg = ex.getMessage();
            throw ex;
        } finally {
            long timeCost = System.currentTimeMillis() - start;
            String resultStr = result != null ? objectMapper.writeValueAsString(result) : "null";

            log.info("""
            🧾 AOP日志：
            🔹 user: {}
            🔹 module: {}
            🔹 operation: {}
            🔹 method: {}
            🔹 para: {}
            🔹 result: {}
            🔹 Time: {} ms
            🔹 Except: {}
            """, username, module, operation, methodName, params, resultStr, timeCost, isError ? errorMsg : "无");
        }
    }

    // 模拟从请求中获取当前用户
    private String getCurrentUser() {
        // 你可以从 SecurityContextHolder 或 token 中提取
        return "测试用户";
    }
}
