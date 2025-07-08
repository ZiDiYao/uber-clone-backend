package org.zidi.uber.common.core.Enum;

import lombok.Getter;

/**
 * Unified result status enumeration
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "Success"),
    FAIL(201, "Failure"),
    SERVICE_ERROR(2012, "Service Error"),
    DATA_ERROR(204, "Data Error"),
    ILLEGAL_REQUEST(205, "Illegal Request"),
    REPEAT_SUBMIT(206, "Duplicate Submission"),
    FEIGN_FAIL(207, "Remote Call Failed"),
    UPDATE_ERROR(204, "Data Update Failed"),

    ARGUMENT_VALID_ERROR(210, "Parameter Validation Error"),
    SIGN_ERROR(300, "Signature Error"),
    SIGN_OVERDUE(301, "Signature Expired"),
    VALIDATECODE_ERROR(218, "Verification Code Error"),

    LOGIN_AUTH(208, "Not Logged In"),
    PERMISSION(209, "Permission Denied"),
    ACCOUNT_ERROR(214, "Incorrect Account"),
    PASSWORD_ERROR(215, "Incorrect Password"),
    PHONE_CODE_ERROR(215, "Incorrect Phone Verification Code"),
    LOGIN_MOBLE_ERROR(216, "Incorrect Account"),
    ACCOUNT_STOP(216, "Account Disabled"),
    NODE_ERROR(217, "Cannot delete, sub-nodes exist"),

    COB_NEW_ORDER_FAIL(217, "Failed to Grab Order"),
    MAP_FAIL(217, "Map Service Call Failed"),
    PROFITSHARING_FAIL(217, "Profit Sharing Call Failed"),
    NO_START_SERVICE(217, "Driving Service Not Enabled, Cannot Update Location"),
    DRIVER_START_LOCATION_DISTION_ERROR(217, "Must be within 1km of the Start Point to Confirm"),
    DRIVER_END_LOCATION_DISTION_ERROR(217, "Must be within 2km of the End Point to Confirm"),
    IMAGE_AUDITION_FAIL(217, "Image Audit Failed"),
    AUTH_ERROR(217, "Driving Service Requires Identity Verification"),
    FACE_ERROR(250, "Face Recognition Not Completed Today"),

    COUPON_EXPIRE(250, "Coupon Expired"),
    COUPON_LESS(250, "Insufficient Coupon Stock"),
    COUPON_USER_LIMIT(250, "Coupon Claim Limit Exceeded"),
    ;

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
