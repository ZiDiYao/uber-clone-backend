package org.zidi.dto.response;

import lombok.Data;

@Data
public class CustomerInfoResponse {

    private Long userId;             //  ID
    private String nickname;
    private String avatarUrl;
    private String gender;
    private String phoneNumber;
    private Integer status;
    private String registerTime;
}
