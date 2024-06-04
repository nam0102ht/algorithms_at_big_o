package com.ntnn.saga.orchestration.service;

public class OrderService extends Service<String> {
    @Override
    public String getName() {
        return "init an order";
    }
}
