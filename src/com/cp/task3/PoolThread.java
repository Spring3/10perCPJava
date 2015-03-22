package com.cp.task3;

import java.util.concurrent.BlockingQueue;

/**
 * Created by user on 20.03.2015.
 */
public class PoolThread extends Thread {

    private BlockingQueue taskQueue = null;
    private boolean isStopped = false;

    public PoolThread(BlockingQueue queue){
        taskQueue = queue;
    }

    public void run(){
        Runnable runnable = null;
        while(!isStopped){
            try {
                if (runnable == null) {
                    runnable = (Runnable) taskQueue.take();
                    runnable.run();
                    runnable = null;
                }

            }
            catch (InterruptedException ex){

            }
        }
    }

    public synchronized void doStop(){
        isStopped = true;
        this.interrupt();
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}
