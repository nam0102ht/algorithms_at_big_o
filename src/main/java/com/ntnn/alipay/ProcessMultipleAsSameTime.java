package com.ntnn.alipay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class ProcessMultipleAsSameTime {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier phaser = new CyclicBarrier(1000);
        List<Thread> lst = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            final int index = i;
            Runnable runnable = () -> {
                System.out.println("Start: " + index);
                try {
                    phaser.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("End: " + index);
            };
            lst.add(new Thread(runnable));
        }

        lst.forEach(Thread::start);
    }
}
