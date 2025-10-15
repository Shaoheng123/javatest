package org.example;

public class SynchronousEventConsumer {

    private final EventListener eventListener;

    public SynchronousEventConsumer(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public String doSynchronousOperation() {
        return eventListener.onTrigger();
    }
}
