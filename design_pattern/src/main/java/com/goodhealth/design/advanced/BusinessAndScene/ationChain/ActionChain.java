package com.goodhealth.design.advanced.BusinessAndScene.ationChain;

import com.goodhealth.design.advanced.BusinessAndScene.ActionEnum;
import com.goodhealth.design.advanced.BusinessAndScene.ationChain.action.AbstractAction;
import com.goodhealth.design.advanced.BusinessAndScene.ationChain.action.AfternoonAction;
import com.goodhealth.design.advanced.BusinessAndScene.ationChain.action.MorningAction;
import com.goodhealth.design.advanced.BusinessAndScene.ationChain.action.NoodayAction;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedList;

/**
 * @ClassName ActionChain
 * @Description TODO
 * @Author WDH
 * @Date 2019/8/20 21:16
 * @Version 1.0
 **/
@Component
public class ActionChain {

    public void exe(String  actionName){
       WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        /** 获取所有链路 */
        LinkedList<Class<?>> orderChain = getActionChain();
        for (Class<?> clazz : orderChain) {
            AbstractAction absOrder = (AbstractAction) wac.getBean(clazz);
            /** 获得渠道 */
            ActionEnum eunm = absOrder.getActionEnum();
            /** 找到对应渠道 */
            if(eunm.getName().equals(actionName)){
                 absOrder.act();
            }
        }

    }

    private LinkedList<Class<?>> getActionChain() {
        LinkedList<Class<?>> actionChain = new LinkedList<>();
        actionChain.add(AfternoonAction.class);
        actionChain.add(MorningAction.class);
        actionChain.add(NoodayAction.class);
        return actionChain;
    }
}
