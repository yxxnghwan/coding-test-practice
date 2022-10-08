package com.solostudy.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2579 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] s;
    private static int[] dp;

    public static void main(String[] args) throws IOException {

        final int n = Integer.parseInt(br.readLine());
        s = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            s[i + 1] = Integer.parseInt(br.readLine());
        }
        dp[1] = s[1];
        if (n == 1) {
            System.out.println(dp[1]);
            return;
        }
        dp[2] = s[1] + s[2];
        if (n == 2) {
            System.out.println(dp[2]);
            return;
        }
        dp[3] = Math.max(s[1], s[2]) + s[3];
        if (n == 3) {
            System.out.println(dp[3]);
            return;
        }
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + s[i - 1], dp[i - 2]) + s[i];
        }

        System.out.println(dp[n]);
    }
}
