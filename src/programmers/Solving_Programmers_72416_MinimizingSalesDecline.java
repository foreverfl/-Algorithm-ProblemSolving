package programmers;

import java.util.ArrayList;
import java.util.List;

public class Solving_Programmers_72416_MinimizingSalesDecline {
    static class Node {
        int id;
        int sales;
        List<Node> children = new ArrayList<>();

        public Node(int id, int sales) {
            this.id = id;
            this.sales = sales;
        }
    }

    public static void main(String[] args) {
        int[] sales = { 14, 17, 15, 18, 19, 14, 13, 16, 28, 17 };
        int[][] links = { { 10, 8 }, { 1, 9 }, { 9, 7 }, { 5, 4 }, { 1, 5 }, { 5, 10 }, { 10, 6 }, { 1, 3 },
                { 10, 2 } };
        System.out.println(solution(sales, links));
    }

    public static int solution(int[] sales, int[][] links) {
        // 직원 수에 맞는 노드 배열 생성
        Node[] nodes = new Node[sales.length + 1];
        for (int i = 0; i < sales.length; i++) {
            nodes[i + 1] = new Node(i + 1, sales[i]);
        }

        // 트리 구성
        for (int[] link : links) {
            nodes[link[0]].children.add(nodes[link[1]]);
        }

        int[] answer = dfs(nodes[1]);
        return Math.min(answer[0], answer[1]);
    }

    public static int[] dfs(Node node) {
        if (node.children.isEmpty()) {
            return new int[] { node.sales, 0 }; // 리프 노드의 경우
        }

        int totalCostIfNotAttend = 0;
        int extraCost = Integer.MAX_VALUE; // 자식 중 하나라도 참석해야 하므로, 추가 비용 계산을 위한 변수

        for (Node child : node.children) {
            int[] childCost = dfs(child);
            if (childCost[0] < childCost[1]) {
                // 자식이 참석하는 것이 더 저렴한 경우
                totalCostIfNotAttend += childCost[0];
                extraCost = Math.min(extraCost, childCost[1] - childCost[0]);
            } else {
                // 자식이 참석하지 않는 것이 더 저렴한 경우
                totalCostIfNotAttend += childCost[1];
                extraCost = 0; // 자식 중 한 명이라도 참석하지 않는 경우 추가 비용 없음
            }
        }

        int attendCost = node.children.stream().mapToInt(child -> Math.min(dfs(child)[0], dfs(child)[1])).sum()
                + node.sales;
        int notAttendCost = totalCostIfNotAttend + (extraCost != Integer.MAX_VALUE ? extraCost : 0);

        return new int[] { attendCost, notAttendCost };
    }
}
