package com.goodhealth.design.advanced.ThreadPoolStyle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName AsynThreadPool
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/21 19:20
 * @Version 1.0
 **/
@Component
public class AsynThreadPool {

    private ExecutorService fixedThreadPool;

    @PostConstruct
    public void start(){
        fixedThreadPool = new ThreadPoolExecutor(15, 25,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(),
            Executors.defaultThreadFactory());
    }

    /**
     * 添加线程
     * @param command
     */
    public void execute(Runnable command){
        fixedThreadPool.execute(command);
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
}
