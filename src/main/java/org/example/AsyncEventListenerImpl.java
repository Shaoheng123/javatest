package org.example;

public class AsyncEventListenerImpl implements EventListener{

    @Override
    public String onTrigger() {
        respondToTrigger();
        return "Async";
    }
}
