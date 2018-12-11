package com.analise;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayHelper {
    static final String COMPLEXITY_BEST = "1";
    static final String COMPLEXITY_WORSE = "2";
    static final String COMPLEXITY_MEDIUM = "3";

    private final Integer length;
    private final String complexity;

    public ArrayHelper(Integer length, String complexity) {
        this.length = length;
        this.complexity = complexity;
    }

    public int[] generateArray() {
        switch (complexity) {
            case COMPLEXITY_BEST:
                return createAscSortedArray(length);
            case COMPLEXITY_WORSE:
                return createDescSortedArray(length);
            case COMPLEXITY_MEDIUM:
                return createUnsortedArray(length);
        }

        return null;
    }

    private int[] createAscSortedArray(int length) {
        int[] array = new int[length];

        for(int i = 0; i < length; i++) {
            array[i] = i;
        }

        return array;
    }

    private int[] createDescSortedArray(int length) {
        int[] array = new int[length];

        for(int i = 0, j = length - 1; i < length; i++, j--) {
            array[i] = j;
        }

        return array;
    }

    private int[] createUnsortedArray(int length) {
        int[] array = new int[length];

        for(int i = 0; i < length; i++) {
            array[i] = i;
        }

        shuffleArray(array);

        return array;
    }

    //Implementing Fisher–Yates shuffle
    private static void shuffleArray(int[] array) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }
}
