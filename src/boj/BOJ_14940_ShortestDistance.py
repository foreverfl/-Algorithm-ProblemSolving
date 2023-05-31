from collections import deque


def bfs(grid, start):
    rows = len(grid)
    cols = len(grid[0])
    visited = [[0] * cols for _ in range(rows)]
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    queue = deque()
    queue.append(start)
    visited[start[0]][start[1]] = 0

    while queue:
        node = queue.popleft()
        row, col = node

        for direction in directions:
            new_row = row + direction[0]
            new_col = col + direction[1]

            if new_row < 0 or new_row >= rows or new_col < 0 or new_col >= cols:
                continue

            if grid[new_row][new_col] != 1:
                continue

            if visited[new_row][new_col] == 0:
                queue.append((new_row, new_col))
                visited[new_row][new_col] = visited[row][col] + 1

    for i in range(n):
        for j in range(m):
            if (grid[i][j] == 1 and visited[i][j] == 0):
                visited[i][j] = -1

    for i in range(n):
        print(*visited[i])


n, m = map(int, input().split())
start = None
grid = [[0] * m for _ in range(n)]
for i in range(n):
    line = list(map(int, input().split()))
    grid[i] = line
    for j in range(m):
        if grid[i][j] == 2:
            start = (i, j)

bfs(grid, start)
