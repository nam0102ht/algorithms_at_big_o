package com.ntnn.saga.orchestration.service;

import com.ntnn.saga.orchestration.core.ChapterResult;
import com.ntnn.saga.orchestration.core.OrchestrationChapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Service<K> implements OrchestrationChapter<K> {

    @Override
    public abstract String getName();


    @Override
    public ChapterResult<K> process(K value) {
        System.out.println("The chapter '" + getName() +" ' has been started. "
                        + "The data " + value +" has been stored or calculated successfully");
        return ChapterResult.success(value);
    }

    @Override
    public ChapterResult<K> rollback(K value) {
        System.out.println("The Rollback for a chapter '"+ getName() +"' has been started. "
                        + "The data "+ value +" has been rollbacked successfully");
        return ChapterResult.success(value);
    }


}