package com.solostudy.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2839 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int threeCount = 0;
        while (n >= 0) {
            if (n % 5 == 0) {
                System.out.println((n / 5) + threeCount);
                return;
            }
            threeCount++;
            n -= 3;
        }

        System.out.println(-1);
    }
}
