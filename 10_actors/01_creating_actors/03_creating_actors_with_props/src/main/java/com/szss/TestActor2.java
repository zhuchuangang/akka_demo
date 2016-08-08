package com.szss;

import akka.actor.UntypedActor;

/**
 * Created by zcg on 16/8/8.
 */
public class TestActor2 extends UntypedActor {

    private String name;

    public TestActor2(String name) {
        this.name = name;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String){
            System.out.println("TestActor2 message is "+message+",This Class name is "+name);
            getSender().tell("close",getSelf());
        }
    }
}
