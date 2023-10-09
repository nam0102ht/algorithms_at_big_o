package com.ntnn.design.pattern.behavior.observer;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void update(String msg);
}
