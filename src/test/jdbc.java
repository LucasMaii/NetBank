package test;

/**
 * @Auther Lucas_mai
 * @Date 2020/6/20
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class jdbc {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8","root","123456789");
            System.out.println(conn);
            System.out.println("2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
