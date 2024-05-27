package com.example.data;

public class Distance implements Comparable<Distance>{

    /**
     * Index of the train instance
     */
    private int index;

    /**
     * Distance between the train instance and the example
     */
    private double distance;


    @Override
    public int compareTo(Distance other) {
        if (this.distance < other.getDistance()) {
            return -1;
        } else if (this.distance > other.getDistance()) {
            return 1;
        }
        return 0;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
