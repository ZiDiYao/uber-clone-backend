//package org.zidi.dto;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.io.Serializable;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class ApiResponse<T> implements Serializable {
//    private static final long serialVersionUID = 1L;
//
//    private int code;
//    private String message;
//    private T data;
//
//    public static <T> ApiResponse<T> ok(T data) {
//        return new ApiResponse<>(200, "Success", data);
//    }
//
//    public static <T> ApiResponse<T> ok() {
//        return new ApiResponse<>(200, "Success", null);
//    }
//
//    public static <T> ApiResponse<T> fail(String message) {
//        return new ApiResponse<>(500, message, null);
//    }
//
//    public static <T> ApiResponse<T> of(int code, String message, T data) {
//        return new ApiResponse<>(code, message, data);
//    }
//}
