package com.chessytrooper.financeapp;

public class TransactionDomain {

    private String pic;
    private String title;
    private String date;
    private String bill;

    public TransactionDomain(String pic, String title, String date, String bill) {
        this.pic = pic;
        this.title = title;
        this.date = date;
        this.bill = bill;
    }

    public String getPic() {
        return pic;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getBill() {
        return bill;
    }
}
