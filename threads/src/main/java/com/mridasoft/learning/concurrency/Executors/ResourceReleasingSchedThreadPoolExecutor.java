package com.mridasoft.learning.concurrency.Executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ResourceReleasingSchedThreadPoolExecutor extends ScheduledThreadPoolExecutor {
	 
    private List<RunnableScheduledFuture<?>> myTasks = new ArrayList<RunnableScheduledFuture<?>>();
 
    public ResourceReleasingSchedThreadPoolExecutor(int poolSize) {
        super(poolSize);
    }
 
    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> futureTask) {
        RunnableScheduledFuture<V> myFutureTask;
        try {
            // Trying to decorate the ResourceReleasingTask with the decorator
            myFutureTask = new ResourceRealeasingScheduledFuture<V>((ResourceReleasingTask) runnable, futureTask);
            //Adding the scheduled task
            myTasks.add(myFutureTask);
        } catch (ClassCastException e) {
            // If the runnable is not an instance of ResourceReleasingTask use the default decorator
            myFutureTask = super.decorateTask(runnable, futureTask);
        }
        return myFutureTask;
    }
 
    @Override
    public List<Runnable> shutdownNow() {
        if (myTasks!= null) {
            // Cancels and interrupts all the jobs from the watch list
            for (RunnableScheduledFuture<?> job : myTasks) {
                job.cancel(true);
            }
            myTasks= null;
        }
        // Shutdown the scheduler
        return super.shutdownNow();
    }
    
    public long getSize() {
    	return myTasks.size();
    }
 
}