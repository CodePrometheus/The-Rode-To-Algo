package com.star.subpub;

/**
 * @Author: Starry
 * @Date: 02-02-2023
 */
public class TestSubPub {

    public static void main(String[] args) {
        // Subscriber subscriber1 = new Subscriber("张三", (publisher, msg) -> {
        //     // 收到消息
        //     System.out.println(publisher + ":" + msg);
        // }); // 创建订阅者张三
        Subscriber subscriber2 = new Subscriber("李四"); // 创建订阅者李四
        Subscriber subscriber3 = new Subscriber("王五"); // 创建订阅者王五

        Publisher publisher = new Publisher("小明"); // 创建发布者小明
        // publisher.emit(subscriber1); // 添加张三订阅者
        publisher.emit(subscriber2); // 添加李四订阅者
        publisher.emit(subscriber3); // 添加王五订阅者

        publisher.on("祝你虎年大吉大利"); // 发布新消息
    }

}
