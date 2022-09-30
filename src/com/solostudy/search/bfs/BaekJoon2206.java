package com.solostudy.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

public class BaekJoon2206 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static int[][][] graph;
    private static int[][][] dist;
    private static int n;
    private static int m;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        graph = new int[n][m][2];
        dist = new int[n][m][2];
        visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            final String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j][0] = line.charAt(j) - '0';
                graph[i][j][1] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        visited[0][0][0] = true;
        dist[0][0][0] = 1;
        final Deque<Point> queue = new ArrayDeque<>();
        queue.addFirst(new Point(0, 0, 0));

        while (!queue.isEmpty()) {
            final Point point = queue.removeLast();
            for (int i = 0; i < 4; i++) {
                final int nx = point.getX() + dx[i];
                final int ny = point.getY() + dy[i];
                final int nowCrushCount = point.getCrushCount();
                if (nx < 0 ||ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                int newCrushCount = nowCrushCount;
                if (graph[nx][ny][nowCrushCount] == 1) {
                    if (nowCrushCount >= 1) {
                        continue;
                    }
                    newCrushCount = nowCrushCount + 1;
                }
                if (visited[nx][ny][nowCrushCount]) {
                    continue;
                }
                visited[nx][ny][newCrushCount] = true;
                dist[nx][ny][newCrushCount] = dist[point.getX()][point.getY()][point.getCrushCount()] + 1;
                queue.addFirst(new Point(nx, ny, newCrushCount));
            }
        }

        if (!visited[n-1][m-1][0] && !visited[n-1][m-1][1]) {
            return -1;
        }

        if (dist[n-1][m-1][0] == 0 || dist[n-1][m-1][1] == 0) {
            return dist[n-1][m-1][0] == 0 ? dist[n-1][m-1][1] : dist[n-1][m-1][0];
        }

        return Math.min(dist[n-1][m-1][0], dist[n-1][m-1][1]);
    }

    static class Point {
        private final int x;
        private final int y;
        private final int crushCount;

        public Point(final int x, final int y, final int crushCount) {
            this.x = x;
            this.y = y;
            this.crushCount = crushCount;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCrushCount() {
            return crushCount;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Point)) {
                return false;
            }
            final Point point = (Point) o;
            return getX() == point.getX() && getY() == point.getY() && getCrushCount() == point.getCrushCount();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY(), getCrushCount());
        }
    }
}
