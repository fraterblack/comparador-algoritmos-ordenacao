package com.analise.Algoritms;

public class CountingSort extends AbstractSort {
    public int[] sort(int[] array) {
        int arraySize = array.length;

        //Reseta controles
        comparisons = 0;
        changes = 0;

        //Start time
        timer().startTime();

        int major = array[0];
        for (int i = 1; i < arraySize; i++) {
            comparisons++;
            if (array[i] > major) {
                major = array[i];
            }
        }

        int[] cummulative = new int[major];
        for (int i = 0; i < arraySize; i++) {
            try {
                cummulative[array[i] - 1] += 1;
            } catch (Exception e) {
                break;
            }
        }

        for (int i = 1; i < major; i++) {
            changes++;
            cummulative[i] += cummulative[i - 1];
        }

        Integer[] b = new Integer[array.length];
        for (int i = 0; i < b.length; i++) {
            try {
                b[cummulative[array[i] - 1] - 1] = array[i];
                cummulative[array[i] - 1]--;
            } catch (Exception e) {
                break;
            }
        }

        for (int i = 0; i < b.length; i++) {
            try {
                array[i] = b[i];
            } catch (Exception e) {
                break;
            }
        }

        //Finish time
        timer().finishTime();

        return array;
    }
}