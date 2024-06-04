package com.ntnn.saga.orchestration.service;

public class FlyBookingService extends Service<String> {
    @Override
    public String getName() {
        return "booking a Fly";
    }
}
