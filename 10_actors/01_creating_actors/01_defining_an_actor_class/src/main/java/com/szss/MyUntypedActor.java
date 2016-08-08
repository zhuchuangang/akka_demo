package com.szss;

import akka.actor.UntypedActor;

/**
 * Created by zcg on 16/8/8.
 */
public class MyUntypedActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String){
            System.out.println("Message is "+message);
            getSender().tell(message,getSelf());
        }else{
            unhandled(message);
        }
    }
}
