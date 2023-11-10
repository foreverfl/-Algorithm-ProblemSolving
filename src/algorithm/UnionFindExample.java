package algorithm;

import java.util.Arrays;

public class UnionFindExample {
    static class UnionFind {
        private int[] parent; // 부모 노드를 저장할 배열

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // 초기에 각 요소의 부모는 자기 자신
            }
        }

        // 요소 u의 루트를 찾는 함수
        public int find(int u) {
            if (u != parent[u]) {
                parent[u] = find(parent[u]); // 경로 압축(모든 노드의 부모를 해당 집합의 루트로 직접 연결)을 통해 효율적으로 루트를 찾음
            }
            return parent[u];
        }

        // 두 요소 u와 v를 하나의 집합으로 합치는 함수
        public void union(int u, int v) {
            u = find(u);
            v = find(v);
            if (u != v) {
                parent[u] = v; // u의 부모를 v로 만듦
            }
        }

        public void printParents() {
            System.out.println(Arrays.toString(parent));
        }

    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10); // 0부터 9까지 10개의 요소로 유니온 파인드 초기화

        System.out.println("초기 상태:");
        uf.printParents(); // 초기 부모 배열 상태 출력

        uf.union(1, 2);
        System.out.println("1과 2를 합친 후:");
        uf.printParents();

        uf.union(2, 3);
        System.out.println("2와 3을 합친 후:");
        uf.printParents();

        uf.union(4, 5);
        System.out.println("4와 5를 합친 후:");
        uf.printParents();

        uf.union(6, 7);
        System.out.println("6와 7를 합친 후:");
        uf.printParents();

        uf.union(7, 8);
        System.out.println("7와 8을 합친 후:");
        uf.printParents();

        System.out.println("1과 3이 같은 집합에 속하는가? " + (uf.find(1) == uf.find(3)));
        System.out.println("4와 5가 같은 집합에 속하는가? " + (uf.find(4) == uf.find(5)));
        System.out.println("1과 8이 같은 집합에 속하는가? " + (uf.find(1) == uf.find(8)));
    }

}
