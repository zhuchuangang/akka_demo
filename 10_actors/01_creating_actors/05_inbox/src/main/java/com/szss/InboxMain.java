package com.szss;

/**
 * Created by zcg on 16/8/8.
 */
public class InboxMain {
    public static void main(String[] args) {
        akka.Main.main(new String[]{MyUntypedActor.class.getName()});
    }
}
