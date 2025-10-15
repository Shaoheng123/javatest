package org.example;

import java.util.function.Consumer;

public class ConsumerCallBack {
    int age;

    public void getAge(int initialAge, Consumer<Integer> callback) {
        callback.accept(initialAge);

    }
    public void increaseAge(int initialAge, int ageDifference, Consumer<Integer> callback){
        int newAge = initialAge + ageDifference;
        callback.accept(newAge);
    }
}
