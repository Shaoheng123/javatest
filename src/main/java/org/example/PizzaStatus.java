package org.example;

public enum PizzaStatus {

    ORDERED(5) {
        @Override
        public boolean isOrdered() {
            return true;
        }
    },
    READY(2) {
        @Override
        public boolean isReady() {
            return false;
        }
    };
    private final int timeToDelivery;

    PizzaStatus(int timeToDelivery) {
        this.timeToDelivery = timeToDelivery;
    }
    public int getTimeToDelivery() {
        return timeToDelivery;
    }


    public boolean isOrdered() { return false; }
    public boolean isReady() { return false;}


}
