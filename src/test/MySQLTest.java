package test;

import util.JDBCTools;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Auther Lucas_mai
 * @Date 2020/5/17
 */
public class MySQLTest {

    public static void main(String[] args) {

        try {
            Connection connection = JDBCTools.getConnection();
            System.out.println(connection);
            JDBCTools.release(connection,null,null);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
