package com.solostudy.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BaekJoon7569 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int[] dx = {1, -1, 0, 0, 0, 0};
    private static final int[] dy = {0, 0, 1, -1, 0, 0};
    private static final int[] dz = {0, 0, 0, 0, 1, -1};

    private static int m;
    private static int n;
    private static int h;

    private static int[][][] graph;
    private static int[][][] dist;
    private static boolean[][][] visited;
    private static Deque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        h = Integer.parseInt(stringTokenizer.nextToken());

        graph = new int[n][m][h];
        visited = new boolean[n][m][h];
        dist = new int[n][m][h];

        for (int z = 0; z < h; z++) {
            for (int y = 0; y < m; y++) {
                final StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < n; x++) {
                    final int number = Integer.parseInt(st.nextToken());
                    dist[x][y][z] = -1;
                    if (number == 1) {
                        queue.addFirst(new int[]{x, y, z});
                        visited[x][y][z] = true;
                        dist[x][y][z] = 1;
                    }
                    graph[x][y][z] = number;
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            final int[] point = queue.removeLast();
            final int x = point[0];
            final int y = point[1];
            final int z = point[2];

            for (int i = 0; i < 6; i++) {
                final int nx = x + dx[i];
                final int ny = y + dy[i];
                final int nz = z + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= n || ny >= m || nz >= h) {
                    continue;
                }
                if (visited[nx][ny][nz]) {
                    continue;
                }
                if (graph[nx][ny][nz] != 0) {
                    continue;
                }

                dist[nx][ny][nz] = dist[x][y][z] + 1;
                visited[nx][ny][nz] = true;
                queue.addFirst(new int[]{nx, ny, nz});
            }
        }

        int max = Integer.MIN_VALUE;
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    if (graph[x][y][z] == -1) {
                        continue;
                    }
                    if (graph[x][y][z] == 0 && !visited[x][y][z]) {
                        return -1;
                    }
                    if (dist[x][y][z] > max) {
                        max = dist[x][y][z];
                    }
                }
            }
        }

        return max -1;
    }
}
