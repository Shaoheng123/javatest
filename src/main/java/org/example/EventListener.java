package org.example;

public interface EventListener {
    String onTrigger();
    default void respondToTrigger() {
        System.out.println("This is a side effect of the asynchronous trigger.");
    }
}
