package com.ntnn.saga.orchestration;

import com.ntnn.saga.orchestration.core.Saga;
import com.ntnn.saga.orchestration.core.ServiceDiscoveryService;
import com.ntnn.saga.orchestration.service.FlyBookingService;
import com.ntnn.saga.orchestration.service.HotelBookingService;
import com.ntnn.saga.orchestration.service.OrderService;
import com.ntnn.saga.orchestration.service.WithdrawMoneyService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SagaApplication {
    public static void main(String[] args) {
        var sagaOrchestrator = new SagaOrchestrator(newSaga(), serviceDiscovery());

        Saga.Result goodOrder = sagaOrchestrator.execute("good_order");
        Saga.Result badOrder = sagaOrchestrator.execute("bad_order");
        Saga.Result crashedOrder = sagaOrchestrator.execute("crashed_order");

        log.info("orders: goodOrder is {}, badOrder is {},crashedOrder is {}",
                goodOrder, badOrder, crashedOrder);
    }


    private static Saga newSaga() {
        return Saga
                .create()
                .chapter("init an order")
                .chapter("booking a Fly")
                .chapter("booking a Hotel")
                .chapter("withdrawing Money");
    }

    private static ServiceDiscoveryService serviceDiscovery() {
        return new ServiceDiscoveryService()
                .discover(new OrderService())
                .discover(new FlyBookingService())
                .discover(new HotelBookingService())
                .discover(new WithdrawMoneyService());
    }
}
