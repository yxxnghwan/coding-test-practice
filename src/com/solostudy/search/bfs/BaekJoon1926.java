package com.solostudy.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class BaekJoon1926 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    static int max = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int m = Integer.parseInt(stringTokenizer.nextToken());

        final Map<Point, Integer> graph = new HashMap<>();
        final Map<Point, Boolean> visited = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                final Point point = new Point(i, j);
                graph.put(point, Integer.parseInt(st.nextToken()));
                visited.put(point, false);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                final Point point = new Point(i, j);
                if (!visited.get(point) && graph.get(point) == 1) {
                    visited.put(point, true);
                    final int size = bfs(graph, visited, point, new Count(), new ArrayDeque<>());
                    count++;
                    if (size > max) {
                        max = size;
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    private static int bfs(final Map<Point, Integer> graph, final Map<Point, Boolean> visited, final Point point,
                           final Count count, final Deque<Point> deque) {
        count.increase();

        final Point point0 = new Point(point.getX() + dx[0], point.getY() + dy[0]);
        addQueue(graph, point0, visited, deque);
        final Point point1 = new Point(point.getX() + dx[1], point.getY() + dy[1]);
        addQueue(graph, point1, visited, deque);
        final Point point2 = new Point(point.getX() + dx[2], point.getY() + dy[2]);
        addQueue(graph, point2, visited, deque);
        final Point point3 = new Point(point.getX() + dx[3], point.getY() + dy[3]);
        addQueue(graph, point3, visited, deque);

        while (!deque.isEmpty()) {
            final Point nextPoint = deque.removeLast();
            bfs(graph, visited, nextPoint, count, deque);
        }

        return count.getValue();
    }

    private static void addQueue(final Map<Point, Integer> graph, final Point point, final Map<Point, Boolean> visited,
                                 final Deque<Point> deque) {
        if (graph.containsKey(point)) {
            if (!visited.get(point)) {
                if (graph.get(point) == 1) {
                    deque.addFirst(point);
                    visited.put(point, true);
                }
            }
        }
    }

    static class Count {
        private int value = 0;

        public void increase() {
            value++;
        }

        public int getValue() {
            return value;
        }
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
