package main.model;

public class Payment {
    private String userAccountId;
    private int month;
    private int amountPaid;

    public Payment(String id, int month, int amountPaid) {
        this.userAccountId = id;
        this.month = month;
        this.amountPaid = amountPaid;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }
}
