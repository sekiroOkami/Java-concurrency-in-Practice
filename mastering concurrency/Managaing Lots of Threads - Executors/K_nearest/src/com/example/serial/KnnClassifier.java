package com.example.serial;

import com.example.data.Distance;
import com.example.data.Sample;
import com.example.distances.EuclideanDistanceCalculator;

import java.util.*;

public class KnnClassifier {
    private final List<? extends Sample> dataSet;
    private int k;

    public KnnClassifier(List<? extends Sample> dataSet, int k) {
        this.dataSet = dataSet;
        this.k = k;
    }

    /**
     * receive a Sample object with the instance we want to classify, and it returns a string
     * with the tag assigned to that instance;
     * @param example
     * @return
     */
    public String classify(Sample example) {

        // calculate the distances between the input example and all the examples of the train dataset
        Distance[] distances = new Distance[dataSet.size()];
        int index = 0;
        for (Sample localExample: dataSet) {
            distances[index]=new Distance();
            distances[index].setIndex(index);
            distances[index].setDistance(EuclideanDistanceCalculator.calculate(localExample, example));
            index++;
        }

        // sort the examples from the lower to the higher distance
        Arrays.sort(distances);

        // count the tag with most instances in the k-nearest examples:
        Map<String, Integer> results = new HashMap<>();
        for (int i=0; i<k; i++) {
            Sample localExample = dataSet.get(distances[i].getIndex());
            String tag = localExample.getTag();
            results.merge(tag, 1, Integer::sum);
        }
        return Collections.max(results.entrySet(), Map.Entry.comparingByValue()).getKey();
    }


}
