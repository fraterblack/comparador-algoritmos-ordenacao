package com.analise.Algoritms;

public class QuickSort extends AbstractSort {
    public int[] sort(int[] array) {
        int arraySize = array.length;

        //Reseta controles
        comparisons = 0;
        changes = 0;

        //Start time
        timer().startTime();

        sort(array, 0, arraySize - 1);

        //Finish time
        timer().finishTime();

        return array;
    }

    private void sort(int array[], int startIndex, int finishIndex) {
        if (startIndex < finishIndex) {
            int pivotPosition = separar(array, startIndex, finishIndex);
            sort(array, startIndex, pivotPosition - 1);
            sort(array, pivotPosition + 1, finishIndex);
        }
    }

    private int separar(int[] array, int startIndex, int finishIndex) {
        int pivot = array[startIndex];
        int i = startIndex + 1, j = finishIndex;
        while (i <= j) {
            comparisons++;
            if (array[i] <= pivot) {
                i++;
                changes++;
            } else if (pivot < array[j]) {
                j--;
                //changes++;
            } else {
                changes++;
                int troca = array[i];
                array[i] = array[j];
                array[j] = troca;
                i++;
                j--;
            }
        }
        array[startIndex] = array[j];
        array[j] = pivot;
        return j;
    }
}
