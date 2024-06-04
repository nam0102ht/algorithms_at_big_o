package com.ntnn.saga.choreography.service;

import com.ntnn.saga.choreography.core.ServiceDiscoveryService;

public class OrderService extends Service {

    public OrderService(ServiceDiscoveryService service) {
        super(service);
    }

    @Override
    public String getName() {
        return "init an order";
    }
}