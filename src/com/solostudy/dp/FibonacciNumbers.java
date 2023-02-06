package com.solostudy.dp;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumbers {
    // 1, 1, 2, 3, 5, 8, 13, 21 ...
    public static void main(String[] args) {
        System.out.println(fibo(6));
    }

    public static long fibo(final int i) {
        final List<Long> numbers = new ArrayList<>();
        numbers.add(1L);
        numbers.add(1L);

        for (int j = 2; j < i; j++) {
            numbers.add(numbers.get(j - 2) + numbers.get(j - 1));
        }

        return numbers.get(i - 1);
    }
}
