package com.solostudy.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9095 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int[] d = new int[12];

    public static void main(String[] args) throws IOException {
        final int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            final int number = Integer.parseInt(br.readLine());
            dp(number);
        }
    }

    private static void dp(final int number) {
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= number; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }
        System.out.println(d[number]);
    }
}
