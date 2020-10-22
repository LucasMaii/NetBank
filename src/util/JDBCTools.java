package util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Auther Lucas_mai
 * @Date 2020/5/17
 */
public class JDBCTools {


    public static Connection getConnection() throws Exception {
        Properties properties = new Properties();
        InputStream inStream = JDBCTools.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(inStream);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url= properties.getProperty("url");
        String jdbcDriver= properties.getProperty("jdbcDriver");

        Class.forName(jdbcDriver);

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }


    public static void release(Connection connection, Statement statement, ResultSet resultSet){

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }




}
