package com.parking;

// store the total amount of money earned by providing this parking service
public class ParkingCash {
    private static final int cost = 2;
    private long cash;

    public ParkingCash() {
        this.cash = 0;
    }

    // called when a vehicle leaves the parking area
    public void vehiclePay() {
        cash += cost;
    }

    // write the value of the cash attribute in the console and reinitialize it to zero
    public void close() {
        System.out.println("Closing accounting");
        long totalAmount;
        totalAmount = cash;
        cash = 0;
        System.out.println("The total amount is: " + totalAmount);
    }
}
