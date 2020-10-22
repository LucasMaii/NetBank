package repository.Impl;

import entity.Depositor;
import repository.ManageRepository;
import util.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther Lucas_mai
 * @Date 2020/6/11
 */
public class ManageRepositoryImpl implements ManageRepository {


    @Override
    public List<Depositor> findAll() {

        List<Depositor> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCTools.getConnection();
            System.out.println(connection);
            String sql = "select * from depositor";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Depositor depositor = null;
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String tel = resultSet.getString(5);
                String cardid = resultSet.getString(6);
                String pid = resultSet.getString(7);
                String gender = resultSet.getString(8);
                String address = resultSet.getString(9);
                depositor = new Depositor(username,password,name,
                        tel,cardid,pid,gender,address);
                list.add(depositor);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public void add(String username, String password, String name, String tel, String cardid, String pid, String gender) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCTools.getConnection();
            System.out.println(connection);
            String sql = "insert into depositor(username,password, name, tel, cardid, pid, gender) values (?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, tel);
            preparedStatement.setString(5, cardid);
            preparedStatement.setString(6, pid);
            preparedStatement.setString(7, gender);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void deleteById(String cardId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCTools.getConnection();

            String sql = "delete from depositor where cardid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cardId);
            preparedStatement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Depositor findById(String cardid) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Depositor depositor = null;

        try {
            connection = JDBCTools.getConnection();
            String sql = "select * from depositor where cardid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cardid);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                preparedStatement = connection.prepareStatement(sql);
                String depositorId1 = resultSet.getString(1);
                String username = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String tel = resultSet.getString(5);
                cardid = resultSet.getString(6);
                String pid = resultSet.getString(7);
                String gender = resultSet.getString(8);
                String address = resultSet.getString(9);
                depositor = new Depositor(username,password,name,
                        tel,cardid,pid,gender,address);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return depositor;

    }

    @Override
    public void update(String cardId,String name, String tel, String pid, String gender,String address){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCTools.getConnection();
            System.out.println(connection);
            String sql = "update depositor set name = ?, tel = ? , cardid = ?,pid = ?, gender = ?, address = ? where cardid = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, tel);
            preparedStatement.setString(3, cardId);
            preparedStatement.setString(4, pid);
            preparedStatement.setString(5, gender);
            preparedStatement.setString(6,address);
            preparedStatement.setString(7,cardId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
