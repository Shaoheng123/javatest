package org.example;

public class SynchronousEventListenerImpl implements EventListener{
    @Override
    public String onTrigger() {
        return "callBack sync";
    }
}
