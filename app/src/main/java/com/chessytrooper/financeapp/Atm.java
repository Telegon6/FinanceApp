package com.chessytrooper.financeapp;



public class Atm {

    private String accountNo, card;
    private int balance;

    public Atm(String accountNo, String card, int balance) {
        this.accountNo = accountNo;
        this.card = card;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
