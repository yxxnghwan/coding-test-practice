package com.solostudy.greedy;

public class Changes {

    /**
     * 500, 100, 50, 10원 동전이 무한히 있는 카운터에서 거스름돈을 입력하면 받게 되는 최소 동전 갯수 거스름 돈은 무조건 10의 배수
     * 큰 단위가 작은 단위의 배수이기 때문에 그리디가 가능한 것.
     * 만약 동전 단위가 500, 400, 100원인데 800원이 입력된다면?
     * 그리디로 풀 수 없다.
     */
    private static final int[] coins = {500, 100, 50, 10};

    public static void main(String[] args) {
        System.out.println(solution(1260));
    }

    private static int solution(final int changes) {
        int n = changes;
        int coinCount = 0;

        for (int coin : coins) {
            coinCount += n / coin;
            n = n % coin;
        }

        return coinCount;
    }
}
