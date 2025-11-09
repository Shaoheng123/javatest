package org.example;

public class Recursion {
    private static int factorialHelper(int n, int accumulator) {
        if (n <= 1) {
            return accumulator; // Base case
        }
        return factorialHelper(n - 1, n * accumulator); // Tail-recursive call
    }


}
