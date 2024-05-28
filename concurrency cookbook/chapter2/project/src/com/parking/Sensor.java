package com.parking;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Sensor implements Runnable {
    private ParkingStats stats;

    public Sensor(ParkingStats stats) {
        this.stats = stats;
    }

    // simulate that two cars and a motorcycle arrive in and the leave
    // the parking area. Every sensor will perform this action 10 times.
    @Override
    public void run()  {
        IntStream.range(0, 10)
                .forEach(i-> {
                    stats.carComeIn();
                    stats.carComeIn();
                    try {
                        TimeUnit.MICROSECONDS.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    stats.motoComeIn();
                    try {
                        TimeUnit.MICROSECONDS.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    stats.motoGoOut();
                    stats.carGoOut();
                    stats.carGoOut();
                });
    }
}
