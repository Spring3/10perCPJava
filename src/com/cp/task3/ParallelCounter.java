package com.cp.task3;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Created by user on 20.03.2015.
 */
public class ParallelCounter {
    public ParallelCounter(){

    }

    private ExecutorService executorService;
    private volatile double result;

    public synchronized void addResult(double resultPart){
        this.result = resultPart;
    }

    public double count(int n, int maxThreads) throws InterruptedException {
        Set<Callable<Double>> callables = new HashSet<>();
        double result = 0;

        executorService = Executors.newFixedThreadPool(maxThreads);

        for (int i = 0; i < n; i++) {
            final int index = i;
            callables.add(() -> {
                        return Math.pow(2, index - Math.pow(-1, index));
                    }
            );
        }
        List<Future<Double>> futures = executorService.invokeAll(callables);
        for (Future<Double> future : futures) {
            try {
                result += future.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public double count(InputStream sourceFileStream){
        return 0;
    }
}
