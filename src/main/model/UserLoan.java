package main.model;

import java.util.UUID;

public class UserLoan {
    private String id;
    private String userName;
    private String bankName;
    private int totalAmount;
    private int emiAmount;

    public UserLoan(String userName, String bankName, int totalAmount, int emiAmount) {
        this.id = UUID.randomUUID().toString();
        this.userName = userName;
        this.bankName = bankName;
        this.totalAmount = totalAmount;
        this.emiAmount = emiAmount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getEmiAmount() {
        return emiAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmiAmount(int emiAmount) {
        this.emiAmount = emiAmount;
    }
}
