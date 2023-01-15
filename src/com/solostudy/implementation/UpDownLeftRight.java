package com.solostudy.implementation;

import java.util.Arrays;
import java.util.List;

public class UpDownLeftRight {

    /**
     * 여행가 a가 n * n 크기의 정사각형 공간 위에 서있음. 맨위 왼쪽 좌표는 (1,1) 맨 오른쪽 아래는 (n, n)이라함.
     * a는 상, 하, 좌, 우로 이동할 수 있으며 주어진 계획서에 따라 이동함.
     * 계획서에는 한 줄에 공백을 기준으로 L, R, U, D의 문자가 반복적으로 적혀있음
     * L: 왼쪽으로 한 칸 이동
     * R: 오른쪽으로 한 칸 이동
     * U: 위쪽으로 한 칸 이동
     * D: 아래로 한 칸 이동
     *
     * 공간 밖으로 벗어나는 움직임은 무시됩니다. 결과적으로 도착하는 좌표를 출력.
     */

    static int x = 1;
    static int y = 1;

    public static void main(String[] args) {
        solution("R R R U D D", 5);
        System.out.println(x + " " + y); // 3 4
    }

    private static void solution(final String planStr, final int n) {
        final List<String> plans = List.of(planStr.split("\\s+"));

        for (String plan : plans) {
            final Direction direction = Direction.of(plan);
            final int nx = x + direction.getDx();
            final int ny = y + direction.getDy();
            if (nx < 1 || nx > n || ny < 1 || ny > n) {
                continue;
            }
            x = nx;
            y = ny;
        }
    }

    enum Direction {
        UP(-1, 0, "U"),
        DOWN(1, 0, "D"),
        LEFT(0, -1, "L"),
        RIGHT(0, 1, "R")
        ;

        private int dx;
        private int dy;
        private String command;

        Direction(final int dx, final int dy, final String command) {
            this.dx = dx;
            this.dy = dy;
            this.command = command;
        }

        public static Direction of(final String command) {
            return Arrays.stream(values())
                    .filter(it -> it.getCommand().equals(command))
                    .findAny()
                    .orElseThrow();
        }

        public int getDx() {
            return dx;
        }

        public int getDy() {
            return dy;
        }

        public String getCommand() {
            return command;
        }
    }
}
