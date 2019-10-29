package com.example.listener;

import com.example.enums.Events;
import com.example.enums.States;
import lombok.extern.slf4j.Slf4j;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StateMachineListener extends StateMachineListenerAdapter<States, Events> {

    @Override
    public void transition(Transition<States, Events> transition) {
        if(transition.getTarget().getId() == States.UNPAID) {
            log.info("订单创建，待支付");
            return;
        }

        if(transition.getSource().getId() == States.UNPAID
                && transition.getTarget().getId() == States.RECEIVE) {
            log.info("用户完成支付，待收货");
            return;
        }

        if(transition.getSource().getId() == States.RECEIVE
                && transition.getTarget().getId() == States.DONE) {
            log.info("用户已收货，订单完成");
            return;
        }
    }
}
