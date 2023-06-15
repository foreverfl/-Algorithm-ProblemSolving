def dijkstra(graph, start):
    numVertices = len(graph)
    distances = [float('inf')] * numVertices
    visited = [False] * numVertices

    distances[start] = 0

    for _ in range(numVertices - 1):
        minDistance = float('inf')
        minIndex = -1

        # minDistance와 minIndex 찾기
        for j in range(numVertices):
            if not visited[j] and distances[j] < minDistance:
                minDistance = distances[j]
                minIndex = j

        visited[minIndex] = True

        for j in range(numVertices):
            if not visited[j] and graph[minIndex][j] != 0 and distances[minIndex] != float('inf') and \
                    distances[minIndex] + graph[minIndex][j] < distances[j]:
                distances[j] = distances[minIndex] + graph[minIndex][j]

    # 최단 경로 출력
    for i in range(numVertices):
        print("Vertex", i, ": Distance =", distances[i])


# 그래프 초기화
graph = [
    [0, 4, 0, 0, 0, 0, 0, 8, 0],
    [4, 0, 8, 0, 0, 0, 0, 11, 0],
    [0, 8, 0, 7, 0, 4, 0, 0, 2],
    [0, 0, 7, 0, 9, 14, 0, 0, 0],
    [0, 0, 0, 9, 0, 10, 0, 0, 0],
    [0, 0, 4, 0, 10, 0, 2, 0, 0],
    [0, 0, 0, 14, 0, 2, 0, 1, 6],
    [8, 11, 0, 0, 0, 0, 1, 0, 7],
    [0, 0, 2, 0, 0, 0, 6, 7, 0]
]

startVertex = 0
dijkstra(graph, startVertex)