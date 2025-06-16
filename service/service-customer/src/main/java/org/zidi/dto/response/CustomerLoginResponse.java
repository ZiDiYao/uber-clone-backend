package org.zidi.dto.response;


import lombok.Data;

@Data
public class CustomerLoginResponse {

    private Long userId;
    private String nickname;
    private String avatarUrl;
    private String token;
    private String loginMessage;

}
