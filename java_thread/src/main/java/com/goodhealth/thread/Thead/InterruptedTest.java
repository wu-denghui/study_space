/**
 * 
 */
package com.goodhealth.thread.Thead;

import java.util.concurrent.TimeUnit;

/**
 * @author 24663
 * @date 2018年12月13日
 * @Description
 */

public class InterruptedTest {
    public static void main(String[] args) {
        NThread nThread = new NThread();
        System.out.println("interrupt执行前"+System.currentTimeMillis());
        nThread.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nThread.interrupt();
        System.out.println("interrupt执行后"+System.currentTimeMillis());
    }

    /**
     * 测试多线程的中断机制
     */
    static class NThread extends Thread{

        @Override
        public void run() {
        	while (!isInterrupted()) {
                try{
                    System.out.println("依然存活...");
                    Thread.sleep(500);//阻塞过程捕获中断异常来退出
                }catch(InterruptedException e){
                    e.printStackTrace();
                    break;//捕获到异常之后，执行 break 跳出循环
                }
            }
        }
    }
}
