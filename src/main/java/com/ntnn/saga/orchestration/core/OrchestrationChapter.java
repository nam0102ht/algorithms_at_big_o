package com.ntnn.saga.orchestration.core;

public interface OrchestrationChapter<K> {

    String getName();

    ChapterResult<K> process(K value);

    ChapterResult<K> rollback(K value);

}
