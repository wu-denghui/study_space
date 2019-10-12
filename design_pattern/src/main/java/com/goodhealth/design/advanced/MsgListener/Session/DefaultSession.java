package com.goodhealth.design.advanced.MsgListener.Session;

import java.util.ArrayList;
import java.util.List;

import com.goodhealth.design.advanced.MsgListener.MsgListener.Listener.AbstractMsgListener;
import com.goodhealth.design.advanced.MsgListener.Msg.MsgEvent;
import com.goodhealth.design.advanced.MsgListener.Msg.MsgImage;
import com.goodhealth.design.advanced.MsgListener.Msg.MsgLink;
import com.goodhealth.design.advanced.MsgListener.Msg.MsgText;

/**
 * @ClassName DefaultSession
 * @Description TODO
 * @Author WDH
 * @Date 2019/9/2 19:16
 * @Version 1.0
 **/
public class DefaultSession extends AbstractSession {
    /** 监听器集合 */
    private List<AbstractMsgListener> listeners = new ArrayList<AbstractMsgListener>(6);

    /**
     * 私有构造方法
     */
    private DefaultSession() {}


    /**
     * 创建一个Session实例
     * */
    public static DefaultSession newInstance() {
        return new DefaultSession();
    }


    /**
     * 添加监听器
     * @param handleMassge
     */
    public void addOnHandleMessageListener(AbstractMsgListener handleMassge){
        listeners.add(handleMassge);
    }


    /**
     * 移除监听器
     * */
    public void removeOnHandleMessageListener(AbstractMsgListener handleMassge){
        listeners.remove(handleMassge);
    }


    @Override
    public void handleTextMsg(MsgText msg) {
        for(AbstractMsgListener currentListener : listeners){
            currentListener.handleTextMsg(msg);
        }
    }

    @Override
    public void handleImageMsg(MsgImage msg) {
        for(AbstractMsgListener currentListener : listeners){
            currentListener.handleImageMsg(msg);
        }
    }

    @Override
    public void handleEventMsg(MsgEvent msg) {
        for(AbstractMsgListener currentListener : listeners){
            currentListener.handleEventMsg(msg);
        }
    }

    @Override
    public void handleLinkMsg(MsgLink msg) {
        for(AbstractMsgListener currentListener : listeners){
            currentListener.handleLinkMsg(msg);
        }
    }

    @Override
    public void handleErrorMsg(int errorCode) {
        for(AbstractMsgListener currentListener : listeners){
            currentListener.handleErrorMsg(errorCode);
        }

    }
}
