package com.yang.travel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 会员实体类
 * @author admin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private Integer id;
    private String name;
    private String nickName;
    private String phoneNum;
    private String email;

}
