package com.analise;

public final class ExecutionTimer {
    private long startTime = 0;
    private long finishTime = 0;

    public void startTime() {
        this.startTime = System.currentTimeMillis();
    }

    public void finishTime() {
        this.finishTime = System.currentTimeMillis();
    }

    public long elapsedTime() {
        return (finishTime - startTime);
    }

    public void printElapsedTime() {
        System.out.println("Tempo de execução: " + elapsedTime() + "ms");
    }
}
