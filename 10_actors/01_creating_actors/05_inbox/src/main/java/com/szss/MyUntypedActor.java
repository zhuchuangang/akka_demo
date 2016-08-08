package com.szss;

import akka.actor.*;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

/**
 * Created by zcg on 16/8/8.
 */
public class MyUntypedActor extends UntypedActor {

    final ActorSystem system=ActorSystem.create("system");

    final Inbox inbox=Inbox.create(system);

    @Override
    public void preStart() throws Exception {

        ActorRef actor=system.actorOf(Props.create(ReceiveUntypedActor.class));
        inbox.send(actor,"Hello");
        Object result=inbox.receive(Duration.create(1, TimeUnit.SECONDS));
        System.out.println("preStart:"+result);
        assert result.equals("Hello");

        inbox.watch(actor);
        actor.tell("World",ActorRef.noSender());
        try {
            assert inbox.receive(Duration.create(1, TimeUnit.SECONDS)) instanceof Terminated;
        }catch (java.util.concurrent.TimeoutException e){

        }
    }

    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("onReceive:"+message);
    }
}
