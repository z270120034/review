package com.test;

public class DrawMoney  extends Thread {
    private Account account ;
    private double drawMoney;

    public DrawMoney(Account account,String name,double drawMoney){
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch ( Exception e) {
                e.printStackTrace();
            }
            account.drawMoney(drawMoney);

        }

    }
}
