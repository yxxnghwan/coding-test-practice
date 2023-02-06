package com.solostudy.dp;

public class AntWarrior {

    /**
     * 개미 전사는 부족한 식량을 충당하고자 메뚜기 마을의 식량창고를 몰래 공격하려함.
     * 메뚜기 마을에는 여러 개의 식량창고가 있는데 일직선으로 이어짐
     * 각 식량창고에는 정해진 수의 식량을 저장하고 있으며, 개미 전사는 식량창고를 선택적으로 약탈하여 식량을 빼앗을 예정.
     * 이때 메뚜기 정찰병들은 일직선상에 존재하는 식량창고 중에서 서로 인접한 식량창고가 공격받으면 바로 알아챔
     * 따라서 개미 전사가 정찰병에게 들키지 않고 식량창고를 약탈하기 위해서는 최소한 한 칸 이상 떨어진 식량창고를 약탈해야 함.
     *
     * ex) 1, 3, 1, 5 => 8
     * ex) 4, 1, 1, 3, 1 => 7
     */

    private static int[] dp;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 1, 1, 3, 1}));
    }

    public static int solution(final int[] k) {
        dp = new int[k.length];
        dp[0] = k[0];
        dp[1] = Math.max(k[0], k[1]);

        for (int i = 2; i < k.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + k[i]);
        }

        return dp[k.length - 1];
    }
}
