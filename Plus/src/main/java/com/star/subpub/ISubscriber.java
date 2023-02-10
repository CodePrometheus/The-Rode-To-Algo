package com.star.subpub;

public interface ISubscriber {

    void on(String publisher, String msg);

}
