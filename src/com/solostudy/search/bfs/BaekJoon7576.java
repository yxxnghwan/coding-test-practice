package com.solostudy.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.StringTokenizer;

public class BaekJoon7576 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static int[][] tomatoes;
    private static boolean[][] visited;
    private static int m;
    private static int n;

    public static void main(String[] args) throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());

        tomatoes = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        final Deque<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoes[i][j] == 1) {
                    queue.addFirst(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            final Point point = queue.removeLast();

            for (int i = 0; i < 4; i++) {
                final Point nPoint = new Point(point.getX() + dx[i], point.getY() + dy[i]);
                if (nPoint.getX() < 0 || nPoint.getY() < 0 || nPoint.getX() >= n || nPoint.getY() >= m) {
                    continue;
                }
                if (tomatoes[nPoint.getX()][nPoint.getY()] != 0) {
                    continue;
                }
                if (visited[nPoint.getX()][nPoint.getY()]) {
                    continue;
                }
                tomatoes[nPoint.getX()][nPoint.getY()] = tomatoes[point.getX()][point.getY()] + 1;
                visited[nPoint.getX()][nPoint.getY()] = true;

                queue.addFirst(nPoint);
            }
        }

        int maxDay = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoes[i][j] == 0) {
                    return -1;
                }

                if (tomatoes[i][j] > maxDay) {
                    maxDay = tomatoes[i][j];
                }
            }
        }

        if (maxDay == 1) {
            return 0;
        }

        return maxDay - 1;
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
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
            return getX() == point.getX() && getY() == point.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    }
}
