package com.ntnn.saga.choreography;

import com.ntnn.saga.choreography.core.Saga;
import com.ntnn.saga.choreography.core.ServiceDiscoveryService;
import com.ntnn.saga.choreography.service.FlyBookingService;
import com.ntnn.saga.choreography.service.HotelBookingService;
import com.ntnn.saga.choreography.service.OrderService;
import com.ntnn.saga.choreography.service.WithdrawMoneyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SagaApplication {
    public static void main(String[] args) {
        var sd = serviceDiscovery();
        var service = sd.findAny();
        var goodOrderSaga = service.execute(newSaga("good_order"));
        var badOrderSaga = service.execute(newSaga("bad_order"));
        log.info("orders: goodOrder is {}, badOrder is {}",
                goodOrderSaga.getResult(), badOrderSaga.getResult());

    }


    private static Saga newSaga(Object value) {
        return Saga
                .create()
                .chapter("init an order").setInValue(value)
                .chapter("booking a Fly")
                .chapter("booking a Hotel")
                .chapter("withdrawing Money");
    }

    private static ServiceDiscoveryService serviceDiscovery() {
        var sd = new ServiceDiscoveryService();
        return sd
                .discover(new OrderService(sd))
                .discover(new FlyBookingService(sd))
                .discover(new HotelBookingService(sd))
                .discover(new WithdrawMoneyService(sd));
    }
}
