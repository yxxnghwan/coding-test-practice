package com.solostudy.implementation;

import java.util.Set;

public class Time3 {

    /**
     * 시각
     * 정수 n이 입력되면, 00시 00분 00초부 n시 59분 59초까지 모든 시각중에 3이 하나라도 포함되는 모든 경우의 수를 구하세요.
     * 0 <= n <= 23
     * ex)
     * n = 1 : 00시 00분 03, 00시 13분 30초 ...
     *
     *
     * 풀이)
     * 3이 들어가는 시간일 경우 60 * 60 = 3600의 경우를 세야함
     * 3이 안들어가는 시간일 경우 (15(분) * 60(초)) + (60(분) * 15(초)) - (15(분) * 15(초)) = 1575의 경우를 세야함
     *                       분에 3이 들어감        초에 3이 들어감         교집합
     *
     * 3이 들어가는 시간은
     * [3, 13, 23]
     */

    private static final Set<Integer> havingThreeHour = Set.of(3, 13, 23);

    public static void main(String[] args) {
        System.out.println(solution1(5)); // 11475
    }

    private static int solution1(final int hour) {
        int answer = 0;
        for (int i = 0; i <= hour; i++) {
            if (havingThreeHour.contains(i)) {
                answer += 3600;
            } else {
                answer += 1575;
            }
        }

        return answer;
    }
}
