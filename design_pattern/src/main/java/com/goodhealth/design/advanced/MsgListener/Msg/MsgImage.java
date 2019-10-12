package com.goodhealth.design.advanced.MsgListener.Msg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName MsgImage
 * @Description TODO 图片型消息
 * @Author WDH
 * @Date 2019/8/22 20:19
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MsgImage extends AbstractMsg{
    /**
     * 图片的地址
     */
    private String url;
    /**
     * 图片的说明
     */
    private String  introduce;

    /**
     * 图的类型 pgn jpn gif
     */
    private String pictureType;

    @Override
    public void preHandle() {

    }

    @Override
    public void postHandle() {

    }
}
