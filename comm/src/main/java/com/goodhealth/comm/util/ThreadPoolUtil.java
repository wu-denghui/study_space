package com.goodhealth.comm.util;

import java.util.List;
import java.util.concurrent.*;

public final class ThreadPoolUtil {

    private static final ThreadPoolExecutor DEFAULT_EXECUTER =
            new ThreadPoolExecutor(1, Runtime.getRuntime().availableProcessors(),
            60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(200));

    /**
     * @param command :
     * @Description: execute
     * @return: void
     */
    public static void execute(Runnable command) {
        execute(command, 0L, TimeUnit.MILLISECONDS);
    }

    /**
     * 添加多个线程
     * @param commands
     */
    public void execute(List<Runnable> commands){
        for (Runnable runnable : commands) {
            execute(runnable);
        }
    }
    
    /**
     *
     * @param command :
     * @param timeout :
     * @param unit :
     * @return: void
     */
    public static void execute(Runnable command, long timeout, TimeUnit unit) {

        try {
            DEFAULT_EXECUTER.execute(command);
        } catch (RejectedExecutionException e) {
            if (!(DEFAULT_EXECUTER.getQueue() instanceof BlockingQueue)) {
                throw e;
            }
            BlockingQueue queue = (BlockingQueue) DEFAULT_EXECUTER.getQueue();

            try {
                if (!queue.offer(command, timeout, unit)) {
                    throw new RejectedExecutionException("Queue capacity is full.");
                }
            } catch (InterruptedException interruptedException) {
                throw new RejectedExecutionException(interruptedException);
            }
        }
    }

}
