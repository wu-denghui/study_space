package com.goodhealth.design.demo.StatePattern;

/**
 * @author WDH
 * @description
 * @date 2019-10-08 19:51
 */
public interface State {

    void  run();
    void  stop();
    void  open();
    void  close();
}
