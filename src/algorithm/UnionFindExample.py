class UnionFind:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.rank = [0] * n

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])  # 경로 압축
        return self.parent[x]

    def union(self, x, y):
        rootX = self.find(x)
        rootY = self.find(y)

        if rootX == rootY:
            return

        # rank 기반으로 합치기
        # 낮은 트리를 높은 트리에 붙이기
        if self.rank[rootX] < self.rank[rootY]:
            self.parent[rootX] = rootY
        elif self.rank[rootX] > self.rank[rootY]:
            self.parent[rootY] = rootX
        # rank가 같은 경우 높이가 증가하도록 설정
        else:
            self.parent[rootY] = rootX
            self.rank[rootX] += 1


n = 10
uf = UnionFind(n)

uf.union(0, 1)
uf.union(2, 3)
uf.union(4, 5)
uf.union(6, 7)
uf.union(8, 9)

print(uf.find(1))  # 0
print(uf.find(3))  # 2
print(uf.find(5))  # 4
print(uf.find(7))  # 6
print(uf.find(9))  # 8
