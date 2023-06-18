import sys
from queue import PriorityQueue


class Edge:
    def __init__(self, destination, weight):
        self.destination = destination
        self.weight = weight

    def __lt__(self, other):
        return self.weight < other.weight


n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    s, e, d = map(int, sys.stdin.readline().split())
    graph[s].append(Edge(e, d))

start, end = map(int, sys.stdin.readline().split())

distances = [float('inf')] * (n + 1)
distances[start] = 0

prev = [-1] * (n + 1)

pq = PriorityQueue()
pq.put(Edge(start, 0))

while not pq.empty():
    current = pq.get()
    vertex = current.destination
    weight = current.weight

    if weight > distances[vertex]:
        continue

    for edge in graph[vertex]:
        new_weight = weight + edge.weight
        if new_weight < distances[edge.destination]:
            distances[edge.destination] = new_weight
            prev[edge.destination] = vertex
            pq.put(Edge(edge.destination, new_weight))

shortest_distance = distances[end]
print(shortest_distance)

path = []
city = end
while city != -1:
    path.append(city)
    city = prev[city]

print(len(path))
print(' '.join(map(str, reversed(path))))
