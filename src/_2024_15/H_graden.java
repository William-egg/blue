package _2024_15;

import java.util.*;

public class H_graden {
    static int n, s;
    static class Node {
        int value;
        List<Integer> neighbors = new ArrayList<>();
        public Node(int value) {
            this.value = value;
        }
    }
    static Node[] nodes;

    static long countValid(int root) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        visited[root] = true;
        long count = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : nodes[u].neighbors) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                    if (nodes[root].value > nodes[v].value && nodes[root].value % nodes[v].value != 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        s = scan.nextInt();
        nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(scan.nextInt());
        }
        for (int i = 1; i < n; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            nodes[u].neighbors.add(v);
            nodes[v].neighbors.add(u);
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += countValid(i);
        }
        System.out.println(res);
        scan.close();
    }
}