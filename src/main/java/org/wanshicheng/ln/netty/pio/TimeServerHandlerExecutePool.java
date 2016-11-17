package org.wanshicheng.ln.netty.pio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2014年2月15日
 * @version 1.0
 */
public class TimeServerHandlerExecutePool {

    private ExecutorService executor;

    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
	executor = new ThreadPoolExecutor(Runtime.getRuntime()
		.availableProcessors(), maxPoolSize, 120L, TimeUnit.SECONDS,
		new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable task) {
	executor.execute(task);
    }
}
