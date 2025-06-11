//package org.zidi.uber;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.zidi.dto.response.CustomerLoginResponse;
//
//import java.io.Serializable;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class ApiResponse implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    private int code;
//    private String message;
//    private CustomerLoginResponse data;
//
//    // 成功响应（带数据）
//    public static ApiResponse ok(CustomerLoginResponse data) {
//        return new ApiResponse(200, "Success", data);
//    }
//
//    // 成功响应（不带数据）
//    public static ApiResponse ok() {
//        return new ApiResponse(200, "Success", null);
//    }
//
//    // 失败响应（自定义消息）
//    public static ApiResponse fail(String message) {
//        return new ApiResponse(500, message, null);
//    }
//
//    // 完全自定义响应
//    public static ApiResponse of(int code, String message, CustomerLoginResponse data) {
//        return new ApiResponse(code, message, data);
//    }
//}
