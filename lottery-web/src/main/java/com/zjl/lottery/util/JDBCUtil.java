package com.zjl.lottery.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

    static Properties pros = null;  //可以帮助读取和处理资源文件中的信息

    static {    //加载JDBCUtil类的时候调用
        pros = new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("properties/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getMysqlConn(){
        try {
            Class.forName(pros.getProperty("jdbc.driverClassName"));
            return DriverManager.getConnection(pros.getProperty("jdbc.url"),
                    pros.getProperty("jdbc.username"),pros.getProperty("jdbc.password"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //可以重载多个，这里就懒得写了
    public static void close(ResultSet rs,Statement st,Connection conn){

        try {
            if (rs!=null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (st!=null) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn!=null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
