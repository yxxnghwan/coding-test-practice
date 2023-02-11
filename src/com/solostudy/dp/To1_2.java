package com.solostudy.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class To1_2 {
    /**
     * 1로 만들기 2
     *
     * 1) x가 3으로 나눠떨어지면 3으로 나눈다.
     * 2) x가 2로 나눠떨어지면 2로 나눈다.
     * 3) 1을 뺀다.
     *
     * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
     *
     * 입력
     * 첫째 줄에 1보다 크거나 같고, 10의 6승 보다 작거나 같은 정수 N이 주어진다.
     *
     * 출력
     * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
     *
     * 힌트
     * 10의 경우에 10 → 9 → 3 → 1 로 3번 만에 만들 수 있다.
     */

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        if (n == 2) {
            System.out.println(1);
            System.out.println("2 1");
            return;
        }

        if (n == 3) {
            System.out.println(1);
            System.out.println("3 1");
            return;
        }

        final int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            final List<Integer> list = new ArrayList<>();
            if (i % 2 == 0) {
                list.add(i / 2);
            }
            if (i % 3 == 0) {
                list.add(i / 3);
            }
            list.add(i - 1);
            dp[i] = list.stream()
                    .mapToInt(it -> dp[it])
                    .min()
                    .getAsInt() + 1;
        }

        final List<Integer> minRoot = new ArrayList<>();
        minRoot.add(n);
        int t = n;
        while (t != 1) {
            final List<Integer> list = new ArrayList<>();
            if (t % 2 == 0) {
                list.add(t / 2);
            }
            if (t % 3 == 0) {
                list.add(t / 3);
            }
            list.add(t - 1);

            final int min = list.stream()
                    .mapToInt(it -> dp[it])
                    .min()
                    .getAsInt();

            final Integer next = list.stream().filter(it -> dp[it] == min).findAny().get();
            minRoot.add(next);
            t = next;
        }

        System.out.println(dp[n]);
        System.out.println(minRoot.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
