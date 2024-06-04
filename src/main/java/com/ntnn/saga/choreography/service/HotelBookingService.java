package com.ntnn.saga.choreography.service;

import com.ntnn.saga.choreography.core.ServiceDiscoveryService;

public class HotelBookingService extends Service {
    public HotelBookingService(ServiceDiscoveryService service) {
        super(service);
    }

    @Override
    public String getName() {
        return "booking a Hotel";
    }


}