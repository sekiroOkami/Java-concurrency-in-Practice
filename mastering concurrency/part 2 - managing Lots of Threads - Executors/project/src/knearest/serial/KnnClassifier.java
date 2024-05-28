package knearest.serial;

import knearest.data.Distance;
import knearest.data.Sample;
import knearest.distances.EuclideanDistanceCalculator;

import java.util.*;

public class KnnClassifier {
    /**
     * List of train data
     */
    private final List<? extends Sample> dataSet;

    /**
     * K parameter
     */
    private int k;


    public KnnClassifier(List<? extends Sample> dataSet, int k) {
        this.dataSet = dataSet;
        this.k = k;
    }

    /**
     * Method that classifies an example
     * @param example Example to classify
     * @return The tag or class of the example
     * @throws Exception Exception if something goes wrong
     */
    public String classify(Sample example) {
        // calculate the distances between the input example and all the examples of train dataset
        int index = 0;
        Distance[] distances = new Distance[dataSet.size()];
        for (Sample localExample: dataSet) {
            distances[index] = new Distance();
            distances[index].setIndex(index);
            distances[index].setDistance(EuclideanDistanceCalculator.calculate(localExample, example));
            index++;
        }
        // then sort from lower to higher distance
        Arrays.sort(distances);

        // count the tag with most instances in the k-nearest example
        Map<String, Integer> results = new HashMap<>();
        for (int i = 0; i < k; i++) {
            Sample localExample = dataSet.get(distances[i].getIndex());
            String tag = localExample.getTag();
            results.merge(tag, 1,(a,b)-> a+b);
        }
        return Collections.max(results.entrySet(),Map.Entry.comparingByValue()).getKey();
    }

}
