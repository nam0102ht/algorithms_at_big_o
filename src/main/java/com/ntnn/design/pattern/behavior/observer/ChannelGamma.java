package com.ntnn.design.pattern.behavior.observer;

public class ChannelGamma implements Observer {
    public void update(String msg){
        System.out.println("CHANNEL GAMMA: " + msg);
    }
}
