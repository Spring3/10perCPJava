package com.cp.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by user on 20.03.2015.
 */
public class ParallelCounter {
    public ParallelCounter(){

    }

    private ExecutorService executorService;

    public double count(int n, int maxThreads) {
        Set<Callable<Double>> callables = new HashSet<>();
        float result = 0;

        executorService = Executors.newFixedThreadPool(maxThreads);

        for (int i = 0; i < n; i++) {
            final int index = i;
            callables.add(() -> {
                        return Math.pow(2, index - Math.pow(-1, index));
                    }
            );
        }
        try {
            List<Future<Double>> futures = executorService.invokeAll(callables);
            for (Future<Double> future : futures) {
                try {
                    result += future.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        executorService.shutdown();
        return result;
    }

    public double count(InputStream sourceFileStream){
        double result = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(sourceFileStream));
        String str;
        try {
            while ((str = reader.readLine()) != null) {
                int n = Integer.valueOf(str.substring(0, str.indexOf(" ")).trim());
                int maxThreads = Integer.valueOf(str.substring(str.indexOf(" ") +1, str.length()));
                result = count(n, maxThreads);
                System.out.println("TASK 3 RESULT FROM FILE: " + result);
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return result;
    }

    private volatile AtomicLong result = new AtomicLong(0);

    private synchronized double getResult(){
        return Double.longBitsToDouble(result.get());
    }

    private synchronized void setResult(double value){
        result.set(Double.doubleToLongBits(value));
    }

    public double countThreadPool(int n, int maxThreads) {
        ThreadPool pool = new ThreadPool(maxThreads, n);
        for (int i = 0 ; i < n; i ++){
            final int index = i;
            try {
                pool.execute(() ->
                    setResult(getResult() + Math.pow(2, index - Math.pow(-1, index)))
                );
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.stop();
        double res = getResult();

        setResult(0);
        return res;
    }
}
