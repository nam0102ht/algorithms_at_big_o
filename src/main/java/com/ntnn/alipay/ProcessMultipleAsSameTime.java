package com.ntnn.alipay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.stream.IntStream;

public class ProcessMultipleAsSameTime {
    static class AsSameTimeThread extends Thread {
        private Phaser phaser;

        public AsSameTimeThread(String name, Phaser phaser) {
            this.phaser = phaser;
            phaser.register();
            this.setName(name);
        }

        @Override
        public void run() {
            System.out.println("Start " + getName());
            phaser.arriveAndAwaitAdvance();
            System.out.println("Ready " + getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser();
        phaser.register();
        List<AsSameTimeThread> lst = new ArrayList<>();
        IntStream.range(1, 1000).parallel().forEach(v -> {
            lst.add(new AsSameTimeThread(String.valueOf(v), phaser));
        });

        lst.parallelStream().forEach(Thread::start);
        Thread.sleep(100);
        phaser.arriveAndAwaitAdvance();
    }
}
