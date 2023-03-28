package com.solostudy.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BaekJoon1012 {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int m;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {

        final int t = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수
        int testLoop = 0;
        while (testLoop < t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로
            n = Integer.parseInt(st.nextToken()); // 세로
            k = Integer.parseInt(st.nextToken()); // 배추갯수

            graph = new int[m][n];
            visited = new boolean[m][n];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = 1;
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] || graph[i][j] == 0) {
                        visited[i][j] = true;
                        continue;
                    }
                    bfs(i, j);
                    count++;
                }
            }

            System.out.println(count);
            testLoop++;
        }
    }

    public static void bfs(int firstX, int firstY) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.addFirst(new int[]{firstX, firstY});
        while (!queue.isEmpty()) {
            final int[] point = queue.removeLast();
            int x = point[0];
            int y = point[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= m || nx < 0 || ny >= n || ny < 0) {
                    continue;
                }

                if (!visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.addFirst(new int[]{nx, ny});
                }
            }
        }
    }
}

