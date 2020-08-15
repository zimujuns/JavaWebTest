package com.mzimu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {



    public static Connection getConn() {
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mysql?serverTimezone=UTC&characterEncoding=GBK","root","");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化失败 缺少包类");
        }
        return conn;
    }
}
