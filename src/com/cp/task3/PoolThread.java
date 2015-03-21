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
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) taskQueue.take();
                runnable.run();
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
