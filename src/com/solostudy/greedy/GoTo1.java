package com.solostudy.greedy;

public class GoTo1 {

    /**
     * 1이 될 때까지
     * 숫자 n이랑 k 주어지는데 숫자에 다음과 같은 연산을 할 수 있음
     * - n에서 1을 뺌
     * - n을 k로 나눔
     *
     * n이 1이 되려면 최소 몇번의 연산을 해야하는지 구해라
     *
     * 나눌 수 있으면 나누는게 1 빼는 것보다 더 많이 빠짐
     * 너무 쉬운 그리디
     */

    public static void main(String[] args) {
        System.out.println(solution(25, 3));
    }

    private static int solution(int n, int k) {
        int count = 0;
        while (n != 1) {
            if (n % k == 0) {
                n /= k;
            } else {
                n -= 1;
            }
            count++;
        }

        return count;
    }
}
