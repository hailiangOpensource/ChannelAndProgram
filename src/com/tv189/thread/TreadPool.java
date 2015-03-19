package com.tv189.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 
 * <p>Title: TreadPool.java</p>
 * <p>Copyright: Copyright (c) 2014</p>
 * <p>Company: Tv189 </p>
 * @author gaohailiang
 * @date 2015年3月19日
 * @version 1.0
 */

public class TreadPool extends ThreadPoolExecutor{
	private static final int CORE_POOL_SIZE = 10;
	private static final int MAX_NUM_POOL_SIZE = 100;
	private static final int KEEP_ALIVE_TIME = 1;
    private static TreadPool threadPool;
   /* ThreadPoolExecutor的完整构造方法的签名是：ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, 
    BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) .

    corePoolSize - 池中所保存的线程数，包括空闲线程。

    maximumPoolSize-池中允许的最大线程数。

    keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。

    unit - keepAliveTime 参数的时间单位。

    workQueue - 执行前用于保持任务的队列。此队列仅保持由 execute方法提交的 Runnable任务。

    threadFactory - 执行程序创建新线程时使用的工厂。

    handler - 由于超出线程范围和队列容量而使执行被阻塞时所使用的处理程序。*/
    private TreadPool(){
        super(CORE_POOL_SIZE,MAX_NUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    }
 
    public synchronized static TreadPool getInstance() {
        if (threadPool == null) {
            threadPool = new TreadPool();
        }
        return threadPool;
    }
 
}