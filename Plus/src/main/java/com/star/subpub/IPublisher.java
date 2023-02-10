package com.star.subpub;

public interface IPublisher {

    /**
     * 添加订阅者
     */
    void emit(ISubscriber subscriber);

    /**
     * 触发消息
     */
    void on(String msg);

    /**
     * 移除订阅者
     */
    void remove(ISubscriber subscriber);

}
