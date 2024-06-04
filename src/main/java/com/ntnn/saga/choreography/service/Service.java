package com.ntnn.saga.choreography.service;

import com.ntnn.saga.choreography.core.ChoreographyChapter;
import com.ntnn.saga.choreography.core.Saga;
import com.ntnn.saga.choreography.core.ServiceDiscoveryService;
import lombok.extern.log4j.Log4j2;

import java.util.function.Supplier;

@Log4j2
public abstract class Service implements ChoreographyChapter {

    private final ServiceDiscoveryService sd;

    public Service(ServiceDiscoveryService service) {
        this.sd = service;
    }

    @Override
    public Saga execute(Saga saga) {
        var nextSaga = saga;
        Object nextVal;
        var chapterName = saga.getCurrent().getName();
        if (chapterName.equals(getName())) {
            if (saga.isForward()) {
                nextSaga = process(saga);
                nextVal = nextSaga.getCurrentValue();
                if (nextSaga.isCurrentSuccess()) {
                    nextSaga.forward();
                } else {
                    nextSaga.back();
                }
            } else {
                nextSaga = rollback(saga);
                nextVal = nextSaga.getCurrentValue();
                nextSaga.back();
            }

            if (isSagaFinished(nextSaga)) {
                return nextSaga;
            }

            nextSaga.setCurrentValue(nextVal);
        }
        var finalNextSaga = nextSaga;

        return sd.find(chapterName).map(ch -> ch.execute(finalNextSaga))
                .orElseThrow(serviceNotFoundException(chapterName));
    }

    private Supplier<RuntimeException> serviceNotFoundException(String chServiceName) {
        return () -> new RuntimeException(
                String.format("the service %s has not been found", chServiceName));
    }

    @Override
    public Saga process(Saga saga) {
        var inValue = saga.getCurrentValue();
        log.info("The chapter '{}' has been started. "
                        + "The data {} has been stored or calculated successfully",
                getName(), inValue);
        saga.setCurrentStatus(Saga.ChapterResult.SUCCESS);
        saga.setCurrentValue(inValue);
        return saga;
    }

    @Override
    public Saga rollback(Saga saga) {
        var inValue = saga.getCurrentValue();
        log.info("The Rollback for a chapter '{}' has been started. "
                        + "The data {} has been rollbacked successfully",
                getName(), inValue);

        saga.setCurrentStatus(Saga.ChapterResult.ROLLBACK);
        saga.setCurrentValue(inValue);
        return saga;
    }

    private boolean isSagaFinished(Saga saga) {
        if (!saga.isPresent()) {
            saga.setFinished(true);
            log.info(" the saga has been finished with {} status", saga.getResult());
            return true;
        }
        return false;
    }
}
