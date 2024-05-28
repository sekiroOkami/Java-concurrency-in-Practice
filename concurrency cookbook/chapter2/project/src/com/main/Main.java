package com.main;

import com.parking.ParkingCash;
import com.parking.ParkingStats;
import com.parking.Sensor;

public class Main {
    public static void main(String[] args) {
        ParkingCash cash = new ParkingCash();
        ParkingStats service = new ParkingStats(cash);
        System.out.println("Parking Simulator");
        int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[numberSensors];

        for (int i=0; i<numberSensors; i++) {
            Sensor sensor = new Sensor(service);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[i] = thread;
        }

        for (int i=0; i<numberSensors; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Number of cars: %d\n", service.getNumberCars());
        System.out.printf("Number of motorcycles: %d\n", service.getNumberMotorcycles());
        cash.close();
    }
}
