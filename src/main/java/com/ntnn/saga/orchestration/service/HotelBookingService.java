package com.ntnn.saga.orchestration.service;

import com.ntnn.saga.orchestration.core.ChapterResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HotelBookingService extends Service<String> {
    @Override
    public String getName() {
        return "booking a Hotel";
    }


    @Override
    public ChapterResult<String> rollback(String value) {
        if (value.equals("crashed_order")) {
            System.out.println("The Rollback for a chapter '" + getName() +"' has been started. "
                            + "The data "+ value +" has been failed.The saga has been crashed.");

            return ChapterResult.failure(value);
        }

        System.out.println("The Rollback for a chapter '{" + getName() + "}' has been started. "
                        + "The data "+ value +" has been rollback successfully");

        return super.rollback(value);
    }
}