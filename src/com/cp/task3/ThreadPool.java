package com.cp.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by user on 20.03.2015.
 */
public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThread> threads = new ArrayList<>();
    private boolean isStopped = false;

    public ThreadPool(int maxThreads, int maxTasks) {
        taskQueue = new LinkedBlockingQueue(maxTasks);
        for (int i = 0; i < maxThreads; i++) {
            threads.add(new PoolThread(taskQueue));
        }
        for (PoolThread thread : threads) {
            thread.start();
        }
    }

    public synchronized void execute(Runnable task) throws Exception{
        if (this.isStopped){
            throw new IllegalStateException("Thread pool is stopped");
        }
        this.taskQueue.put(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThread thread : threads){
            while(thread.isAlive())
                thread.doStop();
        }
    }
}
