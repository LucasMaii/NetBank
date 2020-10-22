package repository;

import entity.Depositor;

import java.sql.Date;
import java.sql.Timestamp;

public interface ModifyRepository {

    //实现修改个人信息
    public abstract void modifyInfo(String tel, String gender, String address);

    //修改密码
    public abstract boolean modifyPassword(Depositor depositor,String oldPassword, String newPassword, String confirmPassword);

    //删除交易记录
    public abstract void deleteByCardId(Timestamp date);

}
