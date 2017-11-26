package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by inonity on 11/25/17.
 */

//https://www.hackerrank.com/challenges/torque-and-development/problem


public class RoadsAndLibraries {

/*
        Graph g = new Graph(6,6,2,5);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(5, 6);
        System.out.println("Minimum cost : ");
        System.out.println(g.DFS());
*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            long x = in.nextLong(); // lib
            long y = in.nextLong(); // road
            Graph g = new Graph(n, m, x, y);
            g.addSingleNodes();
            for (int a1 = 0; a1 < m; a1++) {
                int city_1 = in.nextInt();
                int city_2 = in.nextInt();
                g.addEdge(city_1, city_2);
            }
            System.out.println(g.computeCost());
        }
    }

    public static class Graph {
        long costRoad;
        long costLib;
        int n, m;

        Graph(int n, int m, long costLib, long costRoad) {
            this.costRoad = costRoad;
            this.costLib = costLib;
            this.n = n;
            this.m = m;
        }

        private static class Node {
            Integer name;
            AdjListNode listHead;
            boolean isVisited;

            public Node(Integer name) {
                this.name = name;
            }
        }

        private static class AdjListNode {
            AdjListNode next;
            Node adj;

            AdjListNode(Node adj, AdjListNode next) {
                this.adj = adj;
                this.next = next;
            }
        }

        Map<Integer, Node> nameNodeMap = new HashMap<>();

        void addEdge(Integer c1, Integer c2) {
            Node n1 = nameNodeMap.get(c1);
            Node n2 = nameNodeMap.get(c2);
            n1.listHead = new AdjListNode(n2, n1.listHead);
            n2.listHead = new AdjListNode(n1, n2.listHead);
        }

        void addSingleNodes() {
            for (Integer i = 1; i <= n; i++) {
                nameNodeMap.put(i, new Node(i));
            }
        }

        long computeCost() {
            long answer = 0;
            if (costLib <= costRoad) {
                answer = n * costLib;
                return answer;
            }
            for (Node node : nameNodeMap.values()) {
                if (!node.isVisited) {
                    answer += dfs(node) - costRoad + costLib;
                }
            }
            return answer;
        }

        long dfs(Node node) {
            AdjListNode temp = node.listHead;
            long cost = costRoad;
            node.isVisited = true;
            while (temp != null) {
                if (!temp.adj.isVisited) {
                    cost += dfs(temp.adj);
                }
                temp = temp.next;
            }
            return cost;
        }
    }

}
