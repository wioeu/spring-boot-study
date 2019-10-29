package com.example.config;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class EventConfig {

    @OnTransition(target = "UNPAID")
    public void create() {
        System.out.println("-------订单创建，待支付");
    }

    @OnTransition(source = "UNPAID", target = "RECEIVE")
    public void pay() {
        System.out.println("---------用户完成支付，待收货");
    }

    @OnTransition(source = "RECEIVE", target = "DONE")
    public void receive() {
        System.out.println("---------用户已收货，订单完成");
    }

}
