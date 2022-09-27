package com.solostudy.datastructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BaekJoon20301 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean turnFlag = true;

    public static void main(String[] args) throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int k = Integer.parseInt(stringTokenizer.nextToken());
        final int m = Integer.parseInt(stringTokenizer.nextToken());

        final Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        moveDeque(k, deque);

        int count = m;
        while (true) {
            final Integer number = deque.removeFirst();
            System.out.println(number);
            if (deque.isEmpty()) {
                break;
            }
            count--;
            if (count == 0) {
                count = m;
                turnFlag = !turnFlag;
            }
            if (turnFlag) {
                moveDeque(k, deque);
            } else {
                reverseMoveDeque(k, deque);
            }
        }
    }

    private static void moveDeque(final int k, final Deque<Integer> deque) {
        for (int i = 0; i < k - 1; i++) {
            final Integer number = deque.removeFirst();
            deque.addLast(number);
        }
    }

    private static void reverseMoveDeque(final int start, final Deque<Integer> deque) {
        for (int i = 0; i < start; i++) {
            final Integer number = deque.removeLast();
            deque.addFirst(number);
        }
    }
}
