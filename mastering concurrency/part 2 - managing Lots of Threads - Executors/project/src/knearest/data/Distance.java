package knearest.data;

public class Distance implements Comparable<Distance> {

    /**
     * Index of the train instance
     */
    private int index;
    /**
     * Distance between the train instance and the example
     */
    private double distance;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    private double getDistance() {
        return distance;
    }
    @Override
    public int compareTo(Distance other) {
        if (this.distance < other.getDistance()) {
            return -1;
        } else if (this.distance > other.getDistance()){
            return 1;
        }
        return 0;
    }


}
