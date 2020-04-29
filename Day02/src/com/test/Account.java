package com.test;

public class Account {
    private String accountID;
    private double money;

    public  Account() {
    }

    public Account(String accountID, double money) {

        this.accountID = accountID;
        this.money = money;

    }

    public String getAccountID() {
        return accountID;

    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public  synchronized void drawMoney(double money) {

        String name = Thread.currentThread().getName();
        try {
            if (this.money>=money){
                this.money -= money;
                System.out.println(name+"取到了"+money);
//                this.notify();
                this.wait(1000);
            }else {
                System.out.println(name+"没取到钱，余额："+this.money);
//                this.notify();
                this.wait(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public synchronized void saveMoney(double saveMoney) {
        String name = Thread.currentThread().getName();
        try {
            if (this.money>0){
                System.out.println(name+"还有"+this.money);
//                this.notify();
                this.wait(1000);
            }else {
                this.money += saveMoney;
                System.out.println(name+"存了"+saveMoney);
//                this.notify();
                this.wait(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
