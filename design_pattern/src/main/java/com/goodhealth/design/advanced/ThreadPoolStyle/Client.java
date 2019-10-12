package com.goodhealth.design.advanced.ThreadPoolStyle;

import com.goodhealth.design.advanced.ThreadPoolStyle.Task.CreatWayBillNumberTask;
import com.goodhealth.design.advanced.ThreadPoolStyle.Task.CreateBillNumberTask;
import com.goodhealth.design.advanced.ThreadPoolStyle.Task.PrintOrderTask;
import com.goodhealth.design.advanced.ThreadPoolStyle.Task.SendMessageTask;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Client
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/21 19:22
 * @Version 1.0
 **/
public class Client {

//    @Autowire
    private AsynThreadPool threadPool;

    public static void main(String[] args){
        List<Runnable> runnableList = new ArrayList<Runnable>();
        runnableList.add(new CreateBillNumberTask());
        runnableList.add(new CreatWayBillNumberTask());
        runnableList.add(new SendMessageTask());
        runnableList.add(new PrintOrderTask());
        new Client().threadPool.execute(runnableList);
    }
}
