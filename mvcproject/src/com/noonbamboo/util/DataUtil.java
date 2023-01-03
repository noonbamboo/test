package com.noonbamboo.util;
import java.sql.*;

public class DataUtil {
    public static final String URL="jdbc:mysql://127.0.0.1:3306/userinf?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    public static final String USERNAME="root";
    public static final String PASSWORD="123456";
    public static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private Connection conn;

    public DataUtil() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        //连接数据库
        Class.forName(DRIVER).newInstance();
        conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }


    //定义预编译方法
    public PreparedStatement getPrepareStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    };

    //定义普通编译方法
    public Statement getStatement() throws SQLException {
        return conn.createStatement();
    }

    //关闭资源
    public void closed() throws SQLException {
        conn.close();
    }
}
