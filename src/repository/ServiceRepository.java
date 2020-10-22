package repository;

import entity.Account;
import entity.Depositor;

/**
 *
 * 用来处理业务办理的接口
 *
 */

public interface ServiceRepository {

    //查找用户账户信息
    public abstract Account findAllOfAccount(Depositor depositor);

    //查找账户信息，多态
    public abstract Account findAllOfAccount(String cardId);

}
