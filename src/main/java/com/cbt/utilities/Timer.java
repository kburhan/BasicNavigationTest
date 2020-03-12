package com.cbt.utilities;

public class Timer {
    public static void wait(int num){
        try{
           Thread.sleep(1000*num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
