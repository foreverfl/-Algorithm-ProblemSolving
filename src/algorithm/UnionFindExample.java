package algorithm;

public class UnionFindExample {
    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]); // 경로 압축
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY)
                return;

            // rank 기반으로 합치기
            // 낮은 트리를 높은 트리에 붙이기
            if (rank[rootX] < rank[rootY])
                parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY])
                parent[rootY] = rootX;
            // rank가 같은 경우 높이가 증가하도록 설정
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        UnionFind uf = new UnionFind(n);

        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(4, 5);
        uf.union(6, 7);
        uf.union(8, 9);

        System.out.println(uf.find(1)); // 0
        System.out.println(uf.find(3)); // 2
        System.out.println(uf.find(5)); // 4
        System.out.println(uf.find(7)); // 6
        System.out.println(uf.find(9)); // 8
    }

}
