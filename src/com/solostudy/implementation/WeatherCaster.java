package com.solostudy.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WeatherCaster {

    /**
     * JOI시는 남북방향이 H 킬로미터, 동서방향이 W 킬로미터인 직사각형 모양이다. JOI시는 가로와 세로의 길이가 1킬로미터인 H × W 개의 작은 구역들로 나뉘어 있다. 북쪽으로부터 i 번째,
     * 서쪽으로부터 j 번째에 있는 구역을 (i, j) 로 표시한다. 각 구역의 하늘에는 구름이 있을 수도, 없을 수도 있다. 모든 구름은 1분이 지날 때마다 1킬로미터씩 동쪽으로 이동한다. 오늘은 날씨가 정말
     * 좋기 때문에 JOI시의 외부에서 구름이 이동해 오는 경우는 없다. 지금 각 구역의 하늘에 구름이 있는지 없는지를 알고 있다. 기상청에서 일하고 있는 여러분은 각 구역에 대해서 지금부터 몇 분뒤 처음으로
     * 하늘에 구름이 오는지를 예측하는 일을 맡았다. 각 구역에 대해서 지금부터 몇 분뒤 처음으로 하늘에 구름이 오는지를 구하여라.
     */

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        char[][] sky = new char[n][m];

        for (int i = 0; i < n; i++) {
            final String inputLine = br.readLine();
            for (int j = 0; j < m; j++) {
                sky[i][j] = inputLine.charAt(j);
            }
        }
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sky[i][j] == 'c') {
                    result[i][j] = 0;
                    continue;
                }
                result[i][j] = -1;
            }
        }

        for (int i = 1; i <= m; i++) {
            moveOne(n, m, sky);
            checkResult(n, m, sky, result, i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void checkResult(final int n, final int m, final char[][] sky, final int[][] result, final int i) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                if (sky[j][k] == 'c') {
                    if (result[j][k] == -1) {
                        result[j][k] = i;
                    }
                }
            }
        }
    }

    private static void moveOne(final int n, final int m, final char[][] sky) {
        for (int i = m - 1; i >= 0; i--) {
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    sky[j][0] = '.';
                }
                continue;
            }
            for (int j = 0; j < n; j++) {
                sky[j][i] = sky[j][i - 1];
            }
        }
    }
}
