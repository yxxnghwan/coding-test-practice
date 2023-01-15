package com.solostudy.greedy;

public class MulOrSum {

    /**
     * 곱하기 혹은 더하기
     * 0이상의 숫자로만 이루어진 문자열이 주어짐
     * 왼쪽부터 차례대로 각 숫자사이에 더하기나 곱하기 연산을 할 수 있음
     * 최종적으로 제일 큰값.
     *
     * 그냥 0이나 1이면 더하기 그거보다 크면 곱하기
     */

    public static void main(String[] args) {
        System.out.println(solution("02984")); // 576
    }

    private static long solution(String numberStr) {
        long number = Character.getNumericValue(numberStr.charAt(0));
        numberStr = numberStr.substring(1);

        for (int i = 0; i < numberStr.length(); i++) {
            final int nowNumber = Character.getNumericValue(numberStr.charAt(i));
            if (number <= 1 || nowNumber <= 1) {
                number += nowNumber;
            } else {
                number *= nowNumber;
            }
        }

        return number;
    }
}
