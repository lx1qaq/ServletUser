package com.buercorp.longxiaolin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 小林
 * Create on 2024/3/14 12:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {
    private String address;
    private String nickname;
    private String gender;
    private String email;
}
