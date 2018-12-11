package com.analise.Algoritms;

import com.analise.ExecutionTimer;

public abstract class AbstractSort {
    protected ExecutionTimer timer = new ExecutionTimer();
    protected static int comparisons = 0;
    protected static int changes = 0;

    public ExecutionTimer timer() {
        return timer;
    }

    public int getComparison() {
        return comparisons;
    }

    public int getChanges() {
        return changes;
    }

    public long getTime() {
        return timer.elapsedTime();
    }

    public abstract int[] sort(int[] array);
}