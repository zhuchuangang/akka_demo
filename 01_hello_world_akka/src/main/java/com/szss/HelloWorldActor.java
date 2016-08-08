package com.szss;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by zcg on 16/8/5.
 */
public class HelloWorldActor extends UntypedActor {

    @Override
    public void preStart() throws Exception {
        final ActorRef greeter=getContext().actorOf(Props.create(Greeter.class),"greeter");
        greeter.tell(Greeter.Msg.GREET, getSelf());
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message== Greeter.Msg.DONE){
            getContext().stop(getSelf());
        }else{
            unhandled(message);
        }
    }
}
