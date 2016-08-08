package com.szss;

import akka.actor.UntypedActor;

/**
 * Created by zcg on 16/8/5.
 */
public class Greeter extends UntypedActor {

    public static enum Msg {
        GREET, DONE;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message== Msg.GREET){
            System.out.println("Hello World");
            getSender().tell(Msg.DONE, getSelf());
        }else{
            unhandled(message);
        }
    }
}
