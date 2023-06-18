import sys
import queue

n = int(sys.stdin.readline())
maze = []
for _ in range(n):
    maze.append(list(map(int, sys.stdin.readline().rstrip())))

dx = [1, -1 ,0, 0]
dy = [0, 0, 1, -1]

visited = [[False] * n for _ in range(n)]

def bfs(x, y):
    pq = queue.PriorityQueue()
    pq.put((0, x, y))

    while not pq.empty():
        count, cx, cy = pq.get()
        visited[cx][cy] = True

        if cx == (n - 1) and cy == (n - 1):
            return count

        for i in range(4):
            nx = cx + dx[i]
            ny = cy + dy[i]

            if (0 <= nx < n) and (0 <= ny < n) and not visited[nx][ny]:
                visited[nx][ny] = True
                if maze[nx][ny] == 1: # 흰 방
                    pq.put((count, nx, ny))
                else: # 검은 방
                    pq.put((count + 1, nx, ny))

print(bfs(0, 0))

# reference: https://velog.io/@whddn0221/%EB%B0%B1%EC%A4%80-2665-%EB%AF%B8%EB%A1%9C%EB%A7%8C%EB%93%A4%EA%B8%B0-BFS-%EC%9A%B0%EC%84%A0%EC%88%9C%EC%9C%84-%ED%81%90