package com.example.backdemo.demo.eventbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * @description:
 * @author: superman
 * @create: 2020-05-20 18:51
 **/
public class EventBusDemo {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new DemoListener());
        eventBus.post(4);
    }
    public static class DemoListener{

        @Subscribe
        public void listener(Integer a) {
            System.out.println("=================");
            System.out.println(a);
        }
    }
}
