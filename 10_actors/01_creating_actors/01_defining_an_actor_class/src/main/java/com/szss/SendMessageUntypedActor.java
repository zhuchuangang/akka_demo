package com.szss;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by zcg on 16/8/8.
 */
public class SendMessageUntypedActor extends UntypedActor {

    @Override
    public void preStart() throws Exception {
        ActorRef actorRef=getContext().actorOf(Props.create(MyUntypedActor.class),"sendMessage");
        actorRef.tell("Hello",getSelf());
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String){
            System.out.println(message);
        }else{
            unhandled(message);
        }
    }
}
