package org.example;

public class AsyncEventConsumer {
    private EventListener eventListener;

    public AsyncEventConsumer(EventListener eventListener) {
        this.eventListener = eventListener;
    }
    public void doAsynchronousOperation() {
        System.out.println("Performing Async Class");
        new Thread(()->eventListener.onTrigger()).start();

    }

    public String onTrigger() {
        return null;
    }
}
