package com.study.single;

public class SingleInstanceHunger {



    private static SingleInstanceHunger sih = new SingleInstanceHunger();

    private SingleInstanceHunger(){

    }

    public static SingleInstanceHunger getInstance(){
        return sih;
    }


}
