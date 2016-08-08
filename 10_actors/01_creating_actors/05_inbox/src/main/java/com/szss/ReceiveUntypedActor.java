package com.szss;

import akka.actor.UntypedActor;

/**
 * Created by zcg on 16/8/8.
 */
public class ReceiveUntypedActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("ReceiveUntypedActor receive message is "+message);
        getSender().tell(message,getSelf());
    }
}
