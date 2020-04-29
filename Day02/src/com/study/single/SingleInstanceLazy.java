package com.study.single;

public class SingleInstanceLazy {



    private static SingleInstanceLazy sil ;

    private SingleInstanceLazy(){

    }

    public static SingleInstanceLazy getInstance(){

        if (sil==null){
             sil=new SingleInstanceLazy();
        }
        return sil;
    }


}
