package com.ntnn.saga.choreography.service;

import com.ntnn.saga.choreography.core.ServiceDiscoveryService;

public class FlyBookingService extends Service {
    public FlyBookingService(ServiceDiscoveryService service) {
        super(service);
    }

    @Override
    public String getName() {
        return "booking a Fly";
    }
}
