package com.szss;

import akka.actor.UntypedActor;

/**
 * Created by zcg on 16/8/8.
 */
public class TestActor1 extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String){
            System.out.println("TestActor1 message is "+message);
        }else {
            unhandled(message);
        }
    }
}
