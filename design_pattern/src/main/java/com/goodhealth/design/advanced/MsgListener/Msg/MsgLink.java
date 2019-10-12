package com.goodhealth.design.advanced.MsgListener.Msg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName MsgLink
 * @Description TODO 链接型消息
 * @Author WDH
 * @Date 2019/8/22 20:19
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MsgLink extends AbstractMsg{
    /**
     * 链接指向的地址
     */
    private String url;
    /**
     * 链接的文本
     */
    private String text;

    @Override
    public void preHandle() {

    }

    @Override
    public void postHandle() {

    }
}
