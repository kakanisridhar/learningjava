package com.mridasoft.learning.concurrency.Executors;

import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ResourceRealeasingScheduledFuture<V> implements RunnableScheduledFuture<V> {
	 
    private ResourceReleasingTask myRunnable;
    private RunnableScheduledFuture<V> futureTask;
 
    public ResourceRealeasingScheduledFuture(ResourceReleasingTask myRunnable,
    									RunnableScheduledFuture<V> futureTask) {
        this.myRunnable= myRunnable;
        this.futureTask= futureTask;
    }
 
    @Override
    public void run() {
        this.futureTask.run();
    }

    @Override
    public boolean cancel(final boolean pMayInterruptIfRunning) {
        // Cancel the thread as usual
        boolean isCanceled = this.futureTask.cancel(pMayInterruptIfRunning);
 
        //Release resources
        if(pMayInterruptIfRunning){
            myRunnable.releaseResources();
        }
         
        return isCanceled;
    }


	@Override
	public boolean isCancelled() {

		return futureTask.isCancelled();
	}

	@Override
	public boolean isDone() {

		return futureTask.isDone();
	}

	@Override
	public V get() throws InterruptedException, ExecutionException {

		return futureTask.get();
	}

	@Override
	public V get(long timeout, TimeUnit unit) throws InterruptedException,
			ExecutionException, TimeoutException {

		return futureTask.get(timeout, unit);
	}

	@Override
	public long getDelay(TimeUnit unit) {

		return futureTask.getDelay(unit);
	}

	@Override
	public int compareTo(Delayed o) {

		return futureTask.compareTo(o);
	}

	@Override
	public boolean isPeriodic() {

		return futureTask.isPeriodic();
	}
 
 
    
}