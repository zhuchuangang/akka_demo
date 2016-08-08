package com.szss;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by zcg on 16/8/8.
 */
public class MyUntypedActor extends UntypedActor {
    final Props props1=Props.create(TestActor1.class);
    final ActorRef testActor1=getContext().actorOf(props1);
    final Props props2=Props.create(TestActor2.class,"TestActor2");
    final ActorRef testActor2=getContext().actorOf(props2);
    final Props props3=Props.create(new TestActor3.TestActorCreator());
    final ActorRef testActor3=getContext().actorOf(props3);

    @Override
    public void preStart() throws Exception {
        testActor1.tell("Test1",getSelf());
        testActor2.tell("Test2",getSelf());
        testActor3.tell("Test3",getSelf());
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String){
            System.out.println(message);
            if ("close".equals(message)){
                getContext().stop(testActor1);
                getContext().stop(testActor2);
                getContext().stop(testActor3);
            }
        }
    }
}
