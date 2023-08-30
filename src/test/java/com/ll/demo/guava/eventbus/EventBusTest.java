package com.ll.demo.guava.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @title EventBusTest
 * @date 8/30/2023 2:08 PM
 * @description TODO
 */
public class EventBusTest {


    @Test
    public void eventBus() {
        // 定义一个EventBus对象，因为我这里是测试，才这样写的。实际你应该定义一个单例获取其他的方式
        EventBus eventBus = new EventBus("test");
        // 注册监听者
        eventBus.register(new OrderEventListener());
        eventBus.register(new OrderEventListener());
        // 发布消息
        eventBus.post(new OrderMessage("hello from orderMessage"));

        System.out.println("------------------------");
        eventBus.post(new EmailMessage("hello from emailMessage"));
    }

    @Test
    public void eventBus2() {
        AsyncEventBus eventBus = new AsyncEventBus("test", new ThreadPoolTaskExecutor());
    }
}
