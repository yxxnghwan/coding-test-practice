package com.solostudy.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BaekJoon2178 {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static int n = 0;
    private static int m = 0;
    private static int[][] graph;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            final String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }
        bfs();

        System.out.println(graph[n - 1][m - 1]);
    }

    private static void bfs() {
        final Deque<int[]> queue = new ArrayDeque<>();
        queue.addFirst(new int[]{0, 0});
        while (!queue.isEmpty()) {
            final int[] point = queue.removeLast();
            final int x = point[0];
            final int y = point[1];

            for (int i = 0; i < 4; i++) {
                final int nx = x + dx[i];
                final int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (visited[nx][ny] || graph[nx][ny] == 0) {
                    continue;
                }

                graph[nx][ny] = graph[x][y] + 1;
                visited[nx][ny] = true;
                queue.addFirst(new int[]{nx, ny});
            }
        }
    }
}
