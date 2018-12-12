package com.analise.Algoritms;

public class HeapSort extends AbstractSort {
    public int[] sort(int[] array) {
        int arraySize = array.length;

        //Reseta controles
        comparisons = 0;
        changes = 0;

        //Start time
        timer().startTime();

        for (int i = arraySize / 2 - 1; i >= 0; i--)
            heapify(array, arraySize, i);

        for (int i = arraySize - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }

        //Finish time
        timer().finishTime();

        return array;
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        comparisons++;
        if (largest != i) {
            changes++;
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}