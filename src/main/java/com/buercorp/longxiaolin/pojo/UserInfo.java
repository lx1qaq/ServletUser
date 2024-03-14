package com.buercorp.longxiaolin.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 小林
 * Create on 2024/3/14 12:38
 */
@Data
public class UserInfo implements Serializable {
    private String address;
    private String nickname;
    private String gender;
    private String email;
}
