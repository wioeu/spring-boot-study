package com.example.controller;

import com.example.enums.Events;
import com.example.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateMachineController {

    @Autowired
    StateMachine<States, Events> stateMachine;

    @GetMapping("stateMachine")
    public void stateMachine(){
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }
}
