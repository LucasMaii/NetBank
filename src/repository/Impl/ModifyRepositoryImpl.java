package repository.Impl;

import entity.Depositor;
import repository.ModifyRepository;
import util.JDBCTools;

import java.sql.*;

/**
 * @Auther Lucas_mai
 * @Date 2020/6/9
 */
public class ModifyRepositoryImpl implements ModifyRepository {


    @Override
    public void modifyInfo(String tel, String gender, String address) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCTools.getConnection();
            String sql = "update depositor set  tel= ?, gender = ?, address = ? where tel = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,tel);
            preparedStatement.setString(2,gender);
            preparedStatement.setString(3,address);
            preparedStatement.setString(4,tel);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }

    }

    @Override
    public boolean modifyPassword(Depositor depositor,String oldPassword, String newPassword, String confirmPassword) {


        boolean flag = false;

        if(newPassword.equals(confirmPassword)){

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            String tel = depositor.getTel();
            String oldpass = null;

            try {
                connection = JDBCTools.getConnection();
                String sql = "select password from depositor where tel = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,tel);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                     oldpass = resultSet.getString(1);
                }

                if(oldPassword.equals(oldpass)){

                    sql = "update depositor set password = ? where tel = ?";
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,newPassword);
                    preparedStatement.setString(2,tel);
                    preparedStatement.executeUpdate();
                    System.out.println("修改密码成功！");
                    flag = true;
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCTools.release(connection,preparedStatement,resultSet);
            }

        }

        return flag;

    }

    @Override
    public void deleteByCardId(Timestamp date) {

        System.out.println("获取到的时间"+date);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCTools.getConnection();
            String sql = "delete from trade where transferTime = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1,date);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }

    }
}
