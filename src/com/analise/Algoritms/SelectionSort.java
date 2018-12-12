package com.analise.Algoritms;

public class SelectionSort extends AbstractSort {
    public int[] sort(int[] array) {
        int arraySize = array.length;

        //Reseta controles
        comparisons = 0;
        changes = 0;

        int aux ;
        int j;
        int min;

        //Start time
        timer().startTime();

        for (int i = 0; i < arraySize - 1; i++){
            min = i;
            for (j = (i+1); j < arraySize; j++) {
                comparisons++;
                if(array[j] < array[min]) {
                    changes++;
                    min = j;
                }
            }

            if (array[i] != array[min]) {
                aux = array[i];
                array[i] = array[min];
                array[min] = aux;
            }
        }

        //Finish time
        timer().finishTime();

        return array;
    }
}