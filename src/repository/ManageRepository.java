package repository;

import entity.Depositor;

import java.util.List;

/**
 * @Auther Lucas_mai
 * @Date 2020/6/11
 */
public interface ManageRepository {

    public abstract List<Depositor> findAll();

    public abstract void add(String username, String password, String name, String tel, String cardid, String pid, String gender);

    public abstract void deleteById(String cardId);

    public abstract Depositor findById(String cardid);

    public abstract void update(String cardId,String name, String tel, String pid, String gender,String address);

}
