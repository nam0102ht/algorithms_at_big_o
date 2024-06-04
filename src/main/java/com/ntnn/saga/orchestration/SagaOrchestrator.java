package com.ntnn.saga.orchestration;

import com.ntnn.saga.orchestration.core.Saga;
import com.ntnn.saga.orchestration.core.ServiceDiscoveryService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SagaOrchestrator {
    private final Saga saga;
    private final ServiceDiscoveryService sd;
    private final CurrentState state;


    public SagaOrchestrator(Saga saga, ServiceDiscoveryService sd) {
        this.saga = saga;
        this.sd = sd;
        this.state = new CurrentState();
    }

    public <K> Saga.Result execute(K value) {
        state.cleanUp();
        System.out.println(" The new saga is about to start");
        var result = Saga.Result.FINISHED;
        K tempVal = value;

        while (true) {
            var next = state.current();
            var ch = saga.get(next);
            var srvOpt = sd.find(ch.getName());

            if (srvOpt.isEmpty()) {
                state.directionToBack();
                state.back();
                continue;
            }

            var srv = srvOpt.get();

            if (state.isForward()) {
                var processRes = srv.process(tempVal);
                if (processRes.isSuccess()) {
                    next = state.forward();
                    tempVal = (K) processRes.getValue();
                } else {
                    state.directionToBack();
                }
            } else {
                var rlRes = srv.rollback(tempVal);
                if (rlRes.isSuccess()) {
                    next = state.back();
                    tempVal = (K) rlRes.getValue();
                } else {
                    result = Saga.Result.CRASHED;
                    next = state.back();
                }
            }


            if (!saga.isPresent(next)) {
                return state.isForward() ? Saga.Result.FINISHED : result == Saga.Result.CRASHED ? Saga.Result.CRASHED : Saga.Result.ROLLBACK;
            }
        }

    }


    private static class CurrentState {
        int currentNumber;
        boolean isForward;

        void cleanUp() {
            currentNumber = 0;
            isForward = true;
        }

        CurrentState() {
            this.currentNumber = 0;
            this.isForward = true;
        }


        boolean isForward() {
            return isForward;
        }

        void directionToBack() {
            isForward = false;
        }

        int forward() {
            return ++currentNumber;
        }

        int back() {
            return --currentNumber;
        }

        int current() {
            return currentNumber;
        }
    }

}