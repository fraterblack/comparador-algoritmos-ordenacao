package com.analise.Algoritms;

import java.util.Arrays;

public class RadixSort extends AbstractSort {
    public int getMax(int array[], int arraySize) {
        int max = array[0];
        for (int i = 1; i < arraySize; i++) {
            comparisons++;
            if (array[i] > max) {
                changes++;
                max = array[i];
            }
        }
        return max;
    }

    private void countSort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            changes++;
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public int[] sort(int[] array) {
        int arraySize = array.length;

        //Reseta controles
        comparisons = 0;
        changes = 0;

        //Start time
        timer().startTime();

        int m = getMax(array, arraySize);

        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(array, arraySize, exp);
        }

        //Finish time
        timer().finishTime();

        return array;
    }
}