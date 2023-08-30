package com.ll.demo.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @name: OrderMessage
 * @author: tuacy.
 * @date: 2019/7/9.
 * @version: 1.0
 * @Description: 命令监听者
 */
public class OrderEventListener {

    /**
     * 如果发送了OrderMessage消息，会进入到该函数的处理
     * @param event 消息
     */
    @Subscribe
    public void dealWithEvent(OrderMessage event) {
        // TODO: 收到EventTest消息之后，做相应的处理
        System.out.println("我收到了您的命令，命令内容为：" + event.getOrderContent());
    }


    @Subscribe
    public void dealWithEvent2(OrderMessage event) {
        // TODO: 收到EventTest消息之后，做相应的处理
        System.out.println("我2收到了您的命令，命令内容为：" + event.getOrderContent());
    }

    @Subscribe
    public void dealWithEvent2(Object event) {
        // TODO: 收到EventTest消息之后，做相应的处理
        System.out.println("我3收到了您的命令，命令内容为：" + event);
    }


    @Subscribe
    public void dealWithEvent4(EmailMessage event) {
        // TODO: 收到EventTest消息之后，做相应的处理
        System.out.println("我4收到了您的命令，命令内容为：" + event.getContent());
    }

}