package com.ntnn.design.pattern.behavior.observer;

public class ChannelBeta implements Observer {
    public void update(String msg){
        System.out.println("CHANNEL BETA: " + msg);
    }
}
