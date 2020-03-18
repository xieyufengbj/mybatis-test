package com.example.test1;

import com.example.entity.TUser;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Copyright (C), 2019, 上海昌投网络科技有限公司
 * FileName: JdbcDemoTest
 *
 * @author: yufeng
 * @date: 2020/3/18 11:44
 * @description:
 */
public class JdbcDemoTest {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mybatis-test?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    @Test
    public void queryStatementDemo() {
        Connection connection = null;
        Statement statement = null;
        List<TUser> userList = new ArrayList<>();

        try {
            // 注册mysql的驱动
            Class.forName(JDBC_DRIVER);
            // 获取一个连接
            System.out.println("connection to database ...");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // 创建一个查询
            System.out.println("creating statement ...");
            statement = connection.createStatement();
            System.out.println(statement.toString());
            String userName = "mark";
            String sql = "SELECT * FROM t_user WHERE user_name = '"+ userName +"'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                TUser tUser = new TUser();
                tUser.setId(resultSet.getLong("id"));
                tUser.setUserName(resultSet.getString("user_name"));
                tUser.setRealName(resultSet.getString("real_name"));
                tUser.setSex(resultSet.getByte("sex"));
                tUser.setMobile(resultSet.getString("mobile"));
                tUser.setEmail(resultSet.getString("email"));
                tUser.setNote(resultSet.getString("note"));

                userList.add(tUser);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(statement)) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("----------------------------------");
        System.out.println("there are" + userList.size() + " users in the list !");
        System.out.println("【编译模式】返回的对象结果：" + Arrays.asList(userList));
    }

    @Test
    public void queryPreparedStatementDemo() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<TUser> userList = new ArrayList<>();

        try {
            // 注册mysql的驱动
            Class.forName(JDBC_DRIVER);
            // 获取一个连接
            System.out.println("connection to database ...");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // 创建一个查询
            System.out.println("creating statement ...");
            String sql = "select * from t_user where user_name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "mark");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                TUser tUser = new TUser();
                tUser.setId(resultSet.getLong("id"));
                tUser.setUserName(resultSet.getString("user_name"));
                tUser.setRealName(resultSet.getString("real_name"));
                tUser.setSex(resultSet.getByte("sex"));
                tUser.setMobile(resultSet.getString("mobile"));
                tUser.setEmail(resultSet.getString("email"));
                tUser.setNote(resultSet.getString("note"));

                userList.add(tUser);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(preparedStatement)) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("----------------------------------");
        System.out.println("there are" + userList.size() + " users in the list !");
        System.out.println("【预编译模式】返回的对象结果：" + Arrays.asList(userList));
    }
}
