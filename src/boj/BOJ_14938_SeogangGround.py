INF = 9999999

n, m, r = map(int, input().split())
items = list(map(int, input().split()))

graph = [[INF] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    graph[i][i] = 0

for _ in range(r):
    a, b, l = map(int, input().split())
    graph[a][b] = l
    graph[b][a] = l

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if graph[i][k] + graph[k][j] < graph[i][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

maxItems = 0
for i in range(1, n + 1):
    itemsCollected = items[i - 1]
    for j in range(1, n + 1):
        if i != j and graph[i][j] <= m:
            itemsCollected += items[j - 1]
    maxItems = max(maxItems, itemsCollected)

print(maxItems)
