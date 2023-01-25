package com.solostudy.search.bfs;

import java.util.ArrayDeque;

public class EatIceCream {

    /**
     * n * m 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시됨.
     * 구멍이 뚫려있는 부분끼리 상하좌우 붙어있는 경우 서로 연결되어있는 것으로 간주
     * 이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림 개수를 구하는 프로그램을 작성
     *
     * ex)
     * 4 * 5 크기의 얼음틀
     *
     * 00110
     * 00011
     * 11111
     * 00000
     *
     * 3개 아이스크림 생성
     */

    private static final int n = 4;
    private static final int m = 5;
    private static final int[][] graph = new int[][]{
            {0, 0, 1, 1, 0},
            {0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}
    };

    public static void main(String[] args) {
        System.out.println(solution());
    }

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};
    private static boolean[][] visited;
    public static int solution() {
        visited = new boolean[n][m];
        int iceCreamCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    iceCreamCount++;
                }
            }
        }

        return iceCreamCount;
    }

    private static boolean dfs(final int i, final int j) {
        if (graph[i][j] == 1 || visited[i][j]) {
            return false;
        }

        final ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addFirst(new int[]{i, j});

        while (!queue.isEmpty()) {
            final int[] coordinate = queue.removeLast();
            final int x = coordinate[0];
            final int y = coordinate[1];

            for (int k = 0; k < 4; k++) {
                final int nx = x + dx[k];
                final int ny = y + dy[k];

                if (nx >= n || ny >= m || nx < 0 || ny < 0) {
                    continue;
                }
                if (visited[nx][ny] || graph[nx][ny] == 1) {
                    continue;
                }
                queue.addFirst(new int[]{nx, ny});
            }

            visited[x][y] = true;
        }

        return true;
    }
}
