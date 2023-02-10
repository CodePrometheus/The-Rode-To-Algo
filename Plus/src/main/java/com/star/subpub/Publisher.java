package com.star.subpub;

import java.util.ArrayList;

public class Publisher implements IPublisher {

    // 定义一个集合来存储订阅者
    private ArrayList events = new ArrayList<Subscriber>();

    // 发布者名称
    private String name;

    // 创建发布者
    public Publisher(String name) {
        this.name = name;
    }

    @Override
    public void emit(ISubscriber subscriber) {
        // 将每一个新的订阅者添加到集合中维护
        events.add(subscriber);
    }

    @Override
    public void on(String msg) {
        // 触发订阅的原理就是遍历该集合，然后将消息发送给集合中的每一个订阅者
        for (int i = 0; i < events.size(); i++) {
            Subscriber subscriber = (Subscriber) events.get(i);
            subscriber.on(this.name, msg);
        }
    }

    @Override
    public void remove(ISubscriber subscriber) {
        // 移除订阅者
        events.remove(subscriber);
    }

}
