package repository.Impl;

import entity.Depositor;
import entity.Transfer;
import repository.TransferRepository;
import util.JDBCTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @Auther Lucas_mai
 * @Date 2020/6/7
 */
public class TransferRepositoryImpl implements TransferRepository {


    @Override
    public boolean transfer(String mycardId, double amountTransferred, String payee, String cardIdOfPayee, String remarks){

        boolean flag = transaction(mycardId,amountTransferred,cardIdOfPayee);
        if(flag) {

            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            Date date = new Date(System.currentTimeMillis());
            Time time = new Time(System.currentTimeMillis());
            String datetime = date.toString() + " " + time.toString();

            try {
                connection = JDBCTools.getConnection();
                String sql = "insert into trade(cardId,AmountTransferred,payee,cardIdOfPayee,remarks,transferTime) values(?,?,?,?,?,?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, mycardId);
                preparedStatement.setDouble(2, amountTransferred);
                preparedStatement.setString(3, payee);
                preparedStatement.setString(4, cardIdOfPayee);
                preparedStatement.setString(5, remarks);
                preparedStatement.setString(6, datetime);
                preparedStatement.executeUpdate();


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCTools.release(connection, preparedStatement, resultSet);
            }
        }else{
            System.out.println("账户余额不足，无法完成交易！！！");
        }

        return flag;
    }

    @Override
    public List<Transfer> findAllOfTransfer(Depositor depositor) {

        String card = depositor.getCardid();
        System.out.println(card);
        List<Transfer> list = new ArrayList<>();
        Transfer transfer = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCTools.getConnection();
            String sql = "select * from trade where cardId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,card);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                String mycardId = resultSet.getString(1);
                Double amountTransferred = resultSet.getDouble(2);
                String payee = resultSet.getString(3);
                String cardidOfPayee = resultSet.getString(4);
                String remarks = resultSet.getString(5);
                Timestamp datetime = resultSet.getTimestamp(6);


                System.out.println(mycardId+amountTransferred+payee+cardidOfPayee+remarks+datetime);
                transfer = new Transfer(mycardId,amountTransferred,payee,cardidOfPayee,remarks,datetime);
                list.add(transfer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }

        return list;
    }

    @Override
    public boolean transaction(String cardId, double money,String cardIdOfPayee) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Double balance = -1.0;
        boolean flag = false;

        try {
            connection = JDBCTools.getConnection();
            String sql = "select balance from account where cardID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,cardId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                balance = resultSet.getDouble(1);
                System.out.println("转账人余额："+ balance);
            }

            if(money <= balance && money > 0){
                double sum = balance - money;
                sql = " update account set balance = ? where cardID = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setDouble(1,sum);
                preparedStatement.setString(2,cardId);
                preparedStatement.executeUpdate();
                flag = true;
                System.out.println("转账成功！");
            }else{
                System.out.println("转账失败！");
            }

            if(cardIdOfPayee != null && flag == true){

                sql = "select balance from account where cardID = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,cardIdOfPayee);
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    balance = resultSet.getDouble(1);
                    System.out.println("收款人余额"+ balance);
                }

                double sum = balance + money;
                sql = " update account set balance = ? where cardID = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setDouble(1,sum);
                preparedStatement.setString(2,cardIdOfPayee);
                preparedStatement.executeUpdate();
                System.out.println("收款成功！");

            }else {
                System.out.println("收款失败!");
            }




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }

        return flag;

    }


//    public static void main(String[] args) {
        //测试函数
//        TransferRepositoryImpl transferDepository = new TransferRepositoryImpl();
//        transferDepository.transfer("123123123123","5000","你好！！！","123123123123123","no");

//
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        System.out.println(timestamp);
//
//        Time time = new Time(System.currentTimeMillis());
//        System.out.println(time);
//    }


//
//    public static void main(String[] args) {
//
//        Depositor depositor = new Depositor("","","","","6217280000000000000000","","");
//        TransferRepositoryImpl transferDepository = new TransferRepositoryImpl();
//        List<Transfer> list = transferDepository.findAllOfTransfer(depositor);
//        System.out.println(list);
//    }

    public static void main(String[] args) {

        TransferRepositoryImpl transferDepository = new TransferRepositoryImpl();
        System.out.println(transferDepository.transaction("6217280000000000000",200,"6217280937222222222"));

    }
}
