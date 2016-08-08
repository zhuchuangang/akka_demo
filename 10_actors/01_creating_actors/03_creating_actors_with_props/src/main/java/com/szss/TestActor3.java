package com.szss;

import akka.actor.UntypedActor;
import akka.japi.Creator;

/**
 * Created by zcg on 16/8/8.
 */
public class TestActor3 extends UntypedActor{

    Integer count=0;

    public TestActor3(Integer param){
        this.count=param;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String){
            System.out.println("TestActor3 message is "+message+",count is "+count);
            getSender().tell("close",getSelf());
        }

    }

    static class TestActorCreator implements Creator<TestActor3>{
        public TestActor3 create() throws Exception {
            return new TestActor3(10);
        }
    }
}
