package entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Auther Lucas_mai
 * @Date 2020/6/7
 */
public class Transfer {

    private String mycardId;
    private Double amountTransferred;
    private String payee;
    private String cardidOfPayee;
    private String remarks;
    private Timestamp transferTime;


    public Transfer(String mycardId, double amountTransferred, String payee, String cardidOfPayee, String remarks, Timestamp transferTime) {
        this.mycardId = mycardId;
        this.amountTransferred = amountTransferred;
        this.payee = payee;
        this.cardidOfPayee = cardidOfPayee;
        this.remarks = remarks;
        this.transferTime = transferTime;
    }

    public String getMycardId() {
        return mycardId;
    }

    public void setMycardId(String mycardId) {
        this.mycardId = mycardId;
    }

    public void setAmountTransferred(Double amountTransferred) {
        this.amountTransferred = amountTransferred;
    }

    public Double getAmountTransferred() {
        return amountTransferred;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getCardidOfPayee() {
        return cardidOfPayee;
    }

    public void setCardidOfPayee(String cardidOfPayee) {
        this.cardidOfPayee = cardidOfPayee;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


    public Timestamp getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(Timestamp transferTime) {
        this.transferTime = transferTime;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "mycardId='" + mycardId + '\'' +
                ", amountTransferred='" + amountTransferred + '\'' +
                ", payee='" + payee + '\'' +
                ", cardidOfPayee='" + cardidOfPayee + '\'' +
                ", remarks='" + remarks + '\'' +
                ", transferTime='" + transferTime + '\'' +
                '}'+ "\n";
    }
}
