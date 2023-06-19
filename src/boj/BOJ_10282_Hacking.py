import queue
import sys


class Edge:
    def __init__(self, destination, weight):
        self.destination = destination
        self.weight = weight


def dijkstra(graph, start, size):
    distance = [sys.maxsize] * (size + 1)
    distance[start] = 0

    pq = queue.PriorityQueue()
    pq.put((0, start))
    while not pq.empty():
        dist, vertex = pq.get()
        if dist > distance[vertex]:
            continue

        for neighbor in graph[vertex]:
            new_distance = distance[vertex] + neighbor.weight
            if new_distance < distance[neighbor.destination]:
                distance[neighbor.destination] = new_distance
                pq.put((new_distance, neighbor.destination))

    return distance


T = int(sys.stdin.readline())
for _ in range(T):
    n, d, c = map(int, sys.stdin.readline().split())
    graph = [[] for _ in range(n + 1)]

    for _ in range(d):
        a, b, s = map(int, sys.stdin.readline().split())
        graph[b].append(Edge(a, s))

    dist = dijkstra(graph, c, n)
    cnt = 0
    time = -1
    for i in range(1, n + 1):
        if dist[i] != sys.maxsize:
            cnt += 1
            time = max(time, dist[i])

    print(cnt, time)
