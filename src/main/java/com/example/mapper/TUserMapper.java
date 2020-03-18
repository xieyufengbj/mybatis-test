package com.example.mapper;

import com.example.entity.TUser;

/**
 * Copyright (C), 2019, 上海昌投网络科技有限公司
 * FileName: TUserMapper
 *
 * @author: yufeng
 * @date: 2020/3/18 10:25
 * @description:
 */
public interface TUserMapper {

    TUser selectByPrimaryKey(Long id);
}
