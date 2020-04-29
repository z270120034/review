package com.test;

public class SaveMoney extends Thread {
    private Account account ;
    private double saveMoney;

    public SaveMoney(Account account, String name, double saveMoney){
        super(name);
        this.account = account;
        this.saveMoney = saveMoney;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(3000);
            } catch ( Exception e) {
                e.printStackTrace();
            }
            account.saveMoney(saveMoney);
        }

    }
}
