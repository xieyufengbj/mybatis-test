package com.example.test1;

import com.example.entity.TUser;
import com.example.mapper.TUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright (C), 2019, 上海昌投网络科技有限公司
 * FileName: MybatisQuickStartTest
 *
 * @author: yufeng
 * @date: 2020/3/18 17:06
 * @description:
 */


public class MybatisQuickStartTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 1、读取mybatis配置文件创建sqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void quickStart() {
        // 2、获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3、获取对应mapper
        TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);
        // 4、执行查询语句并返回结果
        TUser tUser = mapper.selectByPrimaryKey(1L);
        System.out.println(tUser.toString());
    }
}
