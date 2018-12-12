package com.analise.Algoritms;

public class CombSort extends AbstractSort {
    public int[] sort(int[] array) {
        int arraySize = array.length;

        //Reseta controles
        comparisons = 0;
        changes = 0;

        //Start time
        timer().startTime();

        //Auxiliares.
        int i;
        int j;
        int interval = arraySize;
        boolean changed = true;
        int aux;

        while (interval > 1 || changed) {
            interval = interval * 10 / 13;
            if (interval == 9 || interval == 10) interval = 11;
            if (interval < 1) interval = 1;
            changed = false;
            for (i = 0, j = interval; j < array.length; i++, j++) {
                comparisons++;
                if (array[i] > array[j]) {
                    changes++;

                    aux = array[i];
                    array[i] = array[j];
                    array[j] = aux;
                    changed = true;
                }
            }
        }

        //Finish time
        timer().finishTime();

        return array;
    }
}
