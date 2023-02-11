package com.solostudy.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExtraCoin {
    /**
     * 춘향이는 편의점 카운터에서 일한다.
     *
     * 손님이 2원짜리와 5원짜리로만 거스름돈을 달라고 한다.
     * 2원짜리 동전과 5원짜리 동전은 무한정 많이 가지고 있다.
     * 동전의 개수가 최소가 되도록 거슬러 주어야 한다.
     * 거스름돈이 n인 경우, 최소 동전의 개수가 몇 개인지 알려주는 프로그램을 작성하시오.
     *
     * 예를 들어, 거스름돈이 15원이면 5원짜리 3개를,
     * 거스름돈이 14원이면 5원짜리 2개와 2원짜리 2개로 총 4개를,
     * 거스름돈이 13원이면 5원짜리 1개와 2원짜리 4개로 총 5개를 주어야 동전의 개수가 최소가 된다.
     *
     * 입력
     * 첫째 줄에 거스름돈 액수 n(1 ≤ n ≤ 100,000)이 주어진다.
     *
     * 출력
     * 거스름돈 동전의 최소 개수를 출력한다. 만약 거슬러 줄 수 없으면 -1을 출력한다.
     */

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(-1);
            return;
        }
        if (n == 2) {
            System.out.println(1);
            return;
        }
        if (n == 3) {
            System.out.println(-1);
            return;
        }
        if (n == 4) {
            System.out.println(2);
            return;
        }
        if (n == 5) {
            System.out.println(1);
            return;
        }
        final int[] dp = new int[n + 1];
        dp[0] = -1;
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            dp[i] = i;
            if (dp[i - 5] != -1) {
                dp[i] = dp[i - 5] + 1;
            }

            if (dp[i - 2] != -1) {
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            }

            if (dp[i - 2] == -1 && dp[i - 5] == -1) {
                dp[i] = -1;
            }
        }

        System.out.println(dp[n]);
    }
}
