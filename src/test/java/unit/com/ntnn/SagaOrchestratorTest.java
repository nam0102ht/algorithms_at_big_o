package unit.com.ntnn;

import com.ntnn.saga.orchestration.SagaOrchestrator;
import com.ntnn.saga.orchestration.core.Saga;
import com.ntnn.saga.orchestration.core.ServiceDiscoveryService;
import com.ntnn.saga.orchestration.service.FlyBookingService;
import com.ntnn.saga.orchestration.service.HotelBookingService;
import com.ntnn.saga.orchestration.service.OrderService;
import com.ntnn.saga.orchestration.service.WithdrawMoneyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SagaOrchestratorTest {
    @Test
    void execute() {
        SagaOrchestrator sagaOrchestrator = new SagaOrchestrator(newSaga(), serviceDiscovery());
        Saga.Result badOrder = sagaOrchestrator.execute("bad_order");
        Saga.Result crashedOrder = sagaOrchestrator.execute("crashed_order");

        Assertions.assertEquals(Saga.Result.ROLLBACK, badOrder);
        Assertions.assertEquals(Saga.Result.CRASHED, crashedOrder);
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
        return
                new ServiceDiscoveryService()
                        .discover(new OrderService())
                        .discover(new FlyBookingService())
                        .discover(new HotelBookingService())
                        .discover(new WithdrawMoneyService());
    }
}
