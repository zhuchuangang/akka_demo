package com.szss;

import akka.actor.UntypedActor;

/**
 * Created by zcg on 16/8/8.
 */
public class TestActor4 extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String){
            System.out.println("TestActor4 message is "+message);
            getSender().tell("close",getSelf());
        }else {
            unhandled(message);
        }
    }
}
