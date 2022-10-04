package com.solostudy.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1463 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int[] d;

    public static void main(String[] args) throws IOException {

        final int x = Integer.parseInt(br.readLine());
        d = new int[x + 1];
        d[1] = 0;
        for (int i = 2; i < x + 1; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 3 == 0) {
                if (d[i / 3] + 1 < d[i]) {
                    d[i] = d[i / 3] + 1;
                }
            }
            if (i % 2 == 0) {
                if (d[i / 2] + 1 < d[i]) {
                    d[i] = d[i / 2] + 1;
                }
            }
        }

        System.out.println(d[x]);
    }
}
