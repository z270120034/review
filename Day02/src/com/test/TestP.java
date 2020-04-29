package com.test;


import java.util.Map;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class TestP {

    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();
        new Boy(exchanger).start();
        new Girl(exchanger).start();


    }
}

class Boy extends Thread{

    private Exchanger<String> exchanger;
    public Boy(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("男生的礼物 ❥(^_-)");
//            Thread.sleep(3000);//超过等待时间会报错TimeoutException
            String rs = exchanger.exchange("❥(^_-)");
            System.out.println("男生得到的礼物："+rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Girl extends Thread{


    private Exchanger<String> exchanger;
    public Girl(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println("女生的礼物：一句话");
            //等待2秒
//            String rs = exchanger.exchange("你是个好人",2, TimeUnit.SECONDS);
//            System.out.println("女生得到的礼物："+rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}