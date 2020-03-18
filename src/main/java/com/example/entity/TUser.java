package com.example.entity;

import lombok.Data;

/**
 * Copyright (C), 2019, 上海昌投网络科技有限公司
 * FileName: TUser
 *
 * @author: yufeng
 * @date: 2020/3/18 10:19
 * @description:
 */
@Data
public class TUser {

    private Long id;

    private String userName;

    private String realName;

    private Byte sex;

    private String mobile;

    private String email;

    private String note;

    private Long positionId;

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", sex=" + sex +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", note='" + note + '\'' +
                ", positionId=" + positionId +
                '}';
    }
}
