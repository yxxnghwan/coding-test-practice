package com.solostudy.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BaekJoon4179 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static final Deque<int[]> fQueue = new ArrayDeque<>();
    private static final Deque<int[]> jQueue = new ArrayDeque<>();

    private static int n; // R
    private static int m; // C

    private static int[][] fDist;
    private static int[][] jDist;

    private static boolean[][] fVisited;
    private static boolean[][] jVisited;

    private static char[][] graph;

    public static void main(String[] args) throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        fDist = new int[n][m];
        jDist = new int[n][m];
        fVisited = new boolean[n][m];
        jVisited = new boolean[n][m];
        graph = new char[n][m];

        for (int i = 0; i < n; i++) {
            final String line = br.readLine();
            for (int j = 0; j < m; j++) {
                final char c = line.charAt(j);
                graph[i][j] = c;
                if (c == 'J') {
                    jVisited[i][j] = true;
                    jDist[i][j] = 1;
                    jQueue.addFirst(new int[]{i, j});
                }
                if (c == 'F') {
                    fVisited[i][j] = true;
                    fDist[i][j] = 1;
                    fQueue.addFirst(new int[]{i, j});
                }
                if (c == '.') {
                    fDist[i][j] = Integer.MAX_VALUE;
                    jDist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        fBFS();

        jBFS();
    }

    private static void jBFS() {
        while (!jQueue.isEmpty()) {
            final int[] point = jQueue.removeLast();
            final int x = point[0];
            final int y = point[1];

            for (int i = 0; i < 4; i++) {
                final int nx = x + dx[i];
                final int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    System.out.println(jDist[x][y]);
                    return;
                }
                if (graph[nx][ny] == '#') {
                    continue;
                }
                if (jVisited[nx][ny] || fDist[nx][ny] <= jDist[x][y] + 1) {
                    continue;
                }

                jVisited[nx][ny] = true;
                jDist[nx][ny] = jDist[x][y] + 1;

                jQueue.addFirst(new int[]{nx, ny});
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private static void fBFS() {
        while (!fQueue.isEmpty()) {
            final int[] point = fQueue.removeLast();
            final int x = point[0];
            final int y = point[1];

            for (int i = 0; i < 4; i++) {
                final int nx = x + dx[i];
                final int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (graph[nx][ny] == '#') {
                    continue;
                }
                if (fVisited[nx][ny]) {
                    continue;
                }

                fVisited[nx][ny] = true;
                fDist[nx][ny] = fDist[x][y] + 1;

                fQueue.addFirst(new int[]{nx, ny});
            }
        }
    }
}
