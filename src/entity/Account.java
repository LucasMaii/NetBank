package entity;

/**
 * @Auther Lucas_mai
 * @Date 2020/6/8
 */
public class Account {

    private String cardID;
    private String status;
    private String credit;
    private Double balance;

    public Account(String cardID, String status, String credit, Double balance) {
        this.cardID = cardID;
        this.status = status;
        this.credit = credit;
        this.balance = balance;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "cardID='" + cardID + '\'' +
                ", status='" + status + '\'' +
                ", credit='" + credit + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
