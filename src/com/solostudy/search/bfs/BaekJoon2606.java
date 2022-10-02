package com.solostudy.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekJoon2606 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static boolean[] visited;
    private static Map<Integer, Set<Integer>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        final int computerSize = Integer.parseInt(br.readLine());
        for (int i = 1; i <= computerSize; i++) {
            graph.put(i, new HashSet<>());
        }
        visited = new boolean[computerSize + 1];
        final int linkSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < linkSize; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        final Deque<Integer> queue = new ArrayDeque<>();
        visited[1] = true;
        queue.addFirst(1);
        int count = 0;
        while (!queue.isEmpty()) {
            final Integer searchNumber = queue.removeLast();
            for (Integer nextNumber : graph.get(searchNumber)) {
                if (visited[nextNumber]) {
                    continue;
                }
                visited[nextNumber] = true;
                queue.addFirst(nextNumber);
                count++;
            }
        }

        return count;
    }
}
