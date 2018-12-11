package com.analise.Algoritms;

public class InsertionSort extends AbstractSort {
    public int[] sort(int[] array) {
        int arraySize = array.length;

        //Reseta controles
        comparisons = 0;
        changes = 0;

        //Start time
        timer().startTime();

        //Algorithm Insertion Sort
        for (int i = 1; i < arraySize; i++) {
            int aux = array[i];
            int j = i;

            comparisons++;
            comparisons++;
            while ((j > 0) && (array[j - 1] > aux)) {
                changes++;
                array[j] = array[j - 1];
                j--;
            }

            array[j] = aux;
        }

        //Finish time
        timer().finishTime();

        return array;
    }
}
