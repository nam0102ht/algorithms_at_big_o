package com.ntnn.saga.orchestration.service;

import com.ntnn.saga.orchestration.core.ChapterResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WithdrawMoneyService extends Service<String> {
    @Override
    public String getName() {
        return "withdrawing Money";
    }

    @Override
    public ChapterResult<String> process(String value) {
        if (value.equals("bad_order") || value.equals("crashed_order")) {
            System.out.println("The chapter '"+getName() +"' has been started. But the exception has been raised."
                            + "The rollback is about to start");
            return ChapterResult.failure(value);
        }
        return super.process(value);
    }
}