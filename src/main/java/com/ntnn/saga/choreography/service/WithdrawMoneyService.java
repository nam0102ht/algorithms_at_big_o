package com.ntnn.saga.choreography.service;

import com.ntnn.saga.choreography.core.Saga;
import com.ntnn.saga.choreography.core.ServiceDiscoveryService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WithdrawMoneyService extends Service {
    public WithdrawMoneyService(ServiceDiscoveryService service) {
        super(service);
    }

    @Override
    public String getName() {
        return "withdrawing Money";
    }

    @Override
    public Saga process(Saga saga) {
        var inValue = saga.getCurrentValue();

        if (inValue.equals("bad_order")) {
            log.info("The chapter '{}' has been started. But the exception has been raised."
                            + "The rollback is about to start",
                    getName());
            saga.setCurrentStatus(Saga.ChapterResult.ROLLBACK);
            return saga;
        }
        return super.process(saga);
    }
}
