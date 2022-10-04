package com.solostudy.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BaekJoon1463 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final Deque<long[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        long x = Long.parseLong(br.readLine());
        int min = Integer.MAX_VALUE;
        queue.addFirst(new long[]{x, 0});
        // bfs로 풀어보기
        while (!queue.isEmpty()) {
            final long[] numbers = queue.removeLast();
            final long number = numbers[0];
            final long count = numbers[1];
            if (number == 1) {
                if (min > count) {
                    min = (int) count;
                    continue;
                }
            }
            if (count >= min) {
                continue;
            }
            if (number % 3 == 0) {
                queue.addFirst(new long[]{number / 3, count + 1});
            }
            if (number % 2 == 0) {
                queue.addFirst(new long[]{number / 2, count + 1});
            }
            if (number > 1) {
                queue.addFirst(new long[]{number - 1, count + 1});
            }
        }

        System.out.println(min);
    }
}
