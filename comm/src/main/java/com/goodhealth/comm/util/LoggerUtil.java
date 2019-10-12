package com.goodhealth.comm.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Description
 * @Author WDH
 * @Date 2019/9/12 15:59
 **/
public class LoggerUtil {

/*    public static void main(String[] args){
        System.out.println(LoggerUtil.class.getName()); // util.LoggerUtil
    }*/

    /**
     * util.LoggerUtil
     */
    private static final String fqcn = LoggerUtil.class.getName();
    /**
     * NOT_AVAIL
     */
    private static final String NOT_AVAIL = "?";

    /**
     * 获取最原始被调用的堆栈信息
     * @param stackTrace
     * @return
     */
    private static StackTraceElement getStackTraceElement(
            final StackTraceElement[] stackTrace) {
        boolean next = false;
        for (final StackTraceElement element : stackTrace) {
            final String className = element.getClassName();
            if (next && !fqcn.equals(className)) {
                return element;
            }
            if (fqcn.equals(className)) {
                next = true;
            } else if (NOT_AVAIL.equals(className)) {
            // 堆栈跟踪元素数组到头
                break;
            }
        }
        return null;
    }

    /**
     * @param message
     */
    public static void info(final String message) {
        /**  Thread.currentThread().getStackTrace（）返回一个表示该线程堆栈转储的堆栈跟踪元素数组。
         * 如果该线程尚未启动或已经终止，则该方法将返回一个零长度数组。
         * 如果返回的数组不是零长度的，则其第一个元素代表堆栈顶，它是该序列中最新的方法调用。
         * 最后一个元素代表堆栈底，是该序列中最旧的方法调用。
         * */
        StackTraceElement caller = getStackTraceElement(Thread.currentThread().getStackTrace());
        if (null == caller){
            return;
        }
        Logger log = LogManager.getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.info(message);
    }

    /**
     * @param message
     * @param t
     */
    public static void info(final String message, Throwable t) {
        StackTraceElement caller = getStackTraceElement(Thread.currentThread()
                .getStackTrace());
        if (null == caller){
            return;
        }
        Logger log = LogManager
                .getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.info(message, t);
    }

    /**
     * @param message
     */
    public static void debug(final String message) {
        StackTraceElement caller = getStackTraceElement(Thread.currentThread()
                .getStackTrace());
        if (null == caller){
            return;
        }
        Logger log = LogManager
                .getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.debug(message);
    }

    /**
     * @param message
     * @param t
     */
    public static void debug(final String message, Throwable t) {
        StackTraceElement caller = getStackTraceElement(Thread.currentThread()
                .getStackTrace());
        if (null == caller){
            return;
        }
        Logger log = LogManager
                .getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.debug(message, t);
    }

    /**
     * @param message
     */
    public static void error(final String message) {
        StackTraceElement caller = getStackTraceElement(Thread.currentThread()
                .getStackTrace());
        if (null == caller){
            return;
        }
        Logger log = LogManager
                .getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.error(message);
    }

    /**
     * @param message
     * @param t
     */
    public static void error(final String message, Throwable t) {
        StackTraceElement caller = getStackTraceElement(Thread.currentThread()
                .getStackTrace());
        if (null == caller){
            return;
        }
        Logger log = LogManager
                .getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.error(message, t);
    }

    /**
     * @param message
     */
    public static void warn(final String message) {
        StackTraceElement caller = getStackTraceElement(Thread.currentThread()
                .getStackTrace());
        if (null == caller){
            return;
        }
        Logger log = LogManager.getLogger(caller.getClassName() + "." + caller.getMethodName()
                        + "() Line: " + caller.getLineNumber());
        log.warn(message);
    }
}
