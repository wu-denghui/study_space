package com.goodhealth.design.advanced.MsgListener.Msg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName MsgText
 * @Description TODO 文本型消息
 * @Author WDH
 * @Date 2019/8/22 20:19
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MsgText extends AbstractMsg{
    /**
     * 文本标题
     */
    private String title;
    /**
     * 文本内容
     */
    private String context;

    @Override
    public void preHandle() {

    }

    @Override
    public void postHandle() {

    }
}
