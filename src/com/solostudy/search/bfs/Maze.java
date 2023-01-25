package com.solostudy.search.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

public class Maze {
    /**
     * n * m 크기의 직사각형 형태의 미로에 갇혔다. 미로에는 여러 마리의 괴물이 있어 이를 피해 탈출해야함.
     * 첫 위치는 (1,1)이며 미로의 출구는 (n, m)의 위체오 존재하며 한번에 한칸씩만 이동 가능
     * 이때 괴물이 있는 부분은 0, 괴물이 없는 부분은 1로 표시되어있음.
     * 미로는 반드시 탈출 가능한 형태로 제시됨.
     * 이때 탈출하기 위해 움직여야 하는 최소 칸의 개수를 구하시오.
     * 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산함.
     */

    public static void main(String[] args) {
        System.out.println(solution());
    }

    private static final int n = 5;
    private static final int m = 6;
    private static final int[][] graph = new int[][]{
            {1, 0, 1, 0, 1, 0},
            {1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1}
    };
    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    private static final boolean[][] visited = new boolean[n][m];

    private static int solution() {
        final Deque<int[]> queue = new ArrayDeque<>();

        queue.addFirst(new int[]{0, 0, 1});

        while (!queue.isEmpty()) {
            final int[] coordinate = queue.removeLast();
            final int x = coordinate[0];
            final int y = coordinate[1];
            final int distance = coordinate[2];

            for (int i = 0; i < 4; i++) {
                final int nx = x + dx[i];
                final int ny = y + dy[i];

                if (nx >= n || ny >= m || nx < 0 || ny < 0) {
                    continue;
                }
                if (graph[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }

                if (nx == n - 1 && ny == m - 1) {
                    return distance + 1;
                }
                queue.addFirst(new int[]{nx, ny, distance + 1});
            }

            visited[x][y] = true;
        }

        throw new RuntimeException("탈출 불가");
    }
}
