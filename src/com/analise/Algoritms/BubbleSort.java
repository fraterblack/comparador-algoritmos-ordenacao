package com.analise.Algoritms;

public class BubbleSort extends AbstractSort {
    public int[] sort(int[] array) {
        int arraySize = array.length;

        //Start time
        timer().startTime();

        //Algorithm Bubble Sort
        for (int i = 0; i < arraySize - 1; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                comparisons++;
                if (array[j] < array[i]) {
                    changes++;
                    changes++;
                    int aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                }
            }
        }

        //Finish timer
        timer().finishTime();

        return array;
    }
}
