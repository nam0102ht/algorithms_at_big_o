package com.ntnn.design.pattern.behavior.observer;


//OBSERVER
public class ChannelAlpha implements Observer {
    public void update(String msg){
        System.out.println("CHANNEL ALPHA: " + msg);
    }
}
