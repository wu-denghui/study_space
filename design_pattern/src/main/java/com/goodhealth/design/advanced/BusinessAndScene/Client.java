package com.goodhealth.design.advanced.BusinessAndScene;

import com.goodhealth.design.advanced.BusinessAndScene.ationChain.ActionChain;

/**
 * @ClassName Client
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/20 21:12
 * @Version 1.0
 **/
public class Client {

//    @Autowired
    private ActionChain actionChain;

    public static void main(String[] args){
         new Client().actionChain.exe("中午");
    }
}
