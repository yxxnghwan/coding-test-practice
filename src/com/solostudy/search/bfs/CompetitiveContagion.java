package com.solostudy.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class CompetitiveContagion {

    /**
     * 경쟁적 전염
     * <p>
     * NxN 크기의 시험관이 있다. 시험관은 1x1 크기의 칸으로 나누어지며, 특정한 위치에는 바이러스가 존재할 수 있다. 모든 바이러스는 1번부터 K번까지의 바이러스 종류 중 하나에 속한다. 시험관에
     * 존재하는 모든 바이러스는 1초마다 상, 하, 좌, 우의 방향으로 증식해 나간다. 단, 매 초마다 번호가 낮은 종류의 바이러스부터 먼저 증식한다. 또한 증식 과정에서 특정한 칸에 이미 어떠한 바이러스가
     * 존재한다면, 그 곳에는 다른 바이러스가 들어갈 수 없다. 시험관의 크기와 바이러스의 위치 정보가 주어졌을 때, S초가 지난 후에 (X,Y)에 존재하는 바이러스의 종류를 출력하는 프로그램을 작성하시오.
     * 만약 S초가 지난 후에 해당 위치에 바이러스가 존재하지 않는다면, 0을 출력한다. 이 때 X와 Y는 각각 행과 열의 위치를 의미하며, 시험관의 가장 왼쪽 위에 해당하는 곳은 (1,1)에 해당한다.
     * <p>
     * 입력 첫째 줄에 자연수 N, K가 공백을 기준으로 구분되어 주어진다. (1 ≤ N ≤ 200, 1 ≤ K ≤ 1,000) 둘째 줄부터 N개의 줄에 걸쳐서 시험관의 정보가 주어진다. 각 행은 N개의 원소로
     * 구성되며, 해당 위치에 존재하는 바이러스의 번호가 공백을 기준으로 구분되어 주어진다. 단, 해당 위치에 바이러스가 존재하지 않는 경우 0이 주어진다. 또한 모든 바이러스의 번호는 K이하의 자연수로만
     * 주어진다. N+2번째 줄에는 S, X, Y가 공백을 기준으로 구분되어 주어진다. (0 ≤ S ≤ 10,000, 1 ≤ X, Y ≤ N)
     * <p>
     * 출력 S초 뒤에 (X,Y)에 존재하는 바이러스의 종류를 출력한다. 만약 S초 뒤에 해당 위치에 바이러스가 존재하지 않는다면, 0을 출력한다.
     */

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int[] dx = new int[]{0, 0, 1, -1};
    private static final int[] dy = new int[]{1, -1, 0, 0};

    private static int[][] graph;
    private static int n;
    private static int k;
    private static int s;
    private static int x;
    private static int y;

    private static final Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new int[n][n];

        final List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] != 0) {
                    nodes.add(new Node(i, j, graph[i][j], 1));
                }
            }
        }

        nodes.sort(Comparator.comparingInt(Node::getK));

        queue.addAll(nodes);

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(graph[x - 1][y - 1]);
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            final Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = node.getX() + dx[i];
                int nextY = node.getY() + dy[i];

                if (nextX < n && nextY < n && nextX >= 0 && nextY >= 0 && node.getS() <= s) {
                    if (graph[nextX][nextY] == 0) {
                        graph[nextX][nextY] = node.getK();
                        queue.add(new Node(nextX, nextY, node.getK(), node.getS() + 1));
                    }
                }
            }
        }
    }

    static class Node {
        private final int x;
        private final int y;
        private final int k;
        private final int s;

        public Node(final int x, final int y, final int k, final int s) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.s = s;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getK() {
            return k;
        }

        public int getS() {
            return s;
        }
    }
}
